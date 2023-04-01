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

    @Override
    public List<Assign> selectByPrimaryKey(int id) {
        return assignMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateByPrimaryKeySelective(Assign record) {
        return assignMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Assign> getAllAssignsMap() { return assignMapper.getAllAssignsMap();}

//    根据班级Id查询作业
    @Override
    public List<Assign> getAssignByClassId(Integer id) {
        return assignMapper.getAssignByClassId(id);
    }
// selectByTeacherId
    public List<Assign> getAssignByTeacherId(Integer id) {
        return assignMapper.selectByTeacherId(id);
    }
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
    public int updateAssign(int id, Assign assign) {
        assign.setId(id);

        return assignMapper.updateByPrimaryKeySelective(assign);
        // q: 我这里的返回值使用了.get(0)， 会不会有些问题
        // a: 不会，因为这里的返回值是一个list，而list的get方法是可以传入index的，所以这里的get(0)是可以的
//        q: 我现在报错了，是这样的： Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IndexOutOfBoundsException: Index: 0, Size: 0] with root cause
        // a: 这个是因为你的id在数据库中不存在，所以你的selectByPrimaryKey(id)返回的是一个空的list，所以你的get(0)就会报错
    }

//    @Override
//    public int updateByPrimaryKey(Assign record) {
//        return assignMapper.updateByPrimaryKey(record);
//    }
}
