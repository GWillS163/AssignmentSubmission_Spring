package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class ClazzController {
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

        System.out.println("修改班级: " +clazz.getId() +
                " " +clazz);
        clazz.setId(id);
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
//        return a file with test content
    public ResponseEntity<Resource> getFile() throws IOException {
//        Resource resource = new ClassPathResource("static/test.jpg");
        Resource resource = new ClassPathResource("static/conf.ini");
        String data = "hello world";
        resource.getInputStream().read(Objects.requireNonNull(data.getBytes()));
//        InputStream inputStream = resource.getInputStream();
        return ResponseEntity.ok()
                .header("Content-Disposition",
                        "attachment; filename=" +
                                resource.getFilename())

                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
