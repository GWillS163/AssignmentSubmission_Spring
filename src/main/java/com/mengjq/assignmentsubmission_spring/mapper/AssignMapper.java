package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.model.AssignWithBLOBs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AssignMapper extends BaseMapper<Assign> {

    @Select("select * from assign")
    List<Assign> getAllAssigns();

    // 根据班级Id 查询作业
    @Select("select * from assign where clazz_id = #{clazzId}")
    List<Assign> selectByClazzId(int clazzId);

    // 查询所有作业通过班级id， 每个老师会拥有多个班级
    @Select("select * from assign where clazz_id in (select clazz_id from teacher where teacher_id = #{teacherId})")
    List<Assign> selectByTeacherId(int teacherId);

    @Select("select * from assign where id = #{id}")
    List<Assign> selectByPrimaryKey(int id);

    @Delete("delete from assign where id = #{id}")
    int deleteByPrimaryKey(Integer id);

    int insert(AssignWithBLOBs record);

    int insertSelective(AssignWithBLOBs record);

    @Select("select * from assign where student_id = #{studentId}")
    List<Assign> selectByStudentId(int studentId);

    //    也可以使用Xml配置文件， 但是总是不好使， 以后再研究
    @Update("<script>" +
            "UPDATE assign " +
            "<set>" +
//            clazz
            "<if test='clazzId != null'>clazz_id = #{clazzId},</if>" +
            "<if test='teacherId != null'>teacher_id = #{teacherId},</if>" +
            "<if test='ddl != null'>ddl = #{ddl},</if>" +
            "<if test='createTime != null'>create_time = #{createTime},</if>" +
            "<if test='briefName != null'>brief_name = #{briefName},</if>" +
            "<if test='description != null'>description = #{description},</if>" +
            "<if test='fileNameRule != null'>file_name_rule = #{fileNameRule},</if>" +
            "<if test='permitAnonymous != null'>permit_anonymous = #{permitAnonymous},</if>" +
            "<if test='fileNameVerify != null'>file_name_verify = #{fileNameVerify},</if>" +
            "<if test='timeoutSubmit != null'>timeout_submit = #{timeoutSubmit},</if>" +
            "</set>" +
            "WHERE id = #{id}" +
            "</script>")
    int updateByPrimaryKeySelective(Assign assign);

    int updateByPrimaryKeyWithBLOBs(AssignWithBLOBs record);

    int updateByPrimaryKey(Assign record);

    @Select("select brief_name from assign where id = #{assignId}")
    String selectAssignNameByAssignId(int assignId);

    @Select("select id, brief_name from assign")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brief_name", property = "briefName"),
    })
    List<Assign> getAllAssignsMap();

    @Select("select * from assign where clazz_id = #{id} order by create_time desc")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brief_name", property = "briefName"),
            @Result(column = "teacher_id", property = "teacherId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "ddl", property = "ddl"),
            @Result(column = "description", property = "description"),
            @Result(column = "file_name_rule", property = "fileNameRule"),
            @Result(column = "permit_anonymous", property = "permitAnonymous"),
            @Result(column = "file_name_verify", property = "fileNameVerify"),
            @Result(column = "timeout_submit", property = "timeoutSubmit"), // 0: 不允许， 1：允许
    })
    List<Assign> getAssignByClassId(Integer id);

    @Select("select * from assign where clazz_id = #{id} order by create_time desc")
    List<Assign> getAssignMapByClassId(String id);

    //  查询班级所有的assign
    @Select("select id, brief_name, clazz_id, id from assign where clazz_id = #{clazz_id} order by create_time desc")
    //  查询班级所有的assign, 并且查询每个assign的提交情况
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brief_name", property = "briefName"),
            @Result(column = "clazz_id", property = "clazzId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "ddl", property = "ddl"),
//            @Result(column = "description", property = "description"),
//            @Result(column = "file_name_rule", property = "fileNameRule"),
//            @Result(column = "permit_anonymous", property = "permitAnonymous"),
//            @Result(column = "file_name_verify", property = "fileNameVerify"),
//            @Result(column = "timeout_submit", property = "timeoutSubmit"), // 0: 不允许， 1：允许
            @Result(column = "id", property = "fileCount", one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.MyFileMapper.getFileCountByAssignId")),
            @Result(column = "clazz_id", property = "studentCount", one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.StudentMapper.getStudentCountByClassId")),
    })
    List<Assign> getAssignProgressByClassId(String clazz_id);

//   Public Tab2 Banner
    @Select("select count(*) from file")
    Float getPublicAssignTab2BannerAlreadySubmit();

//    这里不准确，应该查询班级内没有提交的人数
//     查询所有学生  - 已经提交的学生
    @Select("select count(*) from student")
//    @Select("select count(*) from student")
//    @Select("select count(*) from assign where id = #{id} and timeout_submit = 0")
    Float getPublicAssignTab2BannerNotSubmit();

    // 查询 ddl 距离当前时间不到一天的作业
    @Select("select count(*) from assign where id = #{id} and timeout_submit = 0 and ddl < date_add(now(), interval 1 day)")
    Float getPublicAssignTab2BannerRecentDDL();

    // selectAssignNameByAssignId
    @Select("select brief_name from assign where id = #{id}")
    String getAssignNameByAssignId(int id);

    // 查询files数量， 通过assignId, 以用户ID为唯一值
    @Select("select count(*) from file where assign_id = #{assignId}")
    Integer selectFilesCount(String assignId);

    @Select("select count(*) from assign")
    int countAllAssigns();

    @Select("select count(*) from assign where ddl > now()")
    int countAssignNotFinished();
    // 查询files数量， 通过assignId, 以用户ID为唯一值



}
