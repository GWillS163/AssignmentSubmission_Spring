package com.mengjq.assignmentsubmission_spring.model;

public class Clazz {
    private int id;
    private int teacher_id;
    private String name;
    private String faculty;
    private String major;

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
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

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
