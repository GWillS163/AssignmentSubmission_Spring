package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.FileMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.service.MyFileService;
import com.mengjq.assignmentsubmission_spring.util.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
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

@GetMapping("/myFile/{myFileId}")
public ResponseEntity<InputStreamResource> selectMyFileById(@PathVariable String myFileId) throws IOException {
//        数据查询
    MyFile myFile = myFileService.selectByPrimaryKey(myFileId);
    String fileName = myFile.getRawName();
    System.out.println("downloading file " + fileName);

//    文件下载
    String path = System.getProperty("user.dir") + "/upload/";
    File file = new File(path + fileName);
    InputStreamResource resource = FileIO.readFile(file);

//    返回数据
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "attachment;filename=" + fileName);
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");

    return ResponseEntity.ok()
            .headers(headers)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/octet-stream"))
            .body(resource);
}


    //添加数据
    @PostMapping("/myFile")
    public MyFile insertUser(MyFile myFile, MultipartFile fileData) throws IOException {
        System.out.println("添加数据1" + myFile);
        System.out.println("添加数据2" + fileData);

//        数据库插入
        myFile.setRawName(fileData.getName());
        fileMapper.insert(myFile);

//        本地文件上传
        FileIO.saveFile(fileData);

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
