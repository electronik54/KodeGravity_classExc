package com.kodegravity.inclass_exr.dto;

import lombok.Data;

@Data
public class GitUser {
    private String login;
    private Integer id;
    private String avatar_url;
    private String html_url;
}
