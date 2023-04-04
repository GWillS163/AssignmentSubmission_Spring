package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.model.MyFileWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface MyFileMapper extends BaseMapper<MyFile> {
    long countByExample(MyFileExample example);

    int deleteByExample(MyFileExample example);

    @Delete("delete from file where file_id = #{fileId}")
    int deleteByPrimaryKey(Integer fileId);

//    insert a record into table
    @Insert("insert into file(file_id, file_size, user_id, assign_id, raw_name, format_name, upload_time) values(#{fileId}, #{fileSize}, #{userId}, #{assignId}, #{rawName}, #{formatName}, #{uploadTime})")
    int insertOne(MyFile record);

    // findByUserId
    @Select("select * from file where user_id = #{userId}")
    List<MyFile> findByUserId(String userId);

    List<MyFileWithBLOBs> selectByExampleWithBLOBs(MyFileExample example);

    @Select("select * from file")
    List<MyFile> selectByExample(MyFileExample example);

    @Select("select * from file where file_id = #{fileId}")
    MyFile selectByPrimaryKey(String fileId);

    int updateByExampleSelective(@Param("record") MyFile record, @Param("example") MyFileExample example);

    int updateByExampleWithBLOBs(@Param("record") MyFileWithBLOBs record, @Param("example") MyFileExample example);

    int updateByExample(@Param("record") MyFile record, @Param("example") MyFileExample example);

    int updateByPrimaryKeySelective(MyFile record);

    int updateByPrimaryKeyWithBLOBs(MyFile record);

    //    也可以使用Xml配置文件， 但是总是不好使， 以后再研究
    @Update({
            "<script>",
            "update file",
            "<set>",
            "<if test='fileSize != null'>file_size = #{fileSize},</if>",
            "<if test='userId != null'>user_id = #{userId},</if>",
            "<if test='assignId != null'>assign_id = #{assignId},</if>",
            "<if test='savePath != null'>save_path = #{savePath},</if>",
            "<if test='rawName != null'>raw_name = #{rawName},</if>",
            "<if test='formatName != null'>format_name = #{formatName},</if>",
            "<if test='uploadTime != null'>upload_time = #{uploadTime},</if>",
            "<if test='lastEditTime != null'>last_edit_time = #{lastEditTime},</if>",
            "</set>",
            "where file_id = #{fileId}",
            "</script>"
    })
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "assignId", column = "assign_id"),
            @Result(property = "savePath", column = "save_path"),
            @Result(property = "rawName", column = "raw_name"),
            @Result(property = "formatName", column = "format_name"),
            @Result(property = "uploadTime", column = "upload_time")
    })
    int updateByPrimaryKey(MyFile record);
//    q:  为什么程序运行报错，MyFileMapper 没有in configuration.
//    a:  因为没有在application.yml中配置mapper的位置

    @Select("select * from file where user_id = #{studentId}")
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "assignId", column = "assign_id"),
//            use assignId to turn to assignName by select
            @Result(property = "assignName", column = "assign_id",
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.AssignMapper.selectAssignNameByAssignId")
            ),
            @Result(property = "savePath", column = "save_path"),
            @Result(property = "rawName", column = "raw_name"),
            @Result(property = "formatName", column = "format_name"),
            @Result(property = "uploadTime", column = "upload_time")
    })
    List<MyFile> selectByStudentId(String studentId);

    @Select("select * from file where assign_id = #{assignId}")
    List<MyFile> findByAssignId(String assignId);

    //   查询作业下的文件数量
    @Select("select count(*) from file where assign_id = #{assignId}")
    int getFileCountByAssignId(String assignId);

//    查询 班级下的所有作业的文件
    @Select("select * from file where assign_id in (select assign_id from assign where clazz_id = #{classId})")
    List<MyFile> findByClassId(String classId);

    @Select("select * from file where assign_id in (select assign_id from assign where clazz_id = #{classId}) and user_id = #{studentId}")
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "assignId", column = "assign_id"),
            @Result(property = "assignName", column = "assign_id",
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.AssignMapper.selectByPrimaryKey")
            ),
            @Result(property = "savePath", column = "save_path"),
            @Result(property = "rawName", column = "raw_name"),
            @Result(property = "formatName", column = "format_name"),
            @Result(property = "uploadTime", column = "upload_time")
    })
    List<MyFile> selectMyFileWithInfo();

    // return the files recently uploaded, filter by criteria
    @Select("select * from file where upload_time > #{time} order by upload_time desc")
    // q: 如何 降序排列上面的查询语句
    // a: 1. 在sql语句中加入 order by upload_time desc
    // parse the userId and assignId to userName and assignName
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "userName", column = "user_id",
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.StudentMapper.selectUserNameByUserId")),
            @Result(property = "assignName", column = "assign_id",
                    one = @One(select = "com.mengjq.assignmentsubmission_spring.mapper.AssignMapper.selectAssignNameByAssignId")),
            @Result(property = "rawName", column = "raw_name"),
            @Result(property = "uploadTime", column = "upload_time")
    })
    List<MyFile> selectMyFilePublic(String time);
}