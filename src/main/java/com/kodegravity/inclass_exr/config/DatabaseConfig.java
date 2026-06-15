package com.kodegravity.inclass_exr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired //@Resource(name = "dataSource")
    DataSource dataSource;

    @Bean
    public JdbcTemplate getJdbcTemplate() {return new JdbcTemplate(dataSource);}
}
