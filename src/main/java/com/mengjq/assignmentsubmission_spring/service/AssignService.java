package com.mengjq.assignmentsubmission_spring.service;

import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.util.PublicBanner;

import java.util.ArrayList;
import java.util.List;


public interface AssignService{
    List<Assign> getAllAssignsInfo();

    //根据主键查询
    List<Assign> selectByPrimaryKey(int id);

    int insert(Assign record);

    int updateAssign(int id, Assign assign);
    //根据主键删除
    int deleteByPrimaryKey(Integer assignId);
//    //根据条件汇�?�记录数
//    long countByExample(AssignExample example);
//    //根据条件删除
//    int deleteByExample(AssignExample example);
    //全字段插�?
//    //有�?�择的插�?
//    int insertSelective(Assign record);
//    //根据条件查询
//    List<Assign> selectByExample(AssignExample example);

//    IPage<Assign> getAssignsByOpr(Page<Assign> page, Assign assign);

    //根据条件有�?�择的更�?
//    int updateByExampleSelective(Assign record,AssignExample example);
//    //根据条件全字段更�?
//    int updateByExample(Assign record,AssignExample example);
    //根据主键有�?�择的更�?
    Integer updateByPrimaryKeySelective(Assign record);

    List<Assign> getAllAssignsMap();

    List<Assign> getAssignMapByClassId(String id);

    List<Assign> getAssignByClassId(Integer id);

    List<Assign> getAssignByTeacherId(Integer id);

    List<Assign> getPublicAssign();

    List<Assign> getAssignProgressByClassId(String id);

    ArrayList<PublicBanner> getPublicAssignTab2Banner();

    Integer getAssignProgress(String id);

    List<PublicBanner> getAssignByTeacherIdBanner(Integer id);

    int countAssignNotFinished();

    int countAllAssigns();
    //根据主键全字段的更新
//    int updateByPrimaryKey(Assign record);

}