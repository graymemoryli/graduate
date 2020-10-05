package com.hwadee.train.entity;

import java.io.Serializable;

public class Adress implements Serializable {

    private static final long serialVersionUID = 2602532733569005461L;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    private String place;


}
