package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.AssignMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

//添加注解
@RestController
public class AssignController {

    @Autowired
    private AssignService assignService;
    @Autowired
    private AssignMapper assignMapper;

//    //通过构�?�器注入service
//    public AssignController(AssignService assignService){
//        this.assignService=assignService;
//    }

    //查询数据 - GET
    @GetMapping("/assign/allInfo")
    public List<Assign> selectAssign(){
        System.out.println("查询所有数据");
        return assignService.getAllAssignsInfo();
    }


    //添加数据
    @PostMapping("/assign")
    public Assign insertUser(Assign assign) throws ParseException {
        System.out.println("添加数据"+ assign);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        assign.setUploadTime(df.parse(assign.getUploadTime()));
        int i = assignService.insert(assign);

        return assign;
    }
    //修改数据
    @PutMapping("/assign")
    @ResponseBody
    public Assign updateUser(@RequestBody Assign assign){
        //准备数据
        //...

        assignService.updateByPrimaryKeySelective(assign);
        //只返回修改的字段数据
        return assign;
        //或通过主键,从数据库查询完整的数然后返回
        //return assignService.selectByPrimaryKey(assign.getAssignId);

    }
    //删除数据
    @DeleteMapping("/assign/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id") String assignId){
        System.out.println("删除数据"+ assignId);
        Integer id = Integer.parseInt(assignId);
        assignService.deleteByPrimaryKey(id);

        //返回状码
        return "200";
    }
}
