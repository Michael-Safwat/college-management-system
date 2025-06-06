package com.michael.college_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class CollegeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeManagementSystemApplication.class, args);
    }

}
