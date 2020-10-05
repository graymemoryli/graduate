package com.hwadee.train.entity;

import java.io.Serializable;

public class Info implements Serializable {


    private static final long serialVersionUID = 4112414312472847495L;
    private String account;
    private String name;
    private String sex;
    private String college;
    private String major;
    private int sta;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }
}
