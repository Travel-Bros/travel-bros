package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Calculator;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/budget")
public class BudgetController {


// Dependency Injection
    private final BudgetRepository budgetDao;
    private final TripRepository tripDao;


//////////////////// Constructors ////////////////////
    public BudgetController (BudgetRepository budgetDao, TripRepository tripDao) {
        this.budgetDao = budgetDao;
        this.tripDao = tripDao;
    }


    // Get method to show create.html view with empty budget object added to model
//    @GetMapping("/create")
//    public String createTrip(Model model) {
////        User currentUser = userDao.findById(Utils.currentUserId());
//        model.addAttribute("createTrip", new Trip());
////        model.addAttribute("currentUser", currentUser);
//        model.addAttribute("tripBudget", new Budget());
//        model.addAttribute("calculator", new Calculator());
////        if (currentUser.getUserVehicles().size() == 0) {
////            return "redirect:/vehicles/create";
////        }
//        return "/trips/trip_planner";
//    }
    // Post method to receive post budget and save to database
    @PostMapping("/create")
    public String submitBudget(@ModelAttribute Budget budget) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        budget.setTrip(trip);
        budgetDao.save(budget);
        return "redirect:/budget";
    }


    // Get method to show edit.html view with budget object added to model
    @GetMapping("/{id}/edit")
    public String showEditBudgetForm(@PathVariable long id, Model model) {
//        User user = userDao.findById(Utils.currentUserId());
        Trip trip = tripDao.findById(Utils.currentTripId());
        Budget budget = trip.getTripBudget();
        model.addAttribute("tripBudget", budget);
//        Budget budget = budgetDao.findById(Utils.currentBudgetId());
        model.addAttribute("currentTrip", trip);

        model.addAttribute("budget", budget);
        return "budget/edit";
    }



    // Post method to receive budget object and save to database
    @PostMapping("/{id}/edit")
    public String editBudget(@ModelAttribute Budget budget, @PathVariable long id) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        Budget currentBudget = budgetDao.findById(id);
        // Only edits budget if correct user sending post request
        if(trip.equals(currentBudget.getTrip())){
            budget.setTrip(trip);
            budgetDao.save(budget);
        }
        budget.setTrip(trip);
        budgetDao.save(budget);
        return "redirect:/budget";
    }


    // Get method to delete budget from database
    @GetMapping("/{id}/delete")
    public String deleteBudget(@PathVariable long id) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        Budget budget = budgetDao.findById(id);
        // Only deletes budget if correct user sending post request
        if (trip.getId() == budget.getTrip().getId()) {
            budgetDao.delete(budget);
        }
        return "redirect:/budget";
    }

}
