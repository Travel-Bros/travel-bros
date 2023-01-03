//package com.travelbros.travelbros.controllers;
//
//import com.travelbros.travelbros.models.*;
//import com.travelbros.travelbros.repositories.*;
//import com.travelbros.travelbros.utils.Calculator;
//import com.travelbros.travelbros.utils.Utils;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/calculator")
//public class CalculatorController {
//
//// Dependency Injection
//    private final VehicleRepository vehicleDao;
//    private final TripRepository tripDao;
//    private final UserRepository userDao;
//    private final CalculatorRepository calculatorDao;
//
//    private final BudgetRepository budgetDao;
//
////////////////////// Constructors ////////////////////
//    public CalculatorController(VehicleRepository vehicleDao,CalculatorRepository calculatorDao, BudgetRepository budgetDao, UserRepository userDao, TripRepository tripDao) {
//        this.vehicleDao = vehicleDao;
//        this.calculatorDao = calculatorDao;
//        this.userDao = userDao;
//        this.budgetDao = budgetDao;
//        this.tripDao = tripDao;
//    }
//
//
//    // Get method to show create.html view with empty budget object added to model
//    @GetMapping
//    public String createCalculator(Model model) {
//        model.addAttribute("calculator", new Calculator());
//        return "calculator/create";
//    }
//
//
//    // Post method to receive post budget and save to database
//    @PostMapping("/create")
//    public String submitCalculator(@ModelAttribute Calculator calculator) {
////        User user = userDao.findById(Utils.currentUserId());
////        Budget budget = budgetDao.findById(Utils.currentUserId());
////        user.trip.setBudget(budget);
////        calculatorDao.save(calculator);
////        User user = userDao.findById(Utils.currentUserId());
////        Trip trip = tripDao.findById(Utils.currentTripId());
////        Vehicle vehicle = vehicleDao.findByTrip(trip);
////        Budget budget = trip.getTripBudget();
////        double tripStops = Calculator.numberOfStops(trip.getDistance(), vehicle.getMpg(), vehicle.getTankSize());
//
//        return "redirect:/calculator";
//    }
//
//
//
//}
