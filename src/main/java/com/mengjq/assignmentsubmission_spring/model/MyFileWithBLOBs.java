package com.mengjq.assignmentsubmission_spring.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class MyFileWithBLOBs extends MyFile implements Serializable {
    private String formatname;

    private String hash;

    private static final long serialVersionUID = 1L;

    public String getFormatname() {
        return formatname;
    }

    public void setFormatname(String formatname) {
        this.formatname = formatname;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}