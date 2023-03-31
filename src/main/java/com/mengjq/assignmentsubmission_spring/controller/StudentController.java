package com.mengjq.assignmentsubmission_spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengjq.assignmentsubmission_spring.mapper.StudentMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.model.Student;
import com.mengjq.assignmentsubmission_spring.util.TimeFormat;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

//    查询所有用户，无文件
    @GetMapping("")
    public List<Student> getAllStudents(){
        System.out.println("获取所有学生");
        List<Student> students = studentMapper.selectList(null);
        return students;
    }

// 查询所有用户及文件
    @ApiOperation(value = "根据id查询用户及文件", notes = "根据id查询用户及文件", httpMethod = "GET")
    @GetMapping("/allInfo")
    public List<Student> queryAllUserWithFiles(){
        System.out.println("查询所有用户及文件");
        List<Student> students = studentMapper.selectAllUserWithFiles();
        return students;
    }

//    根据学生ID 查询用户
    @GetMapping("/{id}")
    public Student queryStudentById(@PathVariable int id){
        System.out.println("查询学生 id : " + id);
        Student student = studentMapper.selectById(id);
        return student;
    }

//    根据班级查询学生
    @GetMapping("/class/{classId}")
    public List<Student> queryStudentByClassId(@PathVariable String classId){
        System.out.println("查询班级学生 classId : " + classId);
        // make a queryWrapper
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("clazz_id", classId);
        List<Student> students = studentMapper.selectList(queryWrapper);
        return students;
    }

//    根据教师ID查询所有学生
    @GetMapping("/teacher/{teacherId}")
    public List<Student> queryStudentByTeacherId(@PathVariable String teacherId){
        System.out.println("查询教师学生 teacherId : " + teacherId);
        List<Student> students = studentMapper.selectListByTeacherId(teacherId);
        return students;
    }


    public String turnToTimestamp(){
        Date date = new Date();
        return String.valueOf(date.getTime());
    }

//    @GetMapping("/map")
//    public Dictionary<Integer, String> selectAssignMap(){
//        System.out.println("获取作业Map");
//        List<Assign> assigns =  assignService.getAllAssignsMap();
//
//        Dictionary<Integer, String> assignsMap = new Hashtable<Integer, String>();
//        for (Assign assign: assigns) {
//            if (assign.getBriefName() == null) {
//                assign.setBriefName("");
//            }
//            assignsMap.put(assign.getId(), assign.getBriefName());
//        }
//        System.out.println(assignsMap);  // {1=张三, 2=李四, 3=王五}
//        return assignsMap;
//    }

    @GetMapping("/map")
    public Dictionary<Integer, String > selectStudentMap() {
        System.out.println("获取学生Map");
        List<Student> students = studentMapper.selectList(null);
        Dictionary<Integer, String> studentsMap = new Hashtable<Integer, String>();
        for (Student student: students) {
            if (student.getUsername() == null) {
                student.setUsername("");
            }
            studentsMap.put(student.getUserId(), student.getUsername());
        }
        System.out.println(studentsMap);  // {1=张三, 2=李四, 3=王五}
        return studentsMap;
    }


    @PostMapping("")
    public String createUser(Student student) {
        System.out.println("正在创建用户" + student.getUsername());
        System.out.println();
        student.setRegisterTime(TimeFormat.getNowTime());
        int i = studentMapper.insert(student);
        System.out.println(student);
        return isSuccess(i);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, Student student) {
        System.out.println("正在更新用户" + id);
        // fix registerTime & lastLoginTime value is null
        student.setUserId(id);
        student.setRegisterTime(TimeFormat.verifyNull(student.getRegisterTime()));
        student.setLastLoginTime(TimeFormat.verifyNull(student.getLastLoginTime()));
        student.setDescription(TimeFormat.verifyNull(student.getDescription()));

        System.out.println(student);
        int i = studentMapper.updateById(student);
        return isSuccess(i);

    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        System.out.println("正在删除用户" + id);
        int i = studentMapper.deleteById(id);
        return isSuccess(i);
    }

    @GetMapping("/find/{username}")
    public List<Student> getUserFiles(@PathVariable String username){
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        System.out.println(username);
        queryWrapper.eq("username", username);
        List<Student> files = studentMapper.selectList(queryWrapper);
        return files;
    }

    @GetMapping("/findByPage")
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
