package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

public class Student {
    // auto increment
    @TableId(type = IdType.AUTO)
    @TableField("user_id")
    private int user_id;
    private int clazz_id;

    @TableField(exist = false)
    private Clazz clazz_info;
    private String username;
    private String password;
    private String qq;
    private String phone;
    private String mail;

    public Clazz getClazz_info() {
        return clazz_info;
    }

    public void setClazz_info(Clazz clazz_info) {
        this.clazz_info = clazz_info;
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

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    private String register_time;
    private String last_login_time;

    @TableField(exist = false)
    private List<File> files;
    public int getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(int clazz_id) {
        this.clazz_id = clazz_id;
    }


    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int id) {
        this.user_id = id;
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
                "user_id=" + user_id +
                ", clazz_id=" + clazz_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", register_time='" + register_time + '\'' +
                ", last_login_time='" + last_login_time + '\'' +
                ", files=" + files +
                '}';
    }


}


