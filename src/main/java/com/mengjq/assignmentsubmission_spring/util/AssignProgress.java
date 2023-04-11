package com.mengjq.assignmentsubmission_spring.util;

public class AssignProgress {

    private String briefName;
    private String collected;
    private String total;
    private String ddlDate;
    private String releaseDate;

    public AssignProgress(String briefName, String collected, String total, String ddlDate, String releaseDate) {
        this.briefName = briefName;
        this.collected = collected;
        this.total = total;
        this.ddlDate = ddlDate;
        this.releaseDate = releaseDate;
    }

    public String getBriefName() {
        return briefName;
    }

    public void setBriefName(String briefName) {
        this.briefName = briefName;
    }

    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDdlDate() {
        return ddlDate;
    }

    public void setDdlDate(String ddlDate) {
        this.ddlDate = ddlDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "AssignProgress{" +
                "briefName='" + briefName + '\'' +
                ", collected=" + collected +
                ", total=" + total +
                ", ddlDate='" + ddlDate + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
