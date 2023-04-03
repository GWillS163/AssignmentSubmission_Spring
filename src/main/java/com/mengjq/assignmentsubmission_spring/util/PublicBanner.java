package com.mengjq.assignmentsubmission_spring.util;

public class PublicBanner {
        private String name;
        private Float value;

        public PublicBanner(String name, Float num) {
            this.name = name;
            this.value = num;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
// getters and setters for name and num
}
