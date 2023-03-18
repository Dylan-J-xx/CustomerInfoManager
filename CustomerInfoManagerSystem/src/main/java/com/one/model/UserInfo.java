package com.one.model;

import java.util.Date;

public class UserInfo extends UserInfoKey {
    private String username;

    private String userpassword;

    private String useremail;

    private String salt;

    private String sex;

    private Date birthdate;

    private String education;

    private Long idcard;

    private String customerunit;

    private String managername;

    private String other;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
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

    public String getCustomerunit() {
        return customerunit;
    }

    public void setCustomerunit(String customerunit) {
        this.customerunit = customerunit;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}