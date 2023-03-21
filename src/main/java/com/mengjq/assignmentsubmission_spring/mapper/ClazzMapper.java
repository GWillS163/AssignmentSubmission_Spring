package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import com.mengjq.assignmentsubmission_spring.model.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClazzMapper extends BaseMapper<Clazz> {
    // selectById
     @Select("select * from clazz where clazz_id = #{clazz_id}")
     @Results(
             {
                     @Result(column = "clazz_id", property = "clazz_id"),
                        @Result(column = "clazz_name", property = "clazz_name"),
                        @Result(column = "clazz_id", property = "students", javaType = List.class,
                                many = @Many(select = "com.mengjq.assignmentsubmission_spring.mapper.StudentMapper.findByClazzId")),
                }
        )
    List<Clazz> selectById(int id);

     // selectBaseInfo By Id
//        @Results(
//                {
//                        @Result(column = "clazz_id", property = "clazz_id"),
//                        @Result(column = "clazz_name", property = "clazz_name"),
//                }
//        )

    @Select("select * from clazz where  clazz_id = #{clazz_id}")
    Clazz selectBaseInfoById(String clazz_id);

    @Select("select clazz_id, clazz_name from clazz")
    @Results({
            @Result(column = "clazz_id", property = "clazzId"),
            @Result(column = "clazz_name", property = "clazzName"),
    })
    List<Clazz> selectClazzIdMap();
}
