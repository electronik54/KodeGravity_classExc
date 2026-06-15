package com.kodegravity.inclass_exr.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GitUser {

    @Id
    private int id;
    private String login;
    private String html_url;
    private String avatar_url;

}
