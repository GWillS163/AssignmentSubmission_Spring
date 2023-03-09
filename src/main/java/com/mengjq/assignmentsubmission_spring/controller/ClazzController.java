package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(clazzList);
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

}
