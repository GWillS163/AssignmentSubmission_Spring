package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.TeacherMapper;
import com.mengjq.assignmentsubmission_spring.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherMapper teacherMapper;

    @GetMapping("/teacher/allInfo")
    public List<Teacher> getTeacherAllInfo(){
        return teacherMapper.selectList(null);
    }

    @GetMapping("/teacher/map")
    public List<Teacher> getTeacherMap(){
        System.out.println("获取教师Map");
        List<Teacher> teachers =  teacherMapper.selectTeacherIdMap();
        // put all key and value of teacherIdMap into a new map
        Dictionary<String, String> teacherIdMap = new Hashtable<String, String>();
        for (Teacher teacher : teachers) {
            teacherIdMap.put(teacher.getId(), teacher.getName());
            System.out.println(teacherIdMap);
        }
        System.out.println(teacherIdMap.get("1"));
        return teachers;
    }


}
