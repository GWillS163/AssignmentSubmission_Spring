package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.UmlRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UmlRecordMapper extends BaseMapper<UmlRecord> {

    // select all uml records
    @Select("select * from uml_record")
    List<UmlRecord> selectAllUmlRecord();

    // select uml without hide = true
    @Select("select * from uml_record where is_hide = false order by create_time desc")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user_input", column = "user_input"),
            @Result(property = "gpt_response", column = "gpt_response"),
            @Result(property = "uml_code", column = "uml_code"),
            @Result(property = "uml_intro", column = "uml_intro"),
            @Result(property = "uml_png_src", column = "uml_png_src"),
            @Result(property = "create_time", column = "create_time"),
            @Result(property = "last_edit_time", column = "last_edit_time"),
            @Result(property = "user_id", column = "user_id"),

    })
    List<UmlRecord> selectAllUmlRecordWithoutHide();

    // select uml by id
    @Select("select * from uml_record where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "user_input", column = "user_input"),
            @Result(property = "gpt_response", column = "gpt_response"),
            @Result(property = "uml_code", column = "uml_code"),
            @Result(property = "uml_intro", column = "uml_intro"),
            @Result(property = "uml_png_src", column = "uml_png_src"),
            @Result(property = "create_time", column = "create_time"),
            @Result(property = "last_edit_time", column = "last_edit_time"),
            @Result(property = "user_id", column = "user_id"),
            @Result(property = "is_hide", column = "is_hide"),
    })
    UmlRecord selectUmlRecordById(int id);

}
