package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import com.mengjq.assignmentsubmission_spring.util.PublicBanner;
import com.mengjq.assignmentsubmission_spring.util.TimeFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

//添加注解

@RestController
@RequestMapping("/assign")
@CrossOrigin
public class AssignController {

    @Autowired
    private AssignService assignService;

//    //通过构�?�器注入service
//    public AssignController(AssignService assignService){
//        this.assignService=assignService;
//    }

    //查询所有数据 - GET
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

//    根据班级ID获取所有作业信息
    @GetMapping("/class/{id}")
    @ResponseBody
    public List<Assign> getAssignByClassId(@PathVariable("id") String classId){
        System.out.println("获取班级作业信息 classId : " + classId);
        Integer id = Integer.parseInt(classId);
        return assignService.getAssignByClassId(id);
    }

    // 查询Home页面 公开作业 ------
    // 获取公开作业
    @ApiOperation(value = "获取公开作业", notes = "获取公开作业,应用于Tab1, Tab2")
    @GetMapping("/public")
    public List<Assign> getPublicAssign(){
        System.out.println("获取公开作业");
//        TODO: 这里并没有具体实现，查出来都还是所有的作业
        return assignService.getPublicAssign();
    }

    @ApiOperation(value = "获取公开作业 作业角度横幅", notes = "获取公开作业的统计进度,应用于Tab2")
    @GetMapping("/public/tab2AssignBanner")
    public List<PublicBanner> getPublicAssignTab2Banner(){
        System.out.println("获取公开作业 作业角度横幅");
//        q: 我需要的汇总数据是这样 的， 那么应该怎么查询？ [
//                {
//                  name: "已交作业",
//                  num: "123+"
//                },
//                {
//                  name: "未交作业",
//                  num: "123+"
//                },
//                {
//                  name: "提交率",
//                  num: "45%"
//                },
//                {
//                  name: "最近DDL",
//                  num: "3"
//                }
//              ]
//        q: 你举例说明一下吧， 说一下具体语句, sql 的汇总语句
//        a: 1. select count(*) from assign where status = 1
//        a: 2. select count(*) from assign where status = 0
//        a: 3. select count(*) from assign where status = 1 / count(*) from assign
//        a: 4. select min(deadline) from assign
//        q: 那么我应该如何返回这样的数据呢？
//        a: 你可以返回一个list， 里面放这些数据， 然后前端再处理一下

//
        return assignService.getPublicAssignTab2Banner();
    }

//    @ApiOperation(value = "获取各班级 班级度横幅", notes = "获取各班级的统计进度,应用于Tab3")
//    @GetMapping("/public/tab3ClassBanner")
//    public List<Clazz> getPublicAssignTab3Banner(){
//        System.out.println("获取各班级 班级度横幅");
//        return assignService.getPublicAssignTab3Banner();
//    }

    @ApiOperation(value = "获取作业进度", notes = "获取作业进度,应用于Tab3")
    @GetMapping("/{id}/progress")
    public Integer getAssignProgress(@PathVariable("id") String assignId){
        System.out.println("获取作业进度 assignId : " + assignId);
        return assignService.getAssignProgress(assignId);
    }

    // 获取班级所有作业进度
    @GetMapping("/class/{id}/progress")
    public List<Assign> getAssignProgressByClassId(@PathVariable("id") String classId){
        System.out.println("获取班级作业进度 classId : " + classId);
        List<Assign> list = assignService.getAssignProgressByClassId(classId);
        System.out.println("获取班级作业进度 list : " + list);
        Integer id = Integer.parseInt(classId);
        return list;
    }
    // 获取作业进度


    // 根据教师Id 获取所有作业信息（班级内的）
    @ApiOperation(value = "根据教师Id 获取所有作业信息（班级内的）", notes = "根据教师Id 获取所有作业信息（班级内的）")
    @GetMapping("/teacher/{id}")
    public List<Assign> getAssignByTeacherId(@PathVariable("id") String teacherId){
        System.out.println("获取教师作业信息 teacherId : " + teacherId);
        Integer id = Integer.parseInt(teacherId);
        return assignService.getAssignByTeacherId(id);
    }

    // /assign/teacher/assignBanner
    @ApiOperation(value = "获取教师作业信息 作业角度横幅", notes = "获取教师作业信息的统计进度,应用于Tab2")
    @GetMapping("/teacher/assignBanner/{id}")
    public List<PublicBanner> getAssignByTeacherIdBanner(@PathVariable("id") String teacherId){
        System.out.println("获取教师作业信息 作业角度横幅" + teacherId);
//        TODO: 需要改成，根据每个教师的id，获取他的作业信息
//        Integer id = Integer.parseInt(teacherId);
//        return assignService.getAssignByTeacherIdBanner(id);
        return assignService.getPublicAssignTab2Banner();
    }



    //查询数据 - GET
    @GetMapping("/map")
    public Dictionary<Integer, String> selectAssignMap(){
        System.out.println("获取作业Map");
        List<Assign> assigns =  assignService.getAllAssignsMap();

        return turnToMap(assigns);
    }

    //    查询数据 - GET 根据班级
    @GetMapping("/map/class/{id}")
    public Dictionary<Integer, String> selectAssignByClassId(@PathVariable("id") String classId){
        System.out.println("获取作业Map");
        List<Assign> assigns =  assignService.getAssignMapByClassId(classId);

        return turnToMap(assigns);
    }


    //添加数据
    @PostMapping("")
    public Assign insertUser(Assign assign) throws ParseException {
        System.out.println("添加数据"+ assign);
        assign.setDdl(TimeFormat.verifyTimeOrDefault(assign.getDdl()));
        assign.setCreateTime(TimeFormat.getNowTime());

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        assign.setUploadTime(df.parse(assign.getUploadTime()));
        int i = assignService.insert(assign);
        return assign;
    }

    //修改数据
//    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    @PutMapping("/{id}")
    public Integer updateAssign(@PathVariable int id, Assign assign) {
        System.out.println("修改数据");
        assign.setDdl(TimeFormat.verifyTimeOrDefault(assign.getDdl())); // 验证时间格式
        assign.setCreateTime(TimeFormat.verifyTimeOrDefault(assign.getCreateTime())); // 验证时间格式， 如果没有创建时间就用 默认事件

        System.out.println("修改数据"+ assign);
        System.out.println(assign.getTimeoutSubmit());
        return assignService.updateAssign(id, assign);
//        return ResponseEntity.ok(assign);
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


    public Dictionary<Integer, String> turnToMap(List<Assign> assigns) {

        Dictionary<Integer, String> assignsMap = new Hashtable<Integer, String>();
        for (Assign assign: assigns) {
            if (assign.getBriefName() == null) {
                assign.setBriefName("");
            }
            assignsMap.put(assign.getId(), assign.getBriefName());
        }
        System.out.println(assignsMap);  // {1=张三, 2=李四, 3=王五}
        return assignsMap;
    }

}
