package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.MyFileMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.service.MyFileService;
import com.mengjq.assignmentsubmission_spring.util.FileIO;
import com.mengjq.assignmentsubmission_spring.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

//添加注解
@RestController
@CrossOrigin
@RequestMapping("/myFile")
public class MyFileController {

    @Autowired
    private MyFileService myFileService;
    private String assignId;


    //查询数据
    @GetMapping("")
    @ResponseBody
    public List<MyFile> selectMyFile() {
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

    @GetMapping("/allInfo")
    public List<MyFile> selectMyFileWithInfo() {
        System.out.println("查询数据all");
        return myFileService.selectMyFileWithInfo();
    }
//    根据作业查询作业
    @GetMapping("/assign/{assignId}")
    @ResponseBody
    public List<MyFile> selectMyFileByAssignId(@PathVariable String assignId) {
        System.out.println("查询数据" + assignId);
        return myFileService.findByAssignId(assignId);
    }
//    根据班级查询作业
    @GetMapping("/class/{classId}")
    @ResponseBody
    public List<MyFile> selectMyFileByClassId(@PathVariable String classId) {
        System.out.println("班级id 查询数据" + classId);
        return myFileService.findByClassId(classId);
    }

    @GetMapping("/student/{studentId}")
    public List<MyFile> selectMyFileByStudentId(@PathVariable String studentId) throws IOException {
//        数据查询
        List<MyFile> myFile = myFileService.selectByStudentId(studentId);
        System.out.println(myFile);

        return myFile;
    }

//    获取单个文件信息
    @GetMapping("/{myFileId}")
    public MyFile selectMyFileById(@PathVariable String myFileId) {
        System.out.println("查询数据" + myFileId);
        return myFileService.selectByPrimaryKey(myFileId);
    }


    @GetMapping("/{myFileId}/download")
    public ResponseEntity<InputStreamResource> downloadMyFileById(@PathVariable String myFileId) throws IOException {
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

    // 获取公开页面 最近作业提交信息
    @GetMapping("/public")
    public List<MyFile> selectMyFilePublic() {
        System.out.println("查询公开提交数据");
        // get current Time with format
        String currentTime = TimeFormat.getBeforeNowDays(30);
        System.out.println("查询时间" + currentTime);
        return myFileService.selectMyFilePublic(currentTime);
    }



    //添加数据
    @PostMapping("")
    public MyFile insertUser(MyFile myFile, @RequestParam("fileData") MultipartFile fileData) throws IOException {
        System.out.println("添加数据1" + myFile);
        System.out.println("添加数据2" + fileData);
//      修订值
        MyFile myFileRevised = reviseValues(myFile, fileData);

//        数据库插入
        System.out.println("添加数据：" + myFileRevised);
        myFileService.insert(myFileRevised);
        // q: 为什么这里插入数据在插入之前有hash值, 但插入数据库之后，在数据库中没有hash值了。
        // a:


//        本地文件保存
        FileIO.saveFile(fileData, myFileRevised.getSavePath());

        return myFileRevised;
    }

    //添加数据
    @PostMapping("/student")
    public MyFile insertFileByStudent(MyFile myFile, Integer userId, @RequestParam("fileData") MultipartFile fileData) throws IOException {
        System.out.println("添加数据1" + myFile);
        System.out.println("添加数据2" + fileData);

//      修订值
        MyFile myFileRevised = reviseValues(myFile, fileData);
        myFileRevised.setUserId(userId);
//        数据库插入
        System.out.println("添加数据" + myFileRevised);
        myFileService.insert(myFileRevised);

//        本地文件保存
        FileIO.saveFile(fileData, myFileRevised.getSavePath());

        return myFileRevised;
    }

    public MyFile reviseValues(MyFile myFile, MultipartFile fileData) throws IOException {
        if (fileData == null) {
            return myFile;
        }
//      修订值
        // replace last dot with time
        // q: the answer you gived is not correct, it will replace all dots in the string
        // a: I know, but I don't know how to replace the last dot
        // get the last dot index
        int lastDotIndex = fileData.getOriginalFilename().lastIndexOf(".");
        // replace the last dot with time
        String saveName = fileData.getOriginalFilename().substring(0, lastDotIndex)
                + "_" + System.currentTimeMillis()
                + fileData.getOriginalFilename().substring(lastDotIndex);
        System.out.println("saving Name: " + saveName);
        System.out.println("file size: " + fileData.getSize());

        myFile.setRawName(fileData.getOriginalFilename());
        myFile.setSavePath(saveName);
        myFile.setFileSize((int) fileData.getSize());
        myFile.setHash(FileIO.calculateHash(fileData));
        myFile.setUploadTime(TimeFormat.getNowTime());
//        System.out.println("Hash value: " + myFile.getHash());

        return myFile;
    }

    //修改数据
    @PutMapping("/{id}")
    public int updateUser(@PathVariable String id, MyFile myFile, @Nullable @RequestParam("fileData") MultipartFile fileData) throws IOException {
        System.out.println("修改数据" + id + " " + myFile);
        MyFile myFileRevised = reviseValues(myFile, fileData);
//        myFileService.updateByPrimaryKeySelective(myFile);
//        fileMapper.updateByPrimaryKey(myFile);

        //只返回修改的字段数据
        myFileRevised.setFileId(Integer.parseInt(id));
        return myFileService.updateByPrimaryKey(myFileRevised);
        //或�??,通过主键,从数据库查询完整的数�?,然后返回
        //return myFileService.selectByPrimaryKey(myFile.getMyFileId);
    }

    //删除数据
    @DeleteMapping("/{id}")
    public String delUser(@PathVariable("id") Integer myFileId) {
        System.out.println("删除数据" + myFileId);
//        查询本地文件
        MyFile myFile = myFileService.selectByPrimaryKey(myFileId.toString());
//       TODO： 删除本地文件 似乎并没有完成
        String path = System.getProperty("user.dir") + "/upload/";
//        delete file from local
        FileIO.deleteFile(path + myFile.getRawName());

        myFileService.deleteByPrimaryKey(myFileId);

        //返回状�?�码
        return "200";
    }
}
