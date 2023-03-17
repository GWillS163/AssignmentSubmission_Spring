package com.mengjq.assignmentsubmission_spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import java.util.List;
import com.mengjq.assignmentsubmission_spring.mapper.AssignMapper;
import com.mengjq.assignmentsubmission_spring.service.AssignService;

@Service("assignServiceImpl")
public class AssignServiceImpl extends ServiceImpl<AssignMapper, Assign> implements AssignService {

    private final AssignMapper assignMapper;

    @Override
    public List<Assign> getAllAssignsInfo() {
        System.out.println("getAllAssignsInfo");
        return assignMapper.selectList(null);
    }


    @Override
    public int insert(Assign record) {
        return assignMapper.insert(record);
    }

//    @Override
//    public IPage<Assign> getAssignsByOpr(Page<Assign> page, Assign assign) {
//        return null;
//    }
//
    //通过构�?�器注入mapper
    public AssignServiceImpl(AssignMapper mapper) {
        this.assignMapper = mapper;
    }
//
//    @Override
//    public long countByExample(AssignExample example) {
//        return mapper.countByExample(example);
//    }
//
//    @Override
//    public int deleteByExample(AssignExample example) {
//        return mapper.deleteByExample(example);
//    }
//
    @Override
    public int deleteByPrimaryKey(Integer assignId) {
        return assignMapper.deleteByPrimaryKey(assignId);
    }


//    @Override
//    public int insertSelective(Assign record) {
//        return mapper.insertSelective(record);
//    }
//
//    @Override
//    public List<Assign> selectByExample(AssignExample example) {
//        return mapper.selectByExample(example);
//    }

//    @Override
//    public List<Assign> selectByPrimaryKey(int assignId) {
//        return mapper.selectByPrimaryKey(assignId);
//    }

//    @Override
//    public int updateByExampleSelective(Assign record,AssignExample example) {
//        return mapper.updateByExampleSelective(record,example);
//    }
//
//    @Override
//    public int updateByExample(Assign record,AssignExample example) {
//        return mapper.updateByExample(record,example);
//    }
//
    @Override
    public int updateByPrimaryKeySelective(Assign record) {
        return assignMapper.updateByPrimaryKeySelective(record);
    }


//    @Override
//    public int updateByPrimaryKey(Assign record) {
//        return mapper.updateByPrimaryKey(record);
//    }

}
