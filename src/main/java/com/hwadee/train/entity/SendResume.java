package com.hwadee.train.entity;

import java.io.Serializable;

public class SendResume implements Serializable {

    private static final long serialVersionUID = -8024359198760962362L;
    private String account;
    private String company_account;
    private String name;
    private String sex;
    private String college;
    private String major;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

}
