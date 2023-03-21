package com.mengjq.assignmentsubmission_spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import com.mengjq.assignmentsubmission_spring.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> selectClazzIdMap() { return clazzMapper.selectClazzIdMap();
    }
}
