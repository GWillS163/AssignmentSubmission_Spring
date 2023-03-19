package com.mengjq.assignmentsubmission_spring.service.impl;

import org.springframework.stereotype.Service;
import com.mengjq.assignmentsubmission.model.MyFile;
import com.mengjq.assignmentsubmission.model.MyFileExample;
import java.lang.String;
import java.util.List;
import com.mengjq.assignmentsubmission.mapper.FileMapper;
import com.mengjq.assignmentsubmission.service.MyFileService;

@Service
public class MyFileServiceImpl implements MyFileService{

    private FileMapper mapper;

    //通过构�?�器注入mapper
    public MyFileServiceImpl(FileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public long countByExample(MyFileExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MyFileExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String myFileId) {
        return mapper.deleteByPrimaryKey(myFileId);
    }

    @Override
    public int insert(MyFile record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(MyFile record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<MyFile> selectByExample(MyFileExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public MyFile selectByPrimaryKey(String myFileId) {
        return mapper.selectByPrimaryKey(myFileId);
    }

    @Override
    public int updateByExampleSelective(MyFile record,MyFileExample example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(MyFile record,MyFileExample example) {
        return mapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(MyFile record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MyFile record) {
        return mapper.updateByPrimaryKey(record);
    }

}
