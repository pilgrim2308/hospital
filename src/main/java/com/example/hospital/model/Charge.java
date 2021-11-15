package com.example.hospital.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description_charge;
    private long cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription_charge() {
        return description_charge;
    }

    public void setDescription_charge(String description_charge) {
        this.description_charge = description_charge;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public Charge() {
    }

    public Charge(String description_charge, long cost) {
        this.description_charge = description_charge;
        this.cost = cost;
    }
}
