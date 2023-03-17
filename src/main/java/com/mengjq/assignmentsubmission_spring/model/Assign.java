package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 作业规则
 */

public class Assign implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer clazzId;
    private String ddl;
    private String uploadTime;
    private String briefName;
    private String description;
    private String fileNameRule;
    private Byte permitAnonymous;
    private Byte fileNameVerify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public Byte getPermitAnonymous() {
        return permitAnonymous;
    }

    public void setPermitAnonymous(Byte permitAnonymous) {
        this.permitAnonymous = permitAnonymous;
    }

    public Byte getFileNameVerify() {
        return fileNameVerify;
    }

    public void setFileNameVerify(Byte fileNameVerify) {
        this.fileNameVerify = fileNameVerify;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileNameRule() {
        return fileNameRule;
    }

    public void setFileNameRule(String fileNameRule) {
        this.fileNameRule = fileNameRule;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "id=" + id +
                ", clazzId=" + clazzId +
                ", ddl=" + ddl +
                ", uploadTime=" + uploadTime +
                ", briefName='" + briefName + '\'' +
                ", description='" + description + '\'' +
                ", fileNameRule='" + fileNameRule + '\'' +
                ", permitAnonymous=" + permitAnonymous +
                ", fileNameVerify=" + fileNameVerify +
                '}';
    }
}