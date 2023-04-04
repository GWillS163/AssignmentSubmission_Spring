package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @author 作业规则
 */

public class Assign implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer clazzId;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    private Integer teacherId;
    private String ddl;
    private String createTime;
    private String briefName;
    private String description;
    private String fileNameRule;
    private Boolean permitAnonymous;
    private Boolean fileNameVerify;
    private Boolean timeoutSubmit;
    private Boolean uploadEnable;

    public Boolean getUploadEnable() {
        return uploadEnable;
    }

    public void setUploadEnable(Boolean uploadEnable) {
        this.uploadEnable = uploadEnable;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    @TableField(exist = false)
    private Integer fileCount;

    // studentCount
    @TableField(exist = false)
    private Integer studentCount;

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return "Assign{" +
                "id=" + id +
                ", clazzId=" + clazzId +
                ", teacherId=" + teacherId +
                ", ddl='" + ddl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", briefName='" + briefName + '\'' +
                ", description='" + description + '\'' +
                ", fileNameRule='" + fileNameRule + '\'' +
                ", permitAnonymous=" + permitAnonymous +
                ", fileNameVerify=" + fileNameVerify +
                ", timeoutSubmit=" + timeoutSubmit +
                '}';
    }

    public Boolean getTimeoutSubmit() {
        return timeoutSubmit;
    }

    public void setTimeoutSubmit(Boolean timeoutSubmit) {
        this.timeoutSubmit = timeoutSubmit;
    }

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

    public Boolean getPermitAnonymous() {
        return permitAnonymous;
    }

    public void setPermitAnonymous(Boolean permitAnonymous) {
        this.permitAnonymous = permitAnonymous;
    }

    public Boolean getFileNameVerify() {
        return fileNameVerify;
    }

    public void setFileNameVerify(Boolean fileNameVerify) {
        this.fileNameVerify = fileNameVerify;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

}