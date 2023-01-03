package com.travelbros.travelbros.models;

public class Calculator {


    ///// Methods
    public static double numberOfStops(double distance, double mpg, double tankSize) {
        return (distance / (0.8* (mpg * tankSize)));
    }
    public static double remainingBudget(double maxBudget, double expenses, double numPpl) {
        return (maxBudget - expenses) / numPpl;
    }

    public static double remainingBudget(double maxBudget, double expenses) {
        return (maxBudget - expenses);
    }

    //// Constructor
    public Calculator() {};




    public static void main(String[] args) {
        System.out.println(numberOfStops(400, 40, 10));
        System.out.println(remainingBudget(800, 1120, 2));
        System.out.println(remainingBudget(800, 1120));
    }
}
