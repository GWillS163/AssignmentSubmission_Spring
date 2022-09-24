package com.mengjq.assignmentsubmission_spring.service.impl;

import org.springframework.stereotype.Service;
import com.mengjq.assignmentsubmission_spring.model.Assignment;
import com.mengjq.assignmentsubmission_spring.model.AssignmentExample;

import java.util.List;
import com.mengjq.assignmentsubmission_spring.mapper.AssignmentMapper;
import com.mengjq.assignmentsubmission_spring.service.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService{

    private AssignmentMapper mapper;

    @Override
    public Assignment getAssignmentById(Long assignmentId) {
        return mapper.selectByPrimaryKey(assignmentId);
    }


//    //通过Construction注入mapper
//    public AssignmentServiceImpl(AssignmentMapper mapper) {
//        this.mapper = mapper;
//    }
//
//    @Override
//    public long countByExample(AssignmentExample example) {
//        return mapper.countByExample(example);
//    }
//
//    @Override
//    public int deleteByExample(AssignmentExample example) {
//        return mapper.deleteByExample(example);
//    }
//
//    @Override
//    public int deleteByPrimaryKey(Integer assignmentId) {
//        return mapper.deleteByPrimaryKey(assignmentId);
//    }
//
//    @Override
//    public int insert(Assignment record) {
//        return mapper.insert((AssignmentWithBLOBs) record);
//    }
//
//    @Override
//    public int insertSelective(Assignment record) {
//        return mapper.insertSelective((AssignmentWithBLOBs) record);
//    }
//
//    @Override
//    public List<Assignment> selectByExample(AssignmentExample example) {
//        return mapper.selectByExample(example);
//    }
//
//    @Override
//    public Assignment selectByPrimaryKey(Integer assignmentId) {
//        return mapper.selectByPrimaryKey(assignmentId);
//    }
//
//    @Override
//    public int updateByExampleSelective(Assignment record,AssignmentExample example) {
//        return mapper.updateByExampleSelective((AssignmentWithBLOBs) record,example);
//    }
//
//    @Override
//    public int updateByExample(Assignment record,AssignmentExample example) {
//        return mapper.updateByExample(record,example);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(Assignment record) {
//        return mapper.updateByPrimaryKeySelective((AssignmentWithBLOBs) record);
//    }
//
//    @Override
//    public int updateByPrimaryKey(Assignment record) {
//        return mapper.updateByPrimaryKey(record);
//    }

}
