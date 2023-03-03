package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.UserMapper;
import com.mengjq.assignmentsubmission_spring.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户", httpMethod = "GET")
    @GetMapping("/user")
    public List<User> query(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users.toArray().length);
        return users;
    }

    @PostMapping("/user")
    public String createUser(User user) {
        int i = userMapper.insert(user);
        System.out.println(user);
        if(i> 0) {
            return "success";
        } else {
            return "fail";
        }
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
