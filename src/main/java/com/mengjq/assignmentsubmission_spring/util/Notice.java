package com.mengjq.assignmentsubmission_spring.util;

public class Notice {

    private String from;
    private String type;
    private String content;
    private String sendTime;
    private int id;
    private Boolean isChecked;

    public Notice(int id, String from, String type, String content, String sendTime, Boolean isChecked) {
        this.from = from;
        this.type = type;
        this.content = content;
        this.sendTime = sendTime;
        this.id = id;
        this.isChecked = isChecked;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "from='" + from + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", sendTime='" + sendTime + '\'' +
                ", id=" + id +
                ", isChecked=" + isChecked +
                '}';
    }
}
