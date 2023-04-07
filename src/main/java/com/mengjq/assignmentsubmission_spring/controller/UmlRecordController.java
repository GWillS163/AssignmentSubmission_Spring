package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.UmlRecordMapper;
import com.mengjq.assignmentsubmission_spring.model.UmlRecord;
import com.mengjq.assignmentsubmission_spring.util.AIUmlGenerator;
import com.mengjq.assignmentsubmission_spring.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/uml")
public class UmlRecordController {

    @Autowired
    private UmlRecordMapper umlRecordMapper;

    // select all uml records
    @GetMapping("")
    public List<UmlRecord> selectAllUmlRecord() {
        List<UmlRecord> umlRecordMappers = umlRecordMapper.selectAllUmlRecord();
        return umlRecordMappers;
    }

    // select uml without hide = true
    @GetMapping("/withoutHide")
    public List<UmlRecord> selectAllUmlRecordWithoutHide() {
        List<UmlRecord> umlRecordMappers = umlRecordMapper.selectAllUmlRecordWithoutHide();
        return umlRecordMappers;
    }

    @PostMapping("")
    public int postUmlRecord(UmlRecord umlRecord) {
        System.out.println("postUmlRecord");
        // wait long time by sleep
        // 插入数据，以便能看到查询结果
        umlRecord.setGpt_response("正在处理");
        umlRecord.setCreate_time(TimeFormat.getNowTime());
        umlRecordMapper.insert(umlRecord);

         // 询问GPT并分隔， 得到三段文字
         AIUmlGenerator aiUmlGenerator = new AIUmlGenerator();
         System.out.println("userInput: " + umlRecord.getUser_input());
         Dictionary<String, String> responseDict = aiUmlGenerator.askGPT(umlRecord.getUser_input());
         aiUmlGenerator.echoDict(responseDict);
        // 更新GPT response数据
         umlRecord.setGpt_response(responseDict.get("gptResponse"));
         umlRecord.setUml_code(responseDict.get("umlCode"));
        umlRecord.setUml_intro(responseDict.get("umlIntro"));

//        umlRecord.setGpt_response("处理完成");
//        umlRecord.setUml_code("umlCode");
//        umlRecord.setUml_intro("umlIntro");
        umlRecord.setLast_edit_time(TimeFormat.getNowTime());
//        System.out.println("umlRecord after AI: " + umlRecord);
        umlRecordMapper.updateById(umlRecord);

        // 根据UmlCode 进行生成图片
         String umlPngSrc = aiUmlGenerator.getNewUmlUrl(responseDict.get("umlCode"));
        umlRecord.setUml_png_src(umlPngSrc);
        umlRecord.setLast_edit_time(TimeFormat.getNowTime());
//        System.out.println("umlRecord after draw: " + umlRecord);

        return umlRecordMapper.updateById(umlRecord);
    }

}
