package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.StateGasPrice;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.repositories.TripRepository;

import java.util.List;
import java.util.Locale;

public class CalculatorV2 {
    //////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Methods //////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////

    //// Method 2
    // This method is to return a double in a $ format (i.e. 3.878964 => 3.87 || 3.89)

        public static double cashDoubleFormatter(double cash) {
            return Double.parseDouble(String.format("%.2f", cash));
        }

    //// Method 3 ****
    // This method is to calculate the number of stops based on trip distance, vehicle mpg and vehicle tank size

         public static int numberOfStops(double distance, double mpg, double tankSize) {
            int numberOfStopsAnswer = (int) (distance / (0.8* (mpg * tankSize)));
            System.out.printf("%nYour expected number of stops: %s%n", numberOfStopsAnswer);
            return numberOfStopsAnswer;
        }

    //// Method 4 ****
    // This method is used to calculate the expected cost for gas, taking into account: distance, mpg, tank-size, and a location value (starting or ending point or both)

         public static double expectedGasConsumptionForTrip(double distance, double mpg, double tankSize, String location){

            StateGasPrice gasPrice = new StateGasPrice();
            double avgGasPrice = gasPrice.findStateGasPrice(location);
            double tripStops = 0;
            int numberOfStops = numberOfStops(distance, mpg, tankSize);
            double range = findRange(tankSize);

            if (numberOfStops == 0) {
                System.out.println("Here's your expected gas cost for the trip");
                return cashDoubleFormatter(range * avgGasPrice);
            } else if (numberOfStops >= 1) {
                System.out.println("Here's your expected gas cost for the trip (2nd condition)");
                for (int i = 0; i < numberOfStops; i++){
                    tripStops += (range * avgGasPrice);
                }
                return cashDoubleFormatter(tripStops);
            } else {
                return cashDoubleFormatter(tripStops);
            }
        }



        public static double expectedGasConsumptionForTrip(Trip trip) {
            StateGasPrice gasPrice = new StateGasPrice();
            LocationDataUtilities locationReFormat = new LocationDataUtilities();
            String formattedStartPoint = "";
            String formattedEndPoint = "";
            double avgGasPrice = gasPrice.findStateGasPrice((trip.getStartPoint()));
            double tripStops = 0;
            int numberOfStops = numberOfStops(trip.getDistance(), trip.getVehicle().getMpg(), trip.getVehicle().getTankSize());
            double range = findRange(trip.getVehicle().getTankSize());

            // Check if trip start AND end are accepted in gas array
            if (locationReFormat.locationCheck(trip.getStartPoint()) && locationReFormat.locationCheck(trip.getEndPoint())) {
                System.out.println("Starting and Ending location accepted");
                formattedStartPoint = locationReFormat.locationStateTrimmer(trip.getStartPoint());
                formattedEndPoint = locationReFormat.locationStateTrimmer(trip.getEndPoint());
                if (numberOfStops == 0) {
                    System.out.println("Here's your expected gas cost for the trip");
                    return cashDoubleFormatter(range * avgGasPrice);
                } else if (numberOfStops >= 1) {
                    System.out.println("Here's your expected gas cost for the trip (2nd condition)");
                    for (int i = 0; i < numberOfStops; i++){
                        tripStops += (range * avgGasPrice);
                    }
                    return cashDoubleFormatter(tripStops);
                } else {
                    return cashDoubleFormatter(tripStops);
                }

            } else if (locationReFormat.locationCheck(trip.getStartPoint()) && !locationReFormat.locationCheck(trip.getEndPoint())) {
                System.out.println("Starting location accepted, but Ending location not accepted");
            }




            if (numberOfStops == 0) {
                System.out.println("Here's your expected gas cost for the trip");
                return cashDoubleFormatter(range * avgGasPrice);
            } else if (numberOfStops >= 1) {
                System.out.println("Here's your expected gas cost for the trip (2nd condition)");
                for (int i = 0; i < numberOfStops; i++){
                    tripStops += (range * avgGasPrice);
                }
                return cashDoubleFormatter(tripStops);
            } else {
                return cashDoubleFormatter(tripStops);
            }
        }


    //// Method 5
    // This method is used to return the expected price each person will likely have to pay equally for the budget
    public static double budgetPricePerPerson(double maxBudget, double numPpl) {
        double budgetPricePerPersonAnswer = cashDoubleFormatter((maxBudget/numPpl));
        System.out.printf("%nEach person will need to pay %s for the %s budget.%n", budgetPricePerPersonAnswer, maxBudget);
        return  cashDoubleFormatter(budgetPricePerPersonAnswer);
    }

    //// Method 6
    public static double findRange (double tankSize) {
        return tankSize * 0.8;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// The next several methods ////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////

    //// Method 7
    // This method will be used to find avg gas price for a trip with the same state as starting and ending location

    public static double findAggregateGas(String location){

            LocationDataUtilities locationDataUtilities = new LocationDataUtilities();
            StateGasPrice stateGasPrice = new StateGasPrice();
            if (locationDataUtilities.locationCheck(location)) {
                return stateGasPrice.findStateGasPrice(location);
            } else {
                System.out.println("Location not found");
                return -1;
            }
    }





    public static void main(String[] args) {
        CalculatorV2 calculatorV2 = new CalculatorV2();
        StateGasPrice stateGas = new StateGasPrice();
        LocationDataUtilities locationDataUtilities = new LocationDataUtilities();

        System.out.println(expectedGasConsumptionForTrip(551, 23, 11, "tx"));
        System.out.println(expectedGasConsumptionForTrip(551, 23, 11, "texAS"));
        System.out.println(expectedGasConsumptionForTrip(551, 23, 11, "CA"));
        System.out.println(expectedGasConsumptionForTrip(551, 23, 11, "CAlifornia"));
        System.out.println(expectedGasConsumptionForTrip(1275, 23, 11, "tx"));
        System.out.println(expectedGasConsumptionForTrip(490, 23, 11, "tx"));



    }




}
