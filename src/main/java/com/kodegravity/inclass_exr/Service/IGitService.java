package com.kodegravity.inclass_exr.Service;

import com.kodegravity.inclass_exr.dto.GitUser;

public interface IGitService {
    GitUser getUserViaRestService(String uN);
    com.kodegravity.inclass_exr.entity.GitUser getGitUser(String uN);
}
