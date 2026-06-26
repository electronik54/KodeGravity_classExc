package com.kodegravity.inclass_exr.Service;

import com.kodegravity.inclass_exr.dto.GitUser;
import com.kodegravity.inclass_exr.repository.GitUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GitServiceImpl implements IGitService {

    final RestTemplate restTemplate;
    final WebClient webClient;

    @Autowired
    GitUserRepo gitUserRepo;


    @Value("${github.url}")
    String gitUrl;
    @Value("${github.userspath}")
    String userEndpoint;

    @Override
    public GitUser getUserViaRestService(String uN) {
        StringBuilder url = new StringBuilder(gitUrl);
        url.append(userEndpoint).append(uN);
        GitUser gitUser = restTemplate.getForObject(url.toString(), GitUser.class);
        return gitUser;
    }

    @Override
    public com.kodegravity.inclass_exr.entity.GitUser getGitUser(String uN) {

        Optional<com.kodegravity.inclass_exr.entity.GitUser> userByLogin = gitUserRepo.findByLogin(uN);

        if (userByLogin.isPresent()) {

            return userByLogin.get();

        } else {

            //fetch user form github
            StringBuilder url = new StringBuilder(gitUrl);
            url.append(userEndpoint).append(uN);
            GitUser fetchedUser = webClient
                    .get()
                    .uri(url.toString())
                    .retrieve()
                    .bodyToMono(GitUser.class)
                    .timeout(Duration.ofSeconds(1000))
////                    .onErrorReturn(new GitUser())
                    .block();

            //<check if the <fetchedUser> exists here>

            com.kodegravity.inclass_exr.entity.GitUser gitUser = new com.kodegravity.inclass_exr.entity.GitUser()
                    .builder()
                    .id(fetchedUser.getId())
                    .login(fetchedUser.getLogin())
                    .avatar_url(fetchedUser.getAvatar_url())
                    .html_url(fetchedUser.getHtml_url())
                    .build();

            //insert in DB
            gitUserRepo.save(gitUser);
            return gitUser;
        }
    }
}