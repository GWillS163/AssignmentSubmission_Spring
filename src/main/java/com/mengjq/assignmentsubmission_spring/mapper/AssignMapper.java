package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.model.AssignWithBLOBs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AssignMapper extends BaseMapper<Assign> {

    @Select("select * from assign")
    List<Assign> getAllAssignsInfo();

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
}
