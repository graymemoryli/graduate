package com.hwadee.train.entity;

import java.io.Serializable;

public class Rate implements Serializable {

    private static final long serialVersionUID = -6752936372182639251L;

    private float rare;
    private float employ;
    private float unemploy;

    public float getEmploy() {
        return employ;
    }

    public void setEmploy(float employ) {
        this.employ = employ;
    }

    public float getUnemploy() {
        return unemploy;
    }

    public void setUnemploy(float unemploy) {
        this.unemploy = unemploy;
    }

    public float getRare() {
        return rare;
    }

    public void setRare(float rare) {
        this.rare = rare;
    }
}
