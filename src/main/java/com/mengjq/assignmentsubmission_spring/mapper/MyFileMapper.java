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
            "<if test='rawName != null'>raw_name = #{rawName},</if>",
            "<if test='formatName != null'>format_name = #{formatName},</if>",
            "<if test='uploadTime != null'>upload_time = #{uploadTime},</if>",
            "</set>",
            "where file_id = #{fileId}",
            "</script>"
    })
    @Results({
            @Result(property = "fileId", column = "file_id"),
            @Result(property = "fileSize", column = "file_size"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "assignId", column = "assign_id"),
            @Result(property = "rawName", column = "raw_name"),
            @Result(property = "formatName", column = "format_name"),
            @Result(property = "uploadTime", column = "upload_time")
    })
    int updateByPrimaryKey(MyFile record);
}