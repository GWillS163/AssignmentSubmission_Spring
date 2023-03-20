package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.MyFileMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.service.MyFileService;
import com.mengjq.assignmentsubmission_spring.util.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

//添加注解
@RestController
public class MyFileController {

    @Autowired
    private MyFileService myFileService;
    @Autowired
    private MyFileMapper myFileMapper;


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
        System.out.println("添加数据");
//        System.out.println("添加数据2" + fileData);

//      修订值
        String saveName = fileData.getOriginalFilename().replace(".", "_" +System.currentTimeMillis()+ ".");
        System.out.println("saving Name: " + saveName);
        myFile.setRawName(fileData.getOriginalFilename());
        myFile.setSavePath(saveName);
        myFile.setFileSize((int) fileData.getSize());
        System.out.println("file size: " + fileData.getSize());
        myFile.setHash(FileIO.calculateHash(fileData));
//        数据库插入
        System.out.println("添加数据" + myFile);
        myFileMapper.insert(myFile);

//        本地文件保存
        FileIO.saveFile(fileData, saveName);

        return myFile;
    }


    //修改数据
    @PutMapping("/myFile/{id}")
    public int updateUser(@PathVariable String id, MyFile myFile){
        System.out.println("修改数据" + id + " " + myFile);

//        myFileService.updateByPrimaryKeySelective(myFile);
//        fileMapper.updateByPrimaryKey(myFile);
        //只返回修改的字段数据
        myFile.setFileId(Integer.parseInt(id));
        return myFileService.updateByPrimaryKey(myFile);
        //或�??,通过主键,从数据库查询完整的数�?,然后返回
        //return myFileService.selectByPrimaryKey(myFile.getMyFileId);

    }
    //删除数据
    @DeleteMapping("/myFile/{id}")
    public String delUser(@PathVariable("id") Integer myFileId) {
        System.out.println("删除数据" + myFileId);
//        查询本地文件
        MyFile myFile = myFileService.selectByPrimaryKey(myFileId.toString());
//        删除本地文件
        String path = System.getProperty("user.dir") + "/upload/";
//        delete file from local
        FileIO.deleteFile(path + myFile.getRawName());

        myFileService.deleteByPrimaryKey(myFileId);

        //返回状�?�码
        return "200";
    }
}
