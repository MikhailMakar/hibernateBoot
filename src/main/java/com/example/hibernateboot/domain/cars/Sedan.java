package com.example.hibernateboot.domain.cars;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Sedan extends Car {

    @Column
    private String comfortClass;

    public String getComfortClass() {
        return comfortClass;
    }

    public void setComfortClass(String comfortClass) {
        this.comfortClass = comfortClass;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "comfortClass='" + comfortClass + '\'' +
                "} " + super.toString();
    }
}
