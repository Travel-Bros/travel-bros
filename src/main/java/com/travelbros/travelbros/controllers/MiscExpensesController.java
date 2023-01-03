package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.MiscExpenses;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.MiscExpensesRepository;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/other")
public class MiscExpensesController {

// Dependency Injection
    private final MiscExpensesRepository miscExpensesDao;

    private final BudgetRepository budgetDao;

//////////////////// Constructors ////////////////////
    public MiscExpensesController(MiscExpensesRepository miscExpensesDao, BudgetRepository budgetDao) {
        this.miscExpensesDao = miscExpensesDao;
        this.budgetDao = budgetDao;
    }


    // Get method to show create.html view with empty budget object added to model
    @GetMapping("/create")
    public String createMiscExp(Model model) {
        model.addAttribute("miscExp", new MiscExpenses());
        return "other/create";
    }


    // Post method to receive post budget and save to database
    @PostMapping("/create")
    public String submitMiscExp(@ModelAttribute MiscExpenses miscExpenses) {
        Budget budget = budgetDao.findById(Utils.currentUserId());
        miscExpenses.setBudget(budget);
        miscExpensesDao.save(miscExpenses);
        return "redirect:/other";
    }


    // Get method to show edit.html view with budget object added to model
    @GetMapping("/{id}/edit")
    public String showEditMiscExpForm(@PathVariable long id, Model model) {
        Budget budget = budgetDao.findById(Utils.currentTripId());
        MiscExpenses miscExpenses = miscExpensesDao.findById(id);
        // redirects back to all budgets if user is not the owner of the post
        if(!budget.equals(miscExpenses.getBudget())) {
            return "redirect:/other";
        }
        model.addAttribute("miscExp", miscExpenses);
        return "/other/edit";
    }



}
