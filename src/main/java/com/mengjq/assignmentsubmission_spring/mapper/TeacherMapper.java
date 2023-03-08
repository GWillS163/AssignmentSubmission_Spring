package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper extends BaseMapper<Teacher> {

    // query all item in teacher, just remain the columns that id  and name, hide others columns

    @Select("select id, name from teacher")
    @Results({
                    @Result(column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
            }
    )
    List<Teacher> selectTeacherIdMap();


}
