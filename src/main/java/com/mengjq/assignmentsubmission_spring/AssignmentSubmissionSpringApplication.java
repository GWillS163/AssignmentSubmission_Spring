package com.mengjq.assignmentsubmission_spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication(scanBasePackages = "com.mengjq.assignmentsubmission_spring.*")
@MapperScan("com.mengjq.assignmentsubmission_spring.mapper")
public class AssignmentSubmissionSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentSubmissionSpringApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
