package com.hwadee.train.entity;

import java.io.Serializable;

public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = -3377859025263957152L;
    private String account;
    private String name;
    private String location;
    private String job;
    private String job_type;
    private String job_salary;
    private String job_location;
    private int sta;

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getJob_salary() {
        return job_salary;
    }

    public void setJob_salary(String job_salary) {
        this.job_salary = job_salary;
    }


}
