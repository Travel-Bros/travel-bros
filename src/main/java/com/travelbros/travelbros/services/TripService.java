package com.travelbros.travelbros.services;

import com.travelbros.travelbros.models.MiscExpenses;
import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {



    public static Budget postTripService(Budget budget, List<String> miscTitle, List<Double> miscCost) {
        Trip tripFinder = new Trip();
        // create an empty array of misc expenses
        // create a for-loop
        // loop through one of the list arrays
        // create your expense objects using index of list array
        // set each to budget
        ArrayList<MiscExpenses> emptyMiscList = new ArrayList<MiscExpenses>();

        for (int i = 0; i < miscTitle.size(); i++) {
            MiscExpenses listOfMiscExpenses = new MiscExpenses();
            listOfMiscExpenses.setTitle(miscTitle.get(i));
            listOfMiscExpenses.setCost(miscCost.get(i));
            listOfMiscExpenses.setBudget(budget);

            emptyMiscList.add(listOfMiscExpenses);
        } // End for-loop



        budget.setMiscExpenses(emptyMiscList);
        System.out.printf("%d miscellaneous expenses were added to trip: %s%n", emptyMiscList.size(), tripFinder.getEndPoint());


        return budget;
    }


    //////////////// Constructors ////////////////
    public TripService(){};

}
