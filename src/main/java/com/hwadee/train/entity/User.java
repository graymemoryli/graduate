package com.hwadee.train.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 7174432323619124483L;
    private String account;
    private String password;
    private String name;
    private String is_student;
    private String src;



    public String getIs_student() {
        return is_student;
    }

    public void setIs_student(String is_student) {
        this.is_student = is_student;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
