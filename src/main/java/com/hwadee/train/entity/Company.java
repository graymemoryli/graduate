package com.hwadee.train.entity;

import java.io.Serializable;

public class Company implements Serializable {

    private static final long serialVersionUID = -5154313817093261227L;

    private String account;
    private String password;
    private String name;
    private String src;

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
