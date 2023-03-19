package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

public class Student {
    // auto increment
    @TableId(type = IdType.AUTO)
    @TableField("user_id")
    private int userId;
    private int clazzId;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @TableField(exist = false)
    private Clazz clazzInfo;
    private String username;
    private String password;
    private String qq;
    private String phone;
    private String mail;
    private String registerTime;
    private String lastLoginTime;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clazz getClazzInfo() {
        return clazzInfo;
    }

    public void setClazzInfo(Clazz clazzInfo) {
        this.clazzInfo = clazzInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    @TableField(exist = false)
    private List<MyFile> myFiles;
    public int getClazzId() {
        return clazzId;
    }

    public void setClazzId(int clazzId) {
        this.clazzId = clazzId;
    }


    public List<MyFile> getFiles() {
        return myFiles;
    }

    public void setFiles(List<MyFile> myFiles) {
        this.myFiles = myFiles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", clazzId=" + clazzId +
                ", studentId='" + studentId + '\'' +
                ", clazzInfo=" + clazzInfo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", description='" + description + '\'' +
                ", files=" + myFiles +
                '}';
    }


}


