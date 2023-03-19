package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.FileMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class FileController {

    @Autowired
    private FileMapper fileMapper;

    @GetMapping("/file/allInfo")
    public List<MyFile> getFileWithUser(){
        List<MyFile> myFiles = fileMapper.selectAllFileWithUser();
        System.out.println(myFiles);
        return myFiles;
    }


    @GetMapping("/file/{user_id}") // Test OK
    public List<MyFile> getFileById(@PathVariable String user_id) {
        System.out.println("user_id: " + user_id);
        List<MyFile> myFiles = fileMapper.findByUserId("1");
        System.out.println(myFiles);
        if (myFiles == null) {
            System.out.println("null");
            return null;
        }
        return myFiles;
    }
}
