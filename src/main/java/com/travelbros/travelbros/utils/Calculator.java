package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.*;
import com.travelbros.travelbros.repositories.TripRepository;

import javax.swing.plaf.nimbus.State;
import java.util.List;

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

    public static double expectedGasConsumptionForTrip(double distance, double mpg, double tankSize, String startingPoint){
        StateGasPrice gasPrice = new StateGasPrice();
        double tripStops = 0;
        int numberOfStops = numberOfStops(distance, mpg, tankSize);
        distance = convertMetersToMiles(distance);
        double range = (.8 * (tankSize));
        double avgGasPrice = (gasPrice.findStateGasPrice(startingPoint));

        if (numberOfStops == 0) {
            System.out.println("Here's your expected gas cost for the trip");
            tripStops = Double.parseDouble(String.format("%.2f", tripStops));
            return  tripStops = (range * avgGasPrice);
        } else if (numberOfStops >=1) {
            System.out.println("Here's your expected gas cost for the trip");
            // return estimated gas cost for trip
            for (int i = 0; i <= numberOfStops; i++) {
                System.out.println("fill up for the " + i + ": stop");
                tripStops += (range * avgGasPrice);
            }
            tripStops = Double.parseDouble(String.format("%.2f", tripStops));
            return tripStops;
        }

        return tripStops;
    }

    public static double expectedGasConsumptionForTrip(double distance, double mpg, double tankSize, String startingPoint, String endPoint){
        StateGasPrice gasPrice = new StateGasPrice();
        double tripStops = 0;
        int numberOfStops = numberOfStops(distance, mpg, tankSize);
        distance = convertMetersToMiles(distance);
        double range = (.8 * (tankSize));
        double avgGasPrice = ((gasPrice.findStateGasPrice(startingPoint) * gasPrice.findStateGasPrice(endPoint)) / 2);

        if (numberOfStops == 0) {
            System.out.println("Here's your expected gas cost for the trip");
            return  tripStops= (range * avgGasPrice);
        } else if (numberOfStops >=1) {
            System.out.println("Here's your expected gas cost for the trip");
            // return estimated gas cost for trip
            for (int i = 0; i < numberOfStops; i++) {
                tripStops += (range * avgGasPrice);
            }
                return tripStops;
        }
        return tripStops;
    }
    public static double expectedGasConsumptionForTrip(Trip trip) {
        String text = trip.getStartPoint();
        String[] mutated = text.split(", ", text.length());
        text = mutated[mutated.length-2];
        return expectedGasConsumptionForTrip(trip.getDistance(), trip.getVehicle().getMpg(), trip.getVehicle().getTankSize(), text);

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


    public static double miscExpenseSum(Trip trip) {
        double sum = 0;
        List<MiscExpenses> miscExpensesList = trip.getTripBudget().getMiscExpenses();
        for (int i = 0; i < miscExpensesList.size(); i++) {
            sum += miscExpensesList.get(i).getCost();
        }
        System.out.println("Here's your sum: ");
        return sum;
    }



    //// Constructor
    public Calculator() {};

    public static void main(String[] args) {


        Calculator calculator = new Calculator();
//        System.out.println("gas consoomer");
//        System.out.println((expectedGasConsumptionForTrip(563270.4, 30, 10, "tx")));
//        System.out.println((expectedGasConsumptionForTrip(563270.4, 17, 36, "tx")));
//        System.out.println((expectedGasConsumptionForTrip(1902245, 17, 36, "tx")));
        String text = "Theraleaf Relief, Inc., Timothy Drive, San Jose, CA, USA";
        String[] mutated = text.split(", ", text.length());
//        for (int i = 0; i < mutated.length; i++) {
//            System.out.println(mutated[i]);
//        }

        //System.out.println(text);
        System.out.println();
        System.out.println(mutated[mutated.length-2]);
    }

}
