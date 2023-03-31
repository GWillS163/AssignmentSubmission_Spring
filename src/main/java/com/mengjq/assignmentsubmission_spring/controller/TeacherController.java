package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.TeacherMapper;
import com.mengjq.assignmentsubmission_spring.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

//    获取所有教师信息
    @GetMapping("")
    public List<Teacher> getTeacherAllInfo(){
        return teacherMapper.selectList(null);
    }

//    根据教师Id获取教师信息
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable String id){
        return teacherMapper.selectById(id);
    }

    @GetMapping("/map")
    public Dictionary<String, String> getTeacherMap(){
        System.out.println("获取教师Map");
        List<Teacher> teachers =  teacherMapper.selectTeacherIdMap();
        // put all key and value of teacherIdMap into a new map
        Dictionary<String, String> teacherIdMap = new Hashtable<String, String>();
        for (Teacher teacher : teachers) {
            teacherIdMap.put(teacher.getId(), teacher.getName());
        }
        System.out.println(teacherIdMap);  // {1=张三, 2=李四, 3=王五}
        return teacherIdMap;
    }



    @PostMapping("")
    public Teacher insertTeacher(Teacher teacher){
        System.out.println("添加教师" + teacher);
        teacherMapper.insert(teacher);
        return teacher;
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, Teacher teacher){
        System.out.println("修改教师" + teacher);
        teacherMapper.updateById(teacher);
        return teacher;
    }

    @DeleteMapping("/{id}")
    public Integer deleteTeacher(@PathVariable String id){
        System.out.println("删除教师" + id);
        int i = teacherMapper.deleteById(id);
        return i;
    }




}
