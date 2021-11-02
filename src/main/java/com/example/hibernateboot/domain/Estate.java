package com.example.hibernateboot.domain;

import javax.persistence.*;

@Entity(name = "someName")
public class Estate {

    public Estate() {
    }

    public Estate(Long id, String type, String city) {
        this.id = id;
        this.type = type;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String type;

    @Column
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
