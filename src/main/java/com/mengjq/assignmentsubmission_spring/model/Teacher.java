package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.ArrayList;
import java.util.Date;

public class Teacher {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String name;
    private String workId;
    private String qq;
    private String phone;
    private String mail;
    private String password;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Date lastLoginTime;
    private Date createTime;
    @TableField(exist = false)
    private ArrayList<String> ownClasses;

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public ArrayList<String> getOwnClasses() {
        return ownClasses;
    }

    public void setOwnClasses(ArrayList<String> ownClasses) {
        this.ownClasses = ownClasses;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", workId='" + workId + '\'' +
                ", ownClasses='" + ownClasses + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
