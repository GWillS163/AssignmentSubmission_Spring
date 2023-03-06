package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengjq.assignmentsubmission_spring.mapper.FileMapper;
import com.mengjq.assignmentsubmission_spring.model.File;
import com.mengjq.assignmentsubmission_spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileController {

    @Autowired
    private FileMapper fileMapper;

    @GetMapping("/file/allInfo")
    public List<File> getFileWithUser(){
        List<File> files = fileMapper.selectAllFileWithUser();
        System.out.println(files);
        return files;
    }


    @GetMapping("/file/{user_id}") // Test OK
    public List<File> getFileById(@PathVariable String user_id) {
        System.out.println("user_id: " + user_id);
        List<File> files = fileMapper.findByUserId("1");
        System.out.println(files);
        if (files == null) {
            System.out.println("null");
            return null;
        }
        return files;
    }
}
