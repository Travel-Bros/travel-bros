package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.repositories.BudgetRepository;

public class BudgetController {
    //////////////////// Properties ////////////////////

    private final BudgetRepository budgetDao;


    //////////////////// Constructors ////////////////////
    public BudgetController (BudgetRepository budgetDao) {
        this.budgetDao = budgetDao;
    }
}
