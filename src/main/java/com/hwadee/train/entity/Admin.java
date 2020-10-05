package com.hwadee.train.entity;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{

    private static final long serialVersionUID = 8519358614718562616L;
    private String Account;
    private String password;
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //    private Date birthDay;
//
//    public Date getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(Date birthDay) {
//        this.birthDay = birthDay;
//    }

//    public Adress getAdress() {
//        return adress;
//    }
//
//    public void setAdress(Adress adress) {
//        this.adress = adress;
//    }
//
//    private Adress adress;



}
