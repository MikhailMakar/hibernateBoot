package com.example.hibernateboot.domain.cars;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SportCar extends Car {

    @Column(nullable = true)
    private int power;
    @Column
    private int maxSpeed;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
