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

    // continue to generate uml
    @GetMapping("/{id}/refresh")
    public int continueUmlRecord(@PathVariable("id") int id) {
        UmlRecord umlRecord = umlRecordMapper.selectUmlRecordById(id);
        System.out.println("continueUmlRecord: " + umlRecord);
        return startRequest(umlRecord);
    }
    @PutMapping("/{id}")
    public int putUmlRecord(UmlRecord umlRecord) {
        umlRecord.setIs_hide(true);
        return umlRecordMapper.updateById(umlRecord);
    }

    @PostMapping("")
    public int postUmlRecord(UmlRecord umlRecord) {
        System.out.println("postUmlRecord");
        String onHandling = "正在处理";
        // wait long time by sleep
        // 插入数据，以便能看到查询结果
        umlRecord.setGpt_response(onHandling);
        umlRecord.setUml_code(onHandling);
        umlRecord.setUml_intro(onHandling);
        umlRecord.setCreate_time(TimeFormat.getNowTime());
        umlRecordMapper.insert(umlRecord);

        return startRequest(umlRecord);
    }

    // 开始请求数据
    private int startRequest(UmlRecord umlRecord) {

        // 询问GPT并分隔， 得到三段文字
        AIUmlGenerator aiUmlGenerator = new AIUmlGenerator();
        System.out.println("userInput: " + umlRecord.getUser_input());
        if (umlRecord.getUser_input().equals(" ") || umlRecord.getUser_input() == null) {
            return 0;
        }
        Dictionary<String, String> responseDict = aiUmlGenerator.askGPT(umlRecord.getUser_input());
        aiUmlGenerator.echoDict(responseDict);
        // 更新GPT response数据
        umlRecord.setGpt_response(responseDict.get("gptResponse"));
        umlRecord.setUml_code(responseDict.get("umlCode"));
        umlRecord.setUml_intro(responseDict.get("umlIntro"));

        // 根据UmlCode 进行生成图片
        String umlPngSrc = aiUmlGenerator.getNewUmlUrl(responseDict.get("umlCode"));
        umlRecord.setUml_png_src(umlPngSrc);
        umlRecord.setLast_edit_time(TimeFormat.getNowTime());
//        System.out.println("umlRecord after draw: " + umlRecord);
        return umlRecordMapper.updateById(umlRecord);
    }

}
