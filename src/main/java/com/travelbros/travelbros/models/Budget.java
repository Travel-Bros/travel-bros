package com.travelbros.travelbros.models;

import com.travelbros.travelbros.repositories.BudgetRepository;

import javax.persistence.*;

@Entity
@Table(name = "budget")
public class Budget {

    //////////////////// Properties ////////////////////

    // Table Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double maxBudget;

    @Column(nullable = false)
    private double gas;

    // Instance Variables
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tripBudget")
    private Trip trip;

    // User joining
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //////////////////// Constructors ////////////////////

    // No args
    public Budget(){}

    public Budget(long id, double maxBudget, double gas) {
        this.id = id;
        this.maxBudget = maxBudget;
        this.gas = gas;
    }

    //////////////////// Getters & Setters ////////////////////


    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public double getMaxBudget () {
        return this.maxBudget;
    }

    public void setMaxBudget(double maxBudget) {
        this.maxBudget = maxBudget;
    }

}
