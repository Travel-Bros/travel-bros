package com.travelbros.travelbros.models;

import com.travelbros.travelbros.repositories.BudgetRepository;

import javax.persistence.*;

@Entity
@Table(name = "budget")
public class Budget {
    //////////////////// Constructors ////////////////////

    // No args
    public Budget(){}

    public Budget(long id, double maxBudget, double gas) {
        this.id = id;
        this.maxBudget = maxBudget;
        this.gas = gas;
    }

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


    //////////////////// Getters & Setters ////////////////////


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
