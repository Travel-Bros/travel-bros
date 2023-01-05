package com.travelbros.travelbros.models;

import com.travelbros.travelbros.repositories.BudgetRepository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "budget")
public class Budget {

    //////////////////// Properties ////////////////////

    // Table Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private double maxBudget;

    @Column(nullable = true)
    private double gas;

    // Instance Variables
    @OneToOne(mappedBy = "tripBudget")
    private Trip trip;

    // User joining
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
    private List<MiscExpenses> miscExpenses;

    //////////////////// Constructors ////////////////////

    // No args
    public Budget(){}

    public Budget(long id, double maxBudget, double gas, List<MiscExpenses> miscExpenses) {
        this.id = id;
        this.maxBudget = maxBudget;
        this.gas = gas;
        this.miscExpenses = miscExpenses;
    }
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

    public void setAnExpense () {}



    public List<MiscExpenses> getMiscExpenses() {
        return miscExpenses;
    }

    public void setMiscExpenses(List<MiscExpenses> miscExpenses) {
        this.miscExpenses = miscExpenses;
    }
}
