package com.mengjq.assignmentsubmission_spring.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 * 作业规则
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@TableName("tb_admin")
public class Assignment implements Serializable {
//    @TableId(value="id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private char gender;
    private String password;
    private String email;
    private String telephone;
    private String address;
    private String portraitPath; // the path of avatar

//    }

//    private Integer assiid;
//
//    private Integer curriid;
//
//    private Date ddl;
//
//    private Byte permitanymous;
//
//    private Byte filenameverify;
//
//    private Date updatedtime;
//
//    private static final long serialVersionUID = 1L;
//
//    public Integer getAssiid() {
//        return assiid;
//    }
//
//    public void setAssiid(Integer assiid) {
//        this.assiid = assiid;
//    }
//
//    public Integer getCurriid() {
//        return curriid;
//    }
//
//    public void setCurriid(Integer curriid) {
//        this.curriid = curriid;
//    }
//
//    public Date getDdl() {
//        return ddl;
//    }
//
//    public void setDdl(Date ddl) {
//        this.ddl = ddl;
//    }
//
//    public Byte getPermitanymous() {
//        return permitanymous;
//    }
//
//    public void setPermitanymous(Byte permitanymous) {
//        this.permitanymous = permitanymous;
//    }
//
//    public Byte getFilenameverify() {
//        return filenameverify;
//    }
//
//    public void setFilenameverify(Byte filenameverify) {
//        this.filenameverify = filenameverify;
//    }
//
//    public Date getUpdatedtime() {
//        return updatedtime;
//    }
//
//    public void setUpdatedtime(Date updatedtime) {
//        this.updatedtime = updatedtime;
//    }
}