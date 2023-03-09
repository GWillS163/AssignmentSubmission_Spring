package com.mengjq.assignmentsubmission_spring.model;

public class Clazz {
    private int id;
    private int teacherId;
    private String className;
    private String faculty;
    private String major;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", className='" + className + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
