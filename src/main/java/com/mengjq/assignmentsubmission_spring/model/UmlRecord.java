package com.mengjq.assignmentsubmission_spring.model;

public class UmlRecord {
    private int id;
    private int userId;
    private String userInput;
    private String gptResponse;
    private String umlPngSrc;
    private String umlIntro;
    private String umlCode;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getGptResponse() {
        return gptResponse;
    }

    public void setGptResponse(String gptResponse) {
        this.gptResponse = gptResponse;
    }

    public String getUmlPngSrc() {
        return umlPngSrc;
    }

    public void setUmlPngSrc(String umlPngSrc) {
        this.umlPngSrc = umlPngSrc;
    }

    public String getUmlIntro() {
        return umlIntro;
    }

    public void setUmlIntro(String umlIntro) {
        this.umlIntro = umlIntro;
    }

    public String getUmlCode() {
        return umlCode;
    }

    public void setUmlCode(String umlCode) {
        this.umlCode = umlCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UmlRecord{" +
                "userInput='" + userInput + '\'' +
                "id=" + id +
                ", userId=" + userId +
                ", gptResponse='" + gptResponse + '\'' +
                ", umlPngSrc='" + umlPngSrc + '\'' +
                ", umlIntro='" + umlIntro + '\'' +
                ", umlCode='" + umlCode + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
