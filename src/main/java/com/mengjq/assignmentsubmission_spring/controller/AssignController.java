package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

//添加注解
@Controller
public class AssignController {

    private AssignService assignService;

    //通过构�?�器注入service
    public AssignController(AssignService assignService){
        this.assignService=assignService;
    }

    //查询数据 - GET
    @GetMapping("/assign")
    @ResponseBody
    public List<Assign> selectAssign(){

        return assignService.getAssigns();
    }

    //查询数据
    @GetMapping("/fakeData")
    @ResponseBody
    public List<Assign> fakeData(){

        //2 根据条件查询
        List<Assign> assigns = new LinkedList<>();
        assigns.add(new Assign());
        return assigns;
    }
    //添加数据
    @PostMapping("/assign")
    @ResponseBody
    public Assign insertUser(@RequestBody Assign assign){
        //准备数据
        //...

        assignService.insert(assign);

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
