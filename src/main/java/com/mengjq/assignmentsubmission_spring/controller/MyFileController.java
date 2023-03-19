package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.FileMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//添加注解
@RestController
public class MyFileController {

    @Autowired
    private MyFileService myFileService;
    @Autowired
    private FileMapper fileMapper;


    //查询数据
    @GetMapping("/myFile")
    @ResponseBody
    public List<MyFile> selectMyFile(){
        System.out.println("查询数据all");
        //1 构�?�查询条�?
        //1.1 创建查询条件�?
        MyFileExample example = new MyFileExample();
        //1.2 创建条件构�?�器
        MyFileExample.Criteria criteria = example.createCriteria();
        //1.3 通过criteria设置条件
        //...
        return myFileService.selectAll();
    }
    //查询数据
    @GetMapping("/myFile/{myFileId}")
    @ResponseBody
    public MyFile selectMyFileById(@PathVariable String myFileId){
        System.out.println("查询数据" + myFileId);
        MyFile list = myFileService.selectByPrimaryKey(myFileId);
        return list;
    }


    //添加数据
    @PostMapping("/myFile")
    public MyFile insertUser( MyFile myFile){
        System.out.println("添加数据" + myFile);
        fileMapper.insert(myFile);
//        myFileService.insertSelective(myFile);

        return myFile;
    }


    //修改数据
    @PutMapping("/myFile/{id}")
    public MyFile updateUser(@PathVariable String id, MyFile myFile){
        System.out.println("修改数据" + id + " " + myFile);

        myFileService.updateByPrimaryKeySelective(myFile);
        //只返回修改的字段数据
        return myFile;
        //或�??,通过主键,从数据库查询完整的数�?,然后返回
        //return myFileService.selectByPrimaryKey(myFile.getMyFileId);

    }
    //删除数据
    @DeleteMapping("/myFile/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id") Integer myFileId){

        myFileService.deleteByPrimaryKey(myFileId);

        //返回状�?�码
        return "200";
    }
}
