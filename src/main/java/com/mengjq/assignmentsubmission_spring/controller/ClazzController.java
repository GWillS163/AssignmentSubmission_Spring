package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClazzController {
    @Autowired
    private ClazzMapper clazzMapper;

    @GetMapping("/clazz/allInfo")
    public List<Clazz> getClazzAllInfo(){
        List<Clazz> clazzList = clazzMapper.selectList(null);
//        System.out.println(clazzList);
        return clazzList;
    }

    @PostMapping("/clazz")
    public String createClazz(Clazz clazz) {
        int i = clazzMapper.insert(clazz);
//        System.out.println(clazz);
        return returnString(i);
    }

    @DeleteMapping("/clazz/{id}")
    public String deleteClazz(@PathVariable String id) {
        int i = clazzMapper.deleteById(id);

        return returnString(i);
    }

    @PutMapping("/clazz/{id}")
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
