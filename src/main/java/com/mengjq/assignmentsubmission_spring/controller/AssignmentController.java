package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.model.Assignment;
import com.mengjq.assignmentsubmission_spring.model.AssignmentExample;
import com.mengjq.assignmentsubmission_spring.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//添加注解
@Controller
public class AssignmentController {

    private AssignmentService assignmentService;

    //通过构�?�器注入service
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService=assignmentService;
    }

    //查询数据
    @GetMapping("/assignment")
    @ResponseBody
    public List<Assignment> selectAssignment(){
        //1 构�?�查询条�?
        //1.1 创建查询条件�?
        AssignmentExample example = new AssignmentExample();
        //1.2 创建条件构�?�器
        AssignmentExample.Criteria criteria = example.createCriteria();
        //1.3 通过criteria设置条件
        //...

        // create an interger list  with fake data [1,1,1]
        long a = 1;
        // assignmentService.getAssignmentById(a);
        //2 调用service的方法查询数据
        List<Assignment> list = (List<Assignment>) assignmentService.getAssignmentById(a);

        return list;
    }

//    //添加数据
//    @PostMapping("/assignment")
//    @ResponseBody
//    public Assignment insertUser(@RequestBody Assignment assignment){
//        //准备数据
//        //...
//
//        assignmentService.insertSelective(assignment);
//
//        return assignment;
//    }
//    //修改数据
//    @PutMapping("/assignment")
//    @ResponseBody
//    public Assignment updateUser(@RequestBody Assignment assignment){
//        //准备数据
//        //...
//
//        assignmentService.updateByPrimaryKeySelective(assignment);
//        //只返回修改的字段数据
//        return assignment;
//        //或�??,通过主键,从数据库查询完整的数�?,然后返回
//        //return assignmentService.selectByPrimaryKey(assignment.getAssignmentId);
//
//    }
//    //删除数据
//    @DeleteMapping("/assignment/{id}")
//    @ResponseBody
//    public String delUser(@PathVariable("id") Integer assignmentId){
//
//        assignmentService.deleteByPrimaryKey(assignmentId);
//
//        //返回状�?�码
//        return "200";
//    }
}
