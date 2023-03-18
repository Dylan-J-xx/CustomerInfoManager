package com.one.model;

import java.util.Date;

public class ManagerInfo extends ManagerInfoKey {
    private String managername;

    private String managerpassword;

    private String manageremail;

    private String salt;

    private String sex;

    private Date birthdate;

    private Long tel;

    private String education;

    private Long idcard;

    private String other;

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getManagerpassword() {
        return managerpassword;
    }

    public void setManagerpassword(String managerpassword) {
        this.managerpassword = managerpassword;
    }

    public String getManageremail() {
        return manageremail;
    }

    public void setManageremail(String manageremail) {
        this.manageremail = manageremail;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Long getIdcard() {
        return idcard;
    }

    public void setIdcard(Long idcard) {
        this.idcard = idcard;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}