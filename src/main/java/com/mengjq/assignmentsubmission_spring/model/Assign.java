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
    private Integer curriid;
    private Date ddl;
    private Byte permitanymous;
    private Byte filenameverify;
    private Date updatedtime;
    private String userid;
    private String brifename;
    private String description;
    private String filenamerule;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurriid() {
        return curriid;
    }

    public void setCurriid(Integer curriid) {
        this.curriid = curriid;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }

    public Byte getPermitanymous() {
        return permitanymous;
    }

    public void setPermitanymous(Byte permitanymous) {
        this.permitanymous = permitanymous;
    }

    public Byte getFilenameverify() {
        return filenameverify;
    }

    public void setFilenameverify(Byte filenameverify) {
        this.filenameverify = filenameverify;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBrifename() {
        return brifename;
    }

    public void setBrifename(String brifename) {
        this.brifename = brifename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilenamerule() {
        return filenamerule;
    }

    public void setFilenamerule(String filenamerule) {
        this.filenamerule = filenamerule;
    }

}