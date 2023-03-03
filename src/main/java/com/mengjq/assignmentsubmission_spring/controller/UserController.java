package com.mengjq.assignmentsubmission_spring.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户", httpMethod = "GET")
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "user id is " + id;
    }

    @PostMapping("/user")
    public String createUser() {
        return "create user";
    }

    @PutMapping("/user")
    public String updateUser() {
        return "update user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id) {
        return "delete user" + id;
    }
}
