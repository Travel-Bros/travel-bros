package com.travelbros.travelbros.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

// Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true, length = 50)
    private String make;

    @Column(nullable = true, length = 50)
    private String model;

    @Column(nullable = false)
    private int tankSize;

    @Column(nullable = false)
    private double mpg;

    @Column(nullable = true)
    private String year;


    // User joining
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Trip joining
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
    List <Trip> tripVehicles;






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

//    public int getTankSize() {
//        return tankSize;
//    }

//    public void setTank_size(int tankSize) {
//        this.tankSize = tankSize;
//    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTankSize() {
        return tankSize;
    }

    public void setTankSize(int tankSize) {
        this.tankSize = tankSize;
    }

    @JsonIgnore
    public List<Trip> getTripVehicles() {
        return tripVehicles;
    }

    public void setTripVehicles(List<Trip> tripVehicles) {
        this.tripVehicles = tripVehicles;
    }

    // Constructors

    public Vehicle() {
    }

    public Vehicle(String year, String make, int tankSize, double mpg) {
        this.year = year;
        this.make = make;
        this.tankSize = tankSize;
        this.mpg = mpg;
    }

    public Vehicle(String year, String make, String model, int tankSize, double mpg) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.tankSize = tankSize;
        this.mpg = mpg;
    }

    public Vehicle(long id, String year, String make, String model, int tankSize, double mpg) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.tankSize = tankSize;
        this.mpg = mpg;
    }

    public Vehicle(long id, String year, String make, int tankSize, double mpg) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.tankSize = tankSize;
        this.mpg = mpg;
    }
}
