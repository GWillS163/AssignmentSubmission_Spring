package com.mengjq.assignmentsubmission_spring;

import com.mengjq.assignmentsubmission_spring.demo.DemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class AssignmentSubmissionSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentSubmissionSpringApplication.class, args);

    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
