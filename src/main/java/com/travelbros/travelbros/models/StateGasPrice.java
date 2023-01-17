package com.travelbros.travelbros.models;

import javax.swing.plaf.nimbus.State;
import java.util.List;

public class StateGasPrice {



    public double[] fiftyStateGasPrices = {
    // Alabama
            3.061,
    // Alaska
            3.756,
    // Arizona
            3.440,
    // Arkansas
            2.966,
    // California
            4.433,
    // Colorado
            3.079,
    // Connecticut
            3.184,
    // Delaware
            3.318,
    // Florida
            3.303,
    // Georgia
            2.821,
    // Hawaii
            5.015,
    // Idaho
            3.413,
    // Illinois
            3.424,
    // Indiana
            3.247,
    // Iowa
            3.175,
    // Kansas
            2.916,
    // Kentucky
            2.949,
    // Louisiana
            2.948,
    // Maine
            3.385,
    // Maryland
            3.376,
    // Massachusetts
            3.338,
    // Michigan
            3.326,
    // Minnesota
            3.166,
    // Mississippi
            2.904,
    // Missouri
            2.948,
    // Montana
            2.995,
    // Nebraska
            3.091,
    // Nevada
            3.979,
    // New Hampshire
            3.222,
    // New Jersey
            3.311,
    // New Mexico
            3.116,
    // New York
            3.459,
    // North Carolina
            3.153,
    // North Dakota
            3.111,
    // Ohio
            3.307,
    // Oklahoma
            2.950,
    // Oregon
            3.711,
    // Pennsylvania
            3.660,
    // Rhode Island
            3.253,
    // South Carolina
            3.029,
    // South Dakota
            3.201,
    // Tennessee
            2.990,
    // Texas
            2.874,
    // Utah
            3.256,
    // Vermont
            3.413,
    // Virginia
            3.190,
    // Washington
            3.923,
    // West Virginia
            3.192,
    // Wisconsin
            3.131,
    // Wyoming
            3.087
    };

    public String[] fiftyStates =
    {
        "Alabama",
        "Alaska",
        "Arizona",
        "Arkansas",
        "California",
        "Colorado",
        "Connecticut",
        "Delaware",
        "Florida",
        "Georgia",
        "Hawaii",
        "Idaho",
        "Illinois",
        "Indiana",
        "Iowa",
        "Kansas",
        "Kentucky",
        "Louisiana",
        "Maine",
        "Maryland",
        "Massachusetts",
        "Michigan",
        "Minnesota",
        "Mississippi",
        "Missouri",
        "Montana",
        "Nebraska",
        "Nevada",
        "New Hampshire",
        "New Jersey",
        "New Mexico",
        "New York",
        "North Carolina",
        "North Dakota",
        "Ohio",
        "Oklahoma",
        "Oregon",
        "Pennsylvania",
        "Rhode Island",
        "South Carolina",
        "South Dakota",
        "Tennessee",
        "Texas",
        "Utah",
        "Vermont",
        "Virginia",
        "Washington",
        "West Virginia",
        "Wisconsin",
        "Wyoming"
    };

    public String[] fiftyAbbreviatedStates = {
        "AL",
        "AK",
        "AZ",
        "AR",
        "CA",
        "CO",
        "CT",
        "DE",
        "FL",
        "GA",
        "HI",
        "ID",
        "IL",
        "IN",
        "IA",
        "KS",
        "KY",
        "LA",
        "ME",
        "MD",
        "MA",
        "MI",
        "MN",
        "MS",
        "MO",
        "MT",
        "NE",
        "NV",
        "NH",
        "NJ",
        "NM",
        "NY",
        "NC",
        "ND",
        "OH",
        "OK",
        "OR",
        "PA",
        "RI",
        "SC",
        "SD",
        "TN",
        "TX",
        "UT",
        "VT",
        "VA",
        "WA",
        "WV",
        "WI",
        "WY"
    };



    // input is full-text state
    public String findAbbreviatedState(String input) {

        String result = "";
        int count = 0;

        // This loop will iterate through the entire fiftyStates array.
        for (int i = 0; i < fiftyStates.length; i++) {
            // if a single iteration of the condition (that the index of fiftyStates doesn't equal input regardless of upper/lower casing)
            if (!fiftyStates[i].equalsIgnoreCase(input)) {
                // count increments by 1
                count++;
                // loop continues
                continue;
            } else {
                // Otherwise this means a match between input and the fiftyStates has been found.
                result = fiftyAbbreviatedStates[i];
                // if a match has been found, the loop is broken and the count is left as the index's value
                break;
            }
        }
        // if the count reaches 50, this means the entire array has been searched with no suitable matches to input
        if (count == 50) {
            // a message of "No state found" is returned
            return "No state found";
        } else {
            // Otherwise, a suitable match has been found and the result will have the value of input
            return result;
        }

    }

    public boolean findAbbreviatedStateBool(String input) {

        boolean result;
//        String result = "";
        int count = 0;

        // This loop will iterate through the entire fiftyStates array.
        for (int i = 0; i < fiftyStates.length; i++) {
            // if a single iteration of the condition (that the index of fiftyStates doesn't equal input regardless of upper/lower casing)
            if (!fiftyStates[i].equalsIgnoreCase(input)) {
                // count increments by 1
                count++;
                // loop continues
                continue;
            } else {
                // Otherwise this means a match between input and the fiftyStates has been found.
                // if a match has been found, the loop is broken and the count is left as the index's value
                result = true;
                break;
            }
        }
        // if the count reaches 50, this means the entire array has been searched with no suitable matches to input
        if (count == 50) {
            // a message of "No state found" is returned
            return result = false;
        } else {
            // Otherwise, a suitable match has been found and the result will have the value of input
            return result = true;
        }

    }

    public boolean findStateBool(String input) {

        boolean result;
//        String result = "";
        int count = 0;

        // This loop will iterate through the entire fiftyStates array.
        for (int i = 0; i < fiftyStates.length; i++) {
            // if a single iteration of the condition (that the index of fiftyStates doesn't equal input regardless of upper/lower casing)
            if (!fiftyAbbreviatedStates[i].equalsIgnoreCase(input)) {
                // count increments by 1
                count++;
                // loop continues
                continue;
            } else {
                // Otherwise this means a match between input and the fiftyStates has been found.
                // if a match has been found, the loop is broken and the count is left as the index's value
                result = true;
                break;
            }
        }
        // if the count reaches 50, this means the entire array has been searched with no suitable matches to input
        if (count == 50) {
            // a message of "No state found" is returned
            return result = false;
        } else {
            // Otherwise, a suitable match has been found and the result will have the value of input
            return result = true;
        }

    }

    public String findFullNameState(String input) {
        String result = "";
        int count = 0;

        for (int i = 0; i < fiftyAbbreviatedStates.length; i++) {
            if (!input.equalsIgnoreCase(fiftyAbbreviatedStates[i])) {
                count++;
                continue;
            } else {
                result = fiftyStates[i];
                break;
            }
        }
        if (count == 50) {
            return input + " was not found";
        } else {
            return result;
        }

    }

    public int findAbbrStateIndex(String input) {
        int count = 0;

        for (int i = 0; i < fiftyAbbreviatedStates.length; i++) {
            if (!input.equalsIgnoreCase(fiftyAbbreviatedStates[i])) {
                count++;
                continue;
            } else {
                break;
            }
        }
        if (count == 50) {
            return -1;
        } else {
            return count;
        }

    }

    public int findStateIndex(String input) {
        int count = 0;

        for (int i = 0; i < fiftyStates.length; i++) {
            if (!input.equalsIgnoreCase(fiftyStates[i])) {
                count++;
                continue;
            } else {
                break;
            }
        }
        if (count == 50) {
            return -1;
        } else {
            return count;
        }
    }

    public double nationalAverage(double[] stateAvgGasPrices) {
        double average = 0;
        for (double stateAvgGasPrice : stateAvgGasPrices) {
            average += stateAvgGasPrice;
        }
        return average / stateAvgGasPrices.length;
    }



    public double findStateGasPrice(String input) {
        // We will run two booleans methods to see if input is either abbreviated state or full-state name
        // This if statement checks to see if input is a state abbreviation or state's full name.
        if (!findAbbreviatedStateBool(input) && !findStateBool(input)) {
            // if the input isn't equal to an abbreviation or full name, it will return -1
            return -1;
        } else {
            if (findAbbrStateIndex(input) != -1) {
                return fiftyStateGasPrices[findAbbrStateIndex(input)];
            } else if (findStateIndex(input) != -1) {
                return fiftyStateGasPrices[findStateIndex(input)];
            } else {
                return -1;
            }
        }
        // We can do this by setting up if/else running the two boolean methods for full-state or abbrev.

        // Once we see that the input is or isn't a real state, we can move onto finding the index of the input

    }

    public static void main(String[] args) {
        StateGasPrice testState = new StateGasPrice();
        System.out.println(testState.findStateGasPrice("tx"));
        System.out.println(testState.findStateGasPrice("TX"));
        System.out.println(testState.findStateGasPrice("Texas"));
        System.out.println(testState.findStateGasPrice("New York"));
        System.out.println(testState.findStateGasPrice("NY"));
        System.out.println(testState.findStateGasPrice("HI"));
        System.out.println(testState.findStateGasPrice("Hawaii"));
        System.out.println(testState.nationalAverage(testState.fiftyStateGasPrices));
    }

    public StateGasPrice(){};
}
