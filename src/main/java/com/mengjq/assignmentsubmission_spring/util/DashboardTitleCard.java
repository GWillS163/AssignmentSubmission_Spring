package com.mengjq.assignmentsubmission_spring.util;

public class DashboardTitleCard {
    private String name;
    private String value;
    private String icon;

    public DashboardTitleCard(String name, String value, String icon) {
        this.name = name;
        this.value = value;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
