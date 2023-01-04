package com.travelbros.travelbros.utils;

public class Calculator {


    ///// Methods
    public static double convertMetersToMiles(double meters) {
        double metersToMiles = (meters/1609.344);
        System.out.printf("%n%s meters: %s miles%n", meters, metersToMiles);
        return (meters/1609.344);
    }

    public static int numberOfStops(double distance, double mpg, double tankSize) {
        int numberOfStopsAnswer = (int) (convertMetersToMiles(distance)/ (0.8* (mpg * tankSize)));
        System.out.printf("%nYour expected number of stops: %s%n", numberOfStopsAnswer);
        return numberOfStopsAnswer;
    }
    public static double remainingBudget(double maxBudget, double expenses, double numPpl) {

        if (numPpl <= 0) {
            numPpl = 1;
        } else {
            numPpl = numPpl;
        }
        double remainingBudgetAnswer = (budgetPricePerPerson(maxBudget, numPpl) - expenses);
        if ((budgetPricePerPerson(maxBudget, numPpl)- expenses) <= 0) {
            System.out.printf("%nYou are expected to have a remaining balance of %s%n", remainingBudgetAnswer);
        } else {
            System.out.printf("%nYou are expected to have a remaining balance of %s%n", remainingBudgetAnswer);
        }
        return remainingBudgetAnswer;

    }

    // this is the price each person must pay to support the budget equally
    public static double budgetPricePerPerson(double maxBudget, double numPpl) {
        double budgetPricePerPersonAnswer = (maxBudget/numPpl);
        System.out.printf("%nEach person will need to pay %s for the %s budget.%n", budgetPricePerPersonAnswer, maxBudget);
        return budgetPricePerPersonAnswer;
    }

    public static double remainingBudget(double maxBudget, double expenses) {


        return (maxBudget - expenses);
    }

    //// Constructor
    public Calculator() {};




    public static void main(String[] args) {
        

    }
}
