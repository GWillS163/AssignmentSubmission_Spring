package com.mengjq.assignmentsubmission_spring.service;

import com.mengjq.assignmentsubmission_spring.model.Assignment;
import com.mengjq.assignmentsubmission_spring.model.AssignmentExample;

//import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;


//public interface AssignmentService extends IService<Assignment>{
public interface AssignmentService {

    Assignment getAssignmentById(Long assignmentId);

//    Admin login(LoginForm loginForm);
//
//    IPage<Admin> getAdminsByOpr(Page<Admin> page, String adminName);


//    //根据条件汇记录数
//    long countByExample(AssignmentExample example);
//    //根据条件删除
//    int deleteByExample(AssignmentExample example);
//    //根据主键删除
//    int deleteByPrimaryKey(Integer assignmentId);
//    //全字段
//    int insert(Assignment record);
//    //
//    int insertSelective(Assignment record);
//    //根据条件查询
//    List<Assignment> selectByExample(AssignmentExample example);
//    //根据主键查询
//    Assignment selectByPrimaryKey(Integer assignmentId);
//    //根据条件有
//    int updateByExampleSelective(Assignment record,AssignmentExample example);
//    //根据条件全字段更
//    int updateByExample(Assignment record,AssignmentExample example);
//    //根据主键有 的更
//    int updateByPrimaryKeySelective(Assignment record);
//    //根据主键全字段的更新
//    int updateByPrimaryKey(Assignment record);

}