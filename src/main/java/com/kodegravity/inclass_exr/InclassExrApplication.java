package com.kodegravity.inclass_exr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/*
* 0206
* - Hibernate (ORM Tool)
* - difference between put/patch HHTP method
 */

@SpringBootApplication
@EnableFeignClients
public class InclassExrApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InclassExrApplication.class, args);

        System.out.println("\n*****\n-> APP RUNNING ON PORT:"+ context.getEnvironment().getProperty("local.server.port") + "\n*****\n");

    }
}