package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Assign;
import com.mengjq.assignmentsubmission_spring.model.AssignWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AssignMapper extends BaseMapper<Assign> {

    @Select("select * from assign")
    List<Assign> getAllAssignsInfo();

    @Select("select * from assign where id = #{id}")
    List<Assign> selectByPrimaryKey(int id);

    int deleteByPrimaryKey(Integer assiid);

    int insert(AssignWithBLOBs record);

    int insertSelective(AssignWithBLOBs record);

    @Select("select * from assign where student_id = #{studentId}")
    List<Assign> selectByStudentId(int studentId);

    @Update("UPDATE assign SET teacher_id = #{teacherId}, ddl = #{ddl}, create_time = #{createTime}, brief_name = #{briefName}, description = #{description}, file_name_rule = #{fileNameRule}, permit_anonymous = #{permitAnonymous}, file_name_verify = #{fileNameVerify} WHERE id = #{id}")
    int updateByPrimaryKeySelective(Assign assign);

    int updateByPrimaryKeyWithBLOBs(AssignWithBLOBs record);

    int updateByPrimaryKey(Assign record);

}
