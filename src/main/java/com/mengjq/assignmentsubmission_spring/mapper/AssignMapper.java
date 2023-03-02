package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.model.AssignWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssignMapper extends BaseMapper<Assign> {
    int deleteByPrimaryKey(Integer assiid);

    int insert(AssignWithBLOBs record);

    int insertSelective(AssignWithBLOBs record);

    List<Assign> selectByPrimaryKey(int assiid);

    int updateByPrimaryKeySelective(Assign record);

    int updateByPrimaryKeyWithBLOBs(AssignWithBLOBs record);

    int updateByPrimaryKey(Assign record);
}