package com.mengjq.assignmentsubmission_spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import java.util.List;
import com.mengjq.assignmentsubmission_spring.mapper.AssignMapper;
import com.mengjq.assignmentsubmission_spring.service.AssignService;
import org.springframework.transaction.annotation.Transactional;

//@Service("assignServiceImpl")
@Service
public class AssignServiceImpl extends ServiceImpl<AssignMapper, Assign> implements AssignService {

    @Override
    public List<Assign> getAssigns() {
        return baseMapper.selectList(null);
    }

//    @Override
//    public IPage<Assign> getAssignsByOpr(Page<Assign> page, Assign assign) {
//        return null;
//    }
//
//    //通过构�?�器注入mapper
//    public AssignServiceImpl(AssignMapper mapper) {
//        this.mapper = mapper;
//    }
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
//    @Override
//    public int deleteByPrimaryKey(String assignId) {
//        return mapper.deleteByPrimaryKey(assignId);
//    }
//
//    @Override
//    public int insert(Assign record) {
//        return mapper.insert(record);
//    }
//
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
//    @Override
//    public int updateByPrimaryKeySelective(Assign record) {
//        return mapper.updateByPrimaryKeySelective(record);
//    }

//    @Override
//    public int updateByPrimaryKey(Assign record) {
//        return mapper.updateByPrimaryKey(record);
//    }

}
