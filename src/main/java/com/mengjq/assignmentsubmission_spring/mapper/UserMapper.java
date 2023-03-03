package com.mengjq.assignmentsubmission_spring.mapper;

import com.mengjq.assignmentsubmission_spring.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    public List<User> find();

    @Insert("insert into user (username, phone, mail) values (#{username}, #{phone}, #{mail})")
    public int insert(User user);
}
