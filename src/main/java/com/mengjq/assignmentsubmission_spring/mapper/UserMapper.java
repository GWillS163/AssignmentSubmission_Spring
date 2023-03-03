package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.File;
import com.mengjq.assignmentsubmission_spring.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user")
//    public List<User> find();
//
//    @Insert("insert into user (username, phone, mail) values (#{username}, #{phone}, #{mail})")
//    public int insert(User user);

    @Select("select * from user")
    @Results(
            {
                    @Result(column = "user_id", property = "user_id"),
                    @Result(column = "username", property = "username"),
                    @Result(column = "phone", property = "phone"),
                    @Result(column = "mail", property = "mail"),
                    @Result(column = "user_id", property = "files", javaType = List.class,
                            many = @Many(select = "com.mengjq.assignmentsubmission_spring.mapper.FileMapper.findByUserId"))
            }
    )
    List<User> selectAllUserWithFiles();
}
