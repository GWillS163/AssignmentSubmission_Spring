package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("file")
public class MyFile implements Serializable {
    @TableId(type = IdType.AUTO )
    private Integer fileId;

    private String hash;

    private Integer fileSize;

    private Integer userId;

    private Integer assignId;

    private String rawName;

    private String formatName;

    private String uploadTime;

    private static final long serialVersionUID = 1L;

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAssignId() {
        return assignId;
    }

    public void setAssignId(Integer assignId) {
        this.assignId = assignId;
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "fileId=" + fileId +
                ", hash='" + hash + '\'' +
                ", fileSize=" + fileSize +
                ", userId=" + userId +
                ", assignId=" + assignId +
                ", rawName='" + rawName + '\'' +
                ", formatName='" + formatName + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                '}';
    }

    public String getRawName() {
        return rawName;
    }

    public void setRawName(String rawName) {
        this.rawName = rawName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
