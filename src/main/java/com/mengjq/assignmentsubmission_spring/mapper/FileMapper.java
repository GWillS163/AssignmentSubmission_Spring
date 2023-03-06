package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.File;
import com.mengjq.assignmentsubmission_spring.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FileMapper extends BaseMapper<File> {


    @Select("select * from file where user_id = #{user_id}")
//    @Results({
//            @Result(column = "file_id", property = "file_id"),
//            @Result(column = "assign_id", property = "assign_id"),
//            @Result(column = "raw_name", property = "raw_name"),
//            @Result(column = "upload_time", property = "upload_time"),
//            @Result(column = "user_id", property = "user_id")
//    })
    List<File> findByUserId(String user_id);

    @Select("select * from file")
    @Results({
            @Result(column = "file_id", property = "fileId"),
            @Result(column = "assign_id", property = "assignId"),
            @Result(column = "raw_name", property = "rawName"),
            @Result(column = "upload_time", property = "uploadTime"),
            @Result(column = "user_id", property = "user", javaType = User.class,
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.UserMapper.selectById"))
        }
    )
    List<File> selectAllFileWithUser();
}
