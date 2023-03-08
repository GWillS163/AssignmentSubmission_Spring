package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengjq.assignmentsubmission_spring.mapper.UserMapper;
import com.mengjq.assignmentsubmission_spring.model.File;
import com.mengjq.assignmentsubmission_spring.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据id查询用户及文件", notes = "根据id查询用户及文件", httpMethod = "GET")
    @GetMapping("/user/allInfo")
    public List<User> queryAllUserWithFiles(){
        List<User> users = userMapper.selectAllUserWithFiles();
        System.out.println(users.toArray().length);
        return users;
    }


    @GetMapping("/user/find/{username}")
    public List<User> getUserFiles(@PathVariable String username){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        System.out.println(username);
        queryWrapper.eq("username", username);
        List<User> files = userMapper.selectList(queryWrapper);
        return files;
    }
    @GetMapping("/user/findByPage")
    public IPage findByPage( ){
        Page<User> page = new Page<>(0, 2);
        IPage ipage = userMapper.selectPage(page, null);
        return ipage;
    }


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
