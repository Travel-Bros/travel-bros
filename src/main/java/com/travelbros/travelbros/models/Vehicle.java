package com.travelbros.travelbros.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vehicle {

// Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false, length = 50)
    private String make;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false)
    private int tank_size;

    @Column(nullable = false)
    private double mpg;


// Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTank_size() {
        return tank_size;
    }

    public void setTank_size(int tank_size) {
        this.tank_size = tank_size;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }


// Constructors

    public Vehicle() {
    }

    public Vehicle(String year, String make, String model, int tank_size, double mpg) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.tank_size = tank_size;
        this.mpg = mpg;
    }

    public Vehicle(long id, String year, String make, String model, int tank_size, double mpg) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.tank_size = tank_size;
        this.mpg = mpg;
    }
}
