package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengjq.assignmentsubmission_spring.mapper.StudentMapper;
import com.mengjq.assignmentsubmission_spring.model.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;


    @ApiOperation(value = "根据id查询用户及文件", notes = "根据id查询用户及文件", httpMethod = "GET")
    @GetMapping("/student/allInfo")
    public List<Student> queryAllUserWithFiles(){
        System.out.println("查询所有用户及文件");
        List<Student> students = studentMapper.selectAllUserWithFiles();
//        System.out.println(students.toArray().length);
        return students;
    }
    @PostMapping("/student")
    public String createUser(Student student) {
        int i = studentMapper.insert(student);
        System.out.println(student);
        return isSuccess(i);
    }

    @PutMapping("/student")
    public String updateUser() {
        return "update student";
    }

    @DeleteMapping("/student/{id}")
    public String deleteById(@PathVariable int id) {
        System.out.println("正在删除用户" + id);
        int i = studentMapper.deleteById(id);
        return isSuccess(i);
    }

    @GetMapping("/student/find/{username}")
    public List<Student> getUserFiles(@PathVariable String username){
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        System.out.println(username);
        queryWrapper.eq("username", username);
        List<Student> files = studentMapper.selectList(queryWrapper);
        return files;
    }
    @GetMapping("/student/findByPage")
    public IPage findByPage(){
        Page<Student> page = new Page<>(0, 2);
        IPage ipage = studentMapper.selectPage(page, null);
        return ipage;
    }

    private String isSuccess(int i) {
        if(i> 0) {
            return "success";
        } else {
            return "fail";
        }
    }

}
