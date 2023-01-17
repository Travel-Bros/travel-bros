package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.StateGasPrice;

public class LocationDataUtilities {



    //// Methods
    // Method 1
    // This method will parse String location info to return a state (if it is formatted in google-maps api return)
    public static String locationStateTrimmer(String verboseAddress) {
        String[] mutateInput = verboseAddress.split(", ", verboseAddress.length());
//        for (int i = 0; i < mutateInput.length; i++) {
//            System.out.println(mutateInput[i]);
//        }
        return mutateInput[mutateInput.length-2];

    }

    //// Method 2
    // This method streamlines the process of checking a string to see if it's either a state or abbreviated state name

    public boolean locationCheck(String location) {
        StateGasPrice stateGasPrice = new StateGasPrice();
        return (stateGasPrice.findAbbreviatedStateBool(location) || stateGasPrice.findStateBool(location));
    }

    //// Method 3
    public double parseTripDistance(String distance) {
        return Double.parseDouble(distance);
    }

    public static void main(String[] args) {
        CalculatorV2 calculatorV2 = new CalculatorV2();
        System.out.println(locationStateTrimmer("Big Bend National Park, Big Bend National Park, TX, USA"));
        System.out.println(locationStateTrimmer("Codeup, Navarro Street, San Antonio, PA, USA"));
        System.out.println(locationStateTrimmer("Codeup, Navarro Street, San Antonio, PA, USA").equalsIgnoreCase(" PA"));
        System.out.println(locationStateTrimmer("Codeup, Navarro Street, San Antonio, PA, USA").equalsIgnoreCase("PA"));



    }
}
