package com.mengjq.assignmentsubmission_spring.controller;

import com.mengjq.assignmentsubmission_spring.mapper.UmlRecordMapper;
import com.mengjq.assignmentsubmission_spring.model.UmlRecord;
import com.mengjq.assignmentsubmission_spring.util.AIUmlGenerator;
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
    public List<UmlRecord> selectAllUmlRecord(){
        List<UmlRecord> umlRecordMappers = umlRecordMapper.selectAllUmlRecord();
        return umlRecordMappers;
    }

    // select uml without hide = true
    @GetMapping("/withoutHide")
    public List<UmlRecord> selectAllUmlRecordWithoutHide(){
        List<UmlRecord> umlRecordMappers = umlRecordMapper.selectAllUmlRecordWithoutHide();
        return umlRecordMappers;
    }

     @PostMapping("")
    public int postUmlRecord(UmlRecord umlRecord) {
        // wait long time by sleep
         // 插入数据，以便能看到查询结果
         umlRecord.setGptResponse("正在处理");
         umlRecordMapper.insert(umlRecord);

         // TODO: 询问GPT并分隔， 得到三段文字
         AIUmlGenerator aiUmlGenerator = new AIUmlGenerator();
         Dictionary<String, String> userInput = aiUmlGenerator.askGPT(umlRecord.getUserInput());
         System.out.println("userInput: " + userInput);
         // q: 如何取到字典中的值
         // a: 通过key取值， 演示一下
//         q: 代码演示一下啊
//         a:
         String gptResponse = userInput.get("gptResponse");

         String gptCode = userInput.get("umlCode");
         String gptIntro = userInput.get("umlIntro");
         System.out.println("gptResponse: " + gptResponse);
            System.out.println("gptCode: " + gptCode);
            System.out.println("gptIntro: " + gptIntro);
        // 更新GPT response数据
         umlRecord.setGptResponse(gptResponse);
         umlRecord.setUmlCode(gptCode);
        umlRecord.setUmlIntro(gptIntro);
        umlRecordMapper.updateById(umlRecord);


        // TODO：根据UmlCode 进行生成图片
         String umlPngSrc = aiUmlGenerator.getNewUmlUrl(gptCode);
        umlRecord.setUmlPngSrc(umlPngSrc);

         return umlRecordMapper.updateById(umlRecord);
     }

}
