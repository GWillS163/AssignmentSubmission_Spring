package com.mengjq.assignmentsubmission_spring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengjq.assignmentsubmission_spring.model.UmlRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UmlRecordMapper extends BaseMapper<UmlRecord> {

    // select all uml records
    @Select("select * from uml_record")
    List<UmlRecord> selectAllUmlRecord();

    // select uml without hide = true
    @Select("select * from uml_record where isHide = false")
    List<UmlRecord> selectAllUmlRecordWithoutHide();

    // insert uml record

}
