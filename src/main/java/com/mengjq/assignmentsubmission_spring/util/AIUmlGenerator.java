package com.mengjq.assignmentsubmission_spring.util;

import com.alibaba.fastjson.JSONObject;

import java.util.Dictionary;
import java.util.Hashtable;

public class AIUmlGenerator {
    // set a property to save the uml png url
    private String saveFolder =  "..\\resources\\static\\";
    private String saveName = "temp";
    private String saveTxtName = saveName + ".txt";
    private String savePngName = saveName + ".png";

    // q: 如何在这里初始化构造函数
    // a: 你可以看一下这个类的构造函数


    public AIUmlGenerator() {
    }

    public Dictionary<String, String> askGPT(String userInput) {
        // TODO: 询问GPT
        JSONObject res = getGPTResponse(userInput);
        System.out.println(res);
        if (res.isEmpty() || res.getInteger("code") != 200) {
            return null;
        }
        String resData = res.get("data").toString();
        return separateResponse(resData);
    }

    // TODO: 本地静态保存返回uml PNG_URL
    public String getNewUmlUrl(String umlCode) {
//      TODO:  1. 生成UML.txt文件
        saveUmlCode(umlCode);
        saveUmlPng();
        return savePngName;
    }


    private Dictionary<String, String> separateResponse(String res) {
//        TODO: 实现分割; 通过正则表达式
        Dictionary<String, String> dict = new Hashtable<>();
        dict.put("gptResponse", "res");
        dict.put("umlCode", "@startUml .... @endUml");
        dict.put("umlIntro", "这个UML展示了...");
        System.out.println("separateResponse: " + dict);
//        q: 为什么这里的dict是空的
//        a: 因为你没有返回值
//        q: 我明明返回了值啊
//        a: 你返回的是null
        return dict;
    }

    private JSONObject getGPTResponse(String userInput) {
//        TODO: 实现GPT请求
//        waitTime(10);
        JSONObject res = new JSONObject();
        res.put("code", 200);
        res.put("data", "这是GPT的返回值");
        return res;
    }

    private void saveUmlCode(String umlCode) {
//        TODO: 实现保存UML代码
        // 1. 生成UML.txt文件, 保存至本地
        waitTime(1);
    }

    private void saveUmlPng() {
//        TODO: 实现保存UML图片, 通过运行cmd命令
//        waitTime(2);
    }

    private void runCmd(String cmd) {

    }

    private void waitTime(int time) {
        try {
            System.out.println("sleep " + time + "s");

            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("sleep end");
    }
}
