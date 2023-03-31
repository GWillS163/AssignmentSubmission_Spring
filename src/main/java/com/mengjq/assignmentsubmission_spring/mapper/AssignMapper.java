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

    // 根据教师id查询所有的班级的所有作业
    @Select("select * from assign where ( clazz_id in (select clazz_id from clazz where teacher_id = #{teacherId}) )")
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

}
