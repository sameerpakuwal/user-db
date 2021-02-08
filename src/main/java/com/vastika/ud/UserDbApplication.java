package com.vastika.ud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)

public class UserDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserDbApplication.class, args);
    }

}
