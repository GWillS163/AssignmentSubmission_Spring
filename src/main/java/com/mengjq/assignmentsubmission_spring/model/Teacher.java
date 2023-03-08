package com.mengjq.assignmentsubmission_spring.model;

public class Teacher {
    private String id;
    private String name;
    private String phone;
    private String mail;
    private String password;

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
        return
            "teacher_id=" + id +
            ", name=" + name +
            ", phone=" + phone +
            ", mail=" + mail +
            ", password=" + password;
    }
}
