package com.travelbros.travelbros.services;

import com.travelbros.travelbros.models.MiscExpenses;
import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.MiscExpensesRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    private final MiscExpensesRepository miscDao;

    public static Budget budgetToMiscExpenseMethod(Trip trip, Budget budget, List<String> miscTitle, List<Double> miscCost) {
        ArrayList<MiscExpenses> emptyMiscList = new ArrayList<MiscExpenses>();

        for (int i = 0; i < miscTitle.size(); i++) {
                MiscExpenses listOfMiscExpenses = new MiscExpenses();
            if (miscTitle.size() ==0 ){
                break;
            }else {
                // set miscTitle
                listOfMiscExpenses.setTitle(miscTitle.get(i));
                // see what miscTitle is
                System.out.println(miscTitle.get(i));
                // set miscCost
                listOfMiscExpenses.setCost(miscCost.get(i));
                // see what miscCost is
                listOfMiscExpenses.setBudget(budget);

                emptyMiscList.add(listOfMiscExpenses);

            }
        } // End for-loop


        budget.setMiscExpenses(emptyMiscList);
        System.out.printf("%d miscellaneous expenses were added to: %s%n", emptyMiscList.size(), trip.getEndPoint());

        return budget;
    }
    public TripService(MiscExpensesRepository miscDao) {
        this.miscDao = miscDao;
    }

    public void deleteOldMiscExpenseFromBudget(Budget budget) {
        List<MiscExpenses> deleteMe = miscDao.findAllByBudget(budget);

        miscDao.deleteAll(deleteMe);

    }


    //////////////// Constructors ////////////////

    //public TripService(){};

}
