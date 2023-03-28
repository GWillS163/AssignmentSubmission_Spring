package com.mengjq.assignmentsubmission_spring.service;

import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import java.lang.String;
import java.util.List;


public interface MyFileService{
    //根据条件汇�?�记录数
    long countByExample(MyFileExample example);
    //根据条件删除
    int deleteByExample(MyFileExample example);
    //根据主键删除
    int deleteByPrimaryKey(Integer myFileId);
    //全字段插�?
    int insert(MyFile record);
    //有�?�择的插�?
    int insertSelective(MyFile record);
    //根据条件查询
    List<MyFile> selectByExample(MyFileExample example);
    //根据主键查询
    MyFile selectByPrimaryKey(String myFileId);
    //根据条件有�?�择的更�?
    int updateByExampleSelective(MyFile record,MyFileExample example);
    //根据条件全字段更�?
    int updateByExample(MyFile record,MyFileExample example);
    //根据主键有�?�择的更�?
    int updateByPrimaryKeySelective(MyFile record);
    //根据主键全字段的更新
    int updateByPrimaryKey(MyFile record);

    List<MyFile> selectAll();

    List<MyFile> selectByStudentId(String studentId);
}