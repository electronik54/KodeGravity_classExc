package com.kodegravity.inclass_exr.repository;


import com.kodegravity.inclass_exr.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitUserRepo extends JpaRepository<GitUser, Long> {

    Optional<GitUser> findByLogin(String login);



}
