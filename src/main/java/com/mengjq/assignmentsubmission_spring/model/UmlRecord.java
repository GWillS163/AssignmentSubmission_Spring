package com.mengjq.assignmentsubmission_spring.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class UmlRecord {
    @TableId(value="id",  type = IdType.AUTO)
    private int id;
    private int user_id;
    private String user_input;
    private String gpt_response;
    private String uml_png_src;
    private String uml_intro;
    private String uml_code;
    private String create_time;
    private String last_edit_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_input() {
        return user_input;
    }

    public void setUser_input(String user_input) {
        this.user_input = user_input;
    }

    public String getGpt_response() {
        return gpt_response;
    }

    public void setGpt_response(String gpt_response) {
        this.gpt_response = gpt_response;
    }

    public String getUml_png_src() {
        return uml_png_src;
    }

    public void setUml_png_src(String uml_png_src) {
        this.uml_png_src = uml_png_src;
    }

    public String getUml_intro() {
        return uml_intro;
    }

    public void setUml_intro(String uml_intro) {
        this.uml_intro = uml_intro;
    }

    public String getUml_code() {
        return uml_code;
    }

    public void setUml_code(String uml_code) {
        this.uml_code = uml_code;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getLast_edit_time() {
        return last_edit_time;
    }

    public void setLast_edit_time(String last_edit_time) {
        this.last_edit_time = last_edit_time;
    }
    /**
     * Returns a string representation of the UmlRecord object.
     * @return String representation of the UmlRecord object.
     */
    @Override
    public String toString() {
        return "UmlRecord{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_input='" + user_input + '\'' +
                ", gpt_response='" + gpt_response + '\'' +
                ", uml_png_src='" + uml_png_src + '\'' +
                ", uml_intro='" + uml_intro + '\'' +
                ", uml_code='" + uml_code + '\'' +
                ", create_time='" + create_time + '\'' +
                ", last_edit_time='" + last_edit_time + '\'' +
                '}';
    }
}

