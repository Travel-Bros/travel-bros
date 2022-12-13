package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/budgets")
public class BudgetController {


// Dependency Injection
    private final BudgetRepository budgetDao;
    private final TripRepository tripDao;


    //////////////////// Constructors ////////////////////
    public BudgetController (BudgetRepository budgetDao, TripRepository tripDao) {
        this.budgetDao = budgetDao;
        this.tripDao = tripDao;
    }


    // Get method to show create.html view with empty trip object added to model
    @GetMapping("/create")
    public String createBudget(Model model) {
        model.addAttribute("budget", new Budget());
        return "budgets/create";
    }

    // Post method to receive post trip and save to database
    @PostMapping("/create")
    public String submitBudget(@ModelAttribute Budget budget) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        budget.setTrip(trip);
        budgetDao.save(budget);
        return "redirect:/budgets";
    }


    // Get method to show edit.html view with trip object added to model
    @GetMapping("/{id}/edit")
    public String showEditBudgetForm(@PathVariable long id, Model model) {
        Trip trip = tripDao.findById(Utils.currentTripId());
        Budget budget = budgetDao.findById(id);
        // redirects back to all posts if user is not the owner of the post
        if(!trip.equals(budget.getTrip())) {
            return "redirect:/budgets";
        }
        model.addAttribute("budget", budget);
        return "/budgets/edit";
    }


    // Post method to receive trip object and save to database
    @PostMapping("/{id}/edit")
    public String editBudget(@ModelAttribute Budget budget, @PathVariable long id) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        Budget currentBudget = budgetDao.findById(id);
        // Only edits post if correct user sending post request
        if(trip.equals(currentBudget.getTrip())){
            budget.setTrip(trip);
            budgetDao.save(budget);
        }
        budget.setTrip(trip);
        budgetDao.save(budget);
        return "redirect:/budgets";
    }


    // Get method to delete trip from database
    @GetMapping("/{id}/delete")
    public String deleteBudget(@PathVariable long id) {
        Trip trip = tripDao.findById(Utils.currentUserId());
        Budget budget = budgetDao.findById(id);
        // Only deletes post if correct user sending post request
        if (trip.getId() == budget.getTrip().getId()) {
            budgetDao.delete(budget);
        }
        return "redirect:/budgets";
    }

}
