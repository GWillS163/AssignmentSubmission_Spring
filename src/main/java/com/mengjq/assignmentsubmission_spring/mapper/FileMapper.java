package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.MyFile;
import com.mengjq.assignmentsubmission_spring.model.MyFileExample;
import com.mengjq.assignmentsubmission_spring.model.MyFileWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface FileMapper extends BaseMapper<MyFile> {
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

    @Update("update file set file_size = #{fileSize}, user_id = #{userId}, assign_id = #{assignId}, raw_name = #{rawName}, format_name = #{formatName}, upload_time = #{uploadTime} where file_id = #{fileId} ")
//    也可以使用Xml配置文件， 但是总是不好使， 以后再研究
    int updateByPrimaryKeySelective(MyFile record);

    int updateByPrimaryKeyWithBLOBs(MyFile record);

    int updateByPrimaryKey(MyFile record);
}