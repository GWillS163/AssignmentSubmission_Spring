package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import com.mengjq.assignmentsubmission_spring.model.Teacher;
import com.mengjq.assignmentsubmission_spring.service.ClazzService;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestController
@CrossOrigin
public class ClazzController {

//    @Autowired
//    private ClazzService clazzService;
    @Autowired
    private ClazzMapper clazzMapper;

//    TODO: 仅指定教师ID可访问
    @PostMapping("/class/teacher")
    public List<Clazz> getTeacherClazz(String teacherId){
        System.out.println("获取教师班级 teacherId : " + teacherId);
        // make a queryWrapper
        QueryWrapper<Clazz> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teacher_id", teacherId);
        List<Clazz> clazzList = clazzMapper.selectList(queryWrapper);
//        System.out.println(clazzList);
        return clazzList;
    }
//    TODO: 仅管理员可访问
    @GetMapping("/class/allInfo")
    public List<Clazz> getClazzAllInfo(){
        List<Clazz> clazzList = clazzMapper.selectList(null);
//        System.out.println("获取所有班级信息" + clazzList);
        return clazzList;
    }

    @GetMapping("/class/map")
    public Dictionary<Integer, String> getClazzMap(){
        System.out.println("获取class Map");
//        List<Clazz> clazzes =  clazzService.selectClazzIdMap();
        List<Clazz> clazzes =  clazzMapper.selectClazzIdMap();
        // put all key and value of clazzIdMap into a new map
        Dictionary<Integer, String> clazzIdMap = new Hashtable<Integer, String>();
        for (Clazz clazz : clazzes) {
            if (clazz.getClazzName() == null) {
                clazz.setClazzName("");
            }
            clazzIdMap.put(clazz.getClazzId(), clazz.getClazzName());
        }
        System.out.println(clazzIdMap);  // {1=张三, 2=李四, 3=王五}
        return clazzIdMap;
    }

    @PostMapping("/class")
    public String createClazz(Clazz clazz) {
        System.out.println("新增班级: " + clazz);
        int i = clazzMapper.insert(clazz);
        return returnString(i);
    }

    @DeleteMapping("/class/{id}")
    public String deleteClazz(@PathVariable String id) {
        System.out.println("删除班级: " + id);
        int i = clazzMapper.deleteById(id);
        return returnString(i);
    }

    @PutMapping("/class/{id}")
    public String updateClazz(@PathVariable int id, Clazz clazz) {

        System.out.println("修改班级: " +clazz.getClazzId() +
                " " +clazz);
        clazz.setClazzId(id);
        int i = clazzMapper.updateById(clazz);
        return returnString(i);
    }

    private String returnString(int i) {
        if(i> 0) {
            return "success";
        } else {
            return "fail";
        }
    }

// TODO: Test   download  file
@GetMapping(value = "/get-file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
public ResponseEntity<byte[]> getFile() throws IOException {
    System.out.println("下载测试文件");
        String[] header = { "Name", "Age", "City" };
    List<String[]> rows = new ArrayList<>();
    rows.add(new String[] { "John", "25", "New York" });
    rows.add(new String[] { "Jane", "30", "London" });
    rows.add(new String[] { "Bob", "40", "Paris" });
    rows.add(new String[] { "Mary", "35", "Berlin" });
    rows.add(new String[] { "Mike", "45", "New York" });

    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         CSVWriter writer = new CSVWriter(new OutputStreamWriter(outputStream))) {
        writer.writeNext(header);
        writer.writeAll(rows);
        writer.flush();
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment;" +
                        " filename=example.csv")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(outputStream.toByteArray());
    }
}

}
