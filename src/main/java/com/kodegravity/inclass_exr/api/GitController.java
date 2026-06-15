package com.kodegravity.inclass_exr.api;

import com.kodegravity.inclass_exr.Service.IGitService;
import com.kodegravity.inclass_exr.dto.GitUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/git")
@AllArgsConstructor
public class GitController {

    final IGitService gitService;

    @GetMapping(value = "/isAvailable")
    public boolean isAvailable(){
        return true;
    }

    @GetMapping(value = "/getUserViaRestTemplate")
    public GitUser getUserRestTemp(@RequestParam("uN")String uN){
        return gitService.getUserViaRestService(uN);
    }

    @GetMapping(value = "/getUser")
    public com.kodegravity.inclass_exr.entity.GitUser getUser(@RequestParam("uN")String uN){
        return gitService.getGitUser(uN);
    }
}