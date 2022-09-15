package com.mengjq.assignmentsubmission_spring.mapper;

import com.mengjq.assignmentsubmission_spring.model.Assignment;
import com.mengjq.assignmentsubmission_spring.model.AssignmentExample;
import java.util.List;

//@Mapper
public interface AssignmentMapper {
    long countByExample(AssignmentExample example);

    int deleteByExample(AssignmentExample example);

    int deleteByPrimaryKey(Integer assiid);

    Assignment selectByPrimaryKey(Long assignmentId);
}