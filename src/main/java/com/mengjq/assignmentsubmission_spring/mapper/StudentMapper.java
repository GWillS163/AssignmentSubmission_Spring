package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.Clazz;
import com.mengjq.assignmentsubmission_spring.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

//    @Select("select * from user")
//    public List<User> find();
//
//    @Insert("insert into user (username, phone, mail) values (#{username}, #{phone}, #{mail})")
//    public int insert(User user);

    @Select("select user_id, username, clazz_id, mail, phone, qq, student_id, register_time, last_login_time, description from student")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "clazz_id", property = "clazzInfo",
                    javaType = Clazz.class,
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.ClazzMapper.selectBaseInfoById")
            ),
            @Result(column = "username", property = "username"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "mail", property = "mail"),
            @Result(column = "user_id", property = "files", javaType = List.class,
                    many = @Many(select = "com.mengjq.assignmentsubmission_spring.mapper.MyFileMapper.findByUserId"))
     })
    List<Student> selectAllUserWithFiles();

    // 查询教师所教的班级的所有学生
    @Select("select user_id, username, clazz_id, mail, phone, qq, student_id, register_time, last_login_time, description " +
            "from student where clazz_id in " +
            "(select clazz_id from clazz where teacher_id = #{teacher_id})")
    List<Student> selectListByTeacherId(String teacherId);

    // getStudentCountByClassId
    @Select("select count(*) from student where clazz_id = #{clazz_id}")
    int getStudentCountByClassId(String clazzId);
}
