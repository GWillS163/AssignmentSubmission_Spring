package com.mengjq.assignmentsubmission_spring.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mengjq.assignmentsubmission_spring.model.Assign;

import java.util.List;


public interface AssignService{
//    //根据条件汇�?�记录数
//    long countByExample(AssignExample example);
//    //根据条件删除
//    int deleteByExample(AssignExample example);
    //根据主键删除
    int deleteByPrimaryKey(Integer assignId);
    //全字段插�?
    int insert(Assign record);
//    //有�?�择的插�?
//    int insertSelective(Assign record);
//    //根据条件查询
//    List<Assign> selectByExample(AssignExample example);
//    //根据主键查询
//    List<Assign> selectByPrimaryKey(int assignId);

    List<Assign> getAssigns();
//    IPage<Assign> getAssignsByOpr(Page<Assign> page, Assign assign);

    //根据条件有�?�择的更�?
//    int updateByExampleSelective(Assign record,AssignExample example);
//    //根据条件全字段更�?
//    int updateByExample(Assign record,AssignExample example);
    //根据主键有�?�择的更�?
    int updateByPrimaryKeySelective(Assign record);
    //根据主键全字段的更新
//    int updateByPrimaryKey(Assign record);

}