package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.AssignMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

//添加注解

@RestController
@RequestMapping("/assign")
@CrossOrigin
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
    @GetMapping("")
    public List<Assign> selectAssign(){
        System.out.println("查询所有数据");
        return assignService.getAllAssignsInfo();
    }

    //查询数据 指定 - GET d 
    @GetMapping("/{id}")
    public List<Assign> selectAssignById(@PathVariable("id") String assignId){
        System.out.println("查询指定数据" + assignId);
        Integer id = Integer.parseInt(assignId);
        return assignService.selectByPrimaryKey(id);
    }


    //添加数据
    @PostMapping("")
    public Assign insertUser(Assign assign) throws ParseException {
        System.out.println("添加数据"+ assign);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        assign.setUploadTime(df.parse(assign.getUploadTime()));
        int i = assignService.insert(assign);
        return assign;
    }

    //修改数据
//    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    @PutMapping("/{id}")
    public ResponseEntity<Assign> updateAssign(@PathVariable int id, Assign assign) {
//    public ResponseEntity<Assign> updateAssign(@PathVariable int id, @ModelAttribute Assign assign) {
        System.out.println("修改数据"+ assign);
        Assign updatedAssign = assignService.updateAssign(id, assign);
        return ResponseEntity.ok(updatedAssign);
    }


    //删除数据
    @DeleteMapping("/{id}")
    @ResponseBody
    public String delUser(@PathVariable("id") String assignId){
        System.out.println("删除数据"+ assignId);
        Integer id = Integer.parseInt(assignId);
        assignService.deleteByPrimaryKey(id);

        //返回状码
        return "200";
    }
}
