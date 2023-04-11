package com.mengjq.assignmentsubmission_spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengjq.assignmentsubmission_spring.util.PublicBanner;
import org.springframework.stereotype.Service;
import com.mengjq.assignmentsubmission_spring.model.Assign;
//import com.mengjq.assignmentsubmission_spring.model.AssignExample;
import java.util.ArrayList;
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

    @Override
    public List<Assign> getAssignMapByClassId(String id) {
        return assignMapper.getAssignMapByClassId(id);
    }


    //    根据班级Id查询作业
    @Override
    public List<Assign> getAssignByClassId(Integer id) {
        return assignMapper.getAssignByClassId(id);
    }
// selectByTeacherId
    public List<Assign> getAssignByTeacherId(Integer id) {
        return assignMapper.selectByTeacherId(id);
    }

    @Override
    public List<Assign> getPublicAssign() {
        // set criteria clazz_id = 0
        QueryWrapper<Assign> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("permit_anonymous", true);
        return assignMapper.selectList(queryWrapper);
    }

    @Override
    public List<Assign> getAssignProgressByClassId(String id) {
        return assignMapper.getAssignProgressByClassId(id);
    }

    @Override
    public ArrayList<PublicBanner> getPublicAssignTab2Banner() {
        ArrayList<PublicBanner> data = new ArrayList<>();
        Float alreadySubmits = assignMapper.getPublicAssignTab2BannerAlreadySubmit();
        Float notSubmits = assignMapper.getPublicAssignTab2BannerNotSubmit();
        Float submitRate = alreadySubmits / (alreadySubmits + notSubmits);
        data.add(new PublicBanner("已交作业", alreadySubmits));
        data.add(new PublicBanner("未交作业", notSubmits));
        data.add(new PublicBanner("提交率",  submitRate));
        data.add(new PublicBanner("最近DDL", assignMapper.getPublicAssignTab2BannerRecentDDL()));
        return data;

        // q: show me the code you referred, please
        // a:  return Arrays.asList(
        //            new Dictionary("已交作业", alreadySubmits),
        //            new Dictionary("未交作业", notSubmits),
        //            new Dictionary("提交率", submitRate),
        //            new Dictionary("最近DDL", recentDDL)
        //    );
//        q: but your answer is wrong about you code,  that is not a good idea, sophisticated
        // a:

    }

    @Override
    public Integer getAssignProgress(String assignId) {
        return assignMapper.selectFilesCount(assignId);
    }

    @Override
    public List<PublicBanner> getAssignByTeacherIdBanner(Integer id) {
        ArrayList<PublicBanner> data = new ArrayList<>();
//
        return data;
    }

    @Override
    public int countAssignNotFinished() {
        return assignMapper.countAssignNotFinished();
    }

    @Override
    public int countAllAssigns() {
        return assignMapper.selectCount(null);
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
