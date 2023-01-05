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
@RequestMapping("/miscExp")
public class MiscExpensesController {

// Dependency Injection
    private final MiscExpensesRepository miscExpensesDao;

    private final BudgetRepository budgetDao;

//////////////////// Constructors ////////////////////
    public MiscExpensesController(MiscExpensesRepository miscExpensesDao, BudgetRepository budgetDao) {
        this.miscExpensesDao = miscExpensesDao;
        this.budgetDao = budgetDao;
    }


    // Get method to show create.html view with empty miscExp object added to model
    @GetMapping("/create")
    public String createMiscExp(Model model) {
        model.addAttribute("miscExp", new MiscExpenses());
        return "miscExp/create";
    }


    // Post method to receive post miscExp and save to database
    @PostMapping("/create")
    public String submitMiscExp(@ModelAttribute MiscExpenses miscExpenses) {
        Budget budget = budgetDao.findById(Utils.currentUserId());
        miscExpenses.setBudget(budget);
        miscExpensesDao.save(miscExpenses);
        return "redirect:/miscExp";
    }


    // Get method to show edit.html view with miscExp object added to model
    @GetMapping("/{id}/edit")
    public String showEditMiscExpForm(@PathVariable long id, Model model) {
        Budget budget = budgetDao.findById(Utils.currentTripId());
        MiscExpenses miscExpenses = miscExpensesDao.findById(id);
        // redirects back to all budgets if user is not the owner of the post
        if(!budget.equals(miscExpenses.getBudget())) {
            return "redirect:/miscExp";
        }
        model.addAttribute("miscExp", miscExpenses);
        return "miscExp/edit";
    }

    // Post method to receive miscExp object and save to database
    @PostMapping("/{id}/edit")
    public String editBudget(@ModelAttribute MiscExpenses miscExpenses, @PathVariable long id) {
        Budget budget = budgetDao.findById(Utils.currentUserId());
        MiscExpenses currentMiscExp = miscExpensesDao.findById(id);
        // Only edits budget if correct user sending post request
        if(budget.equals(currentMiscExp.getBudget())){
            miscExpenses.setBudget(budget);
            miscExpensesDao.save(miscExpenses);
        }
        miscExpenses.setBudget(budget);
        miscExpensesDao.save(miscExpenses);
        return "redirect:/miscExp";
    }


    // Get method to delete budget from database
    @GetMapping("/{id}/delete")
    public String deleteBudget(@PathVariable long id) {
        Budget budget = budgetDao.findById(Utils.currentUserId());
        MiscExpenses miscExpenses = miscExpensesDao.findById(id);
        // Only deletes budget if correct user sending post request
        if (budget.getId() == miscExpenses.getBudget().getId()) {
            miscExpensesDao.delete(miscExpenses);
        }
        return "redirect:/miscExp";
    }




}
