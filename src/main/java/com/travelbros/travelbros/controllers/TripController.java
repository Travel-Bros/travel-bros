package com.travelbros.travelbros.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travelbros.travelbros.models.*;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.services.TripService;
import com.travelbros.travelbros.utils.Calculator;
import com.travelbros.travelbros.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripController {

// Dependency Injection
    @Autowired
    private TripService tripService;
    private final TripRepository tripDao;
    private final UserRepository userDao;

    private final BudgetRepository budgetDao;



// Constructor
    public TripController(TripRepository tripDao, UserRepository userDao, BudgetRepository budgetDao) {
        this.tripDao = tripDao;
        this.userDao = userDao;
        this.budgetDao = budgetDao;
    }

// Get method to show index.html view with all trips added to model
    @GetMapping
    public String allTrips(Model model){
        List<Trip> allTrips = tripDao.findAll();
        model.addAttribute("allTrips", allTrips);
        return "trips/index";
    }


// Get method to show show.html view with trip added to model
    @GetMapping("/{id}")
    public String oneTrip(@PathVariable long id, Model model){
        Trip trip = tripDao.findById(id);
        model.addAttribute("trip", trip);
        return "trips/show";
    }


// Get method to show edit.html view with trip object added to model
@GetMapping("/{id}/edit")
    public String showEditTripForm(@PathVariable long id, Model model) {
        User user = userDao.findById(Utils.currentUserId());
        Trip trip = tripDao.findById(id);
        Budget budget = trip.getTripBudget();
        List<MiscExpenses> miscExpenses = budget.getMiscExpenses();
    //        User currentUser = userDao.findById(Utils.currentUserId());
    //        model.addAttribute("createTrip", new Trip());
    //        model.addAttribute("tripBudget", new Budget());
    //        model.addAttribute("currentUser", currentUser);
    ////        model.addAttribute("calculator", new Calculator());
    //        model.addAttribute("miscExpense", new MiscExpenses());

        model.addAttribute("tripBudget", budget);
        model.addAttribute("miscExpenses", miscExpenses);
        model.addAttribute("currentUser", user);
        model.addAttribute("miscExpense", new MiscExpenses());

        if(!user.equals(trip.getUser())) {
            return "redirect:/profile";
        }
        model.addAttribute("trip", trip);
        return "trips/edit";
    }


    // Post method to receive trip object and save to database
    @PostMapping("/{id}/edit")
    public String editTrip(@ModelAttribute Trip trip, @ModelAttribute Budget budget, @PathVariable long id, @ModelAttribute MiscExpenses miscExpenses, @RequestParam(name = "miscexp-title", required = false) List<String> miscTitle, @RequestParam(name = "miscexp-cost", required = false) List<Double> miscCost) {

        tripService.deleteOldMiscExpenseFromBudget(budget);
//        budgetDao.delete(trip.getTripBudget());
        User user = userDao.findById(Utils.currentUserId());
        trip.setUser(user);
        Trip currentTrip = tripDao.findById(id);
        Vehicle vehicle = trip.getVehicle();

        // Only edits post if correct user sending post request
        if(user.equals(currentTrip.getUser())){
            trip.setUser(user);
            trip.setStops(
                (int)
                Math.ceil(Calculator.numberOfStops
                (Calculator.convertMetersToMiles
                (trip.getDistance()),
                vehicle.getMpg(),
                vehicle.getTankSize()))
            );


            trip.setTripBudget(budget);
            tripDao.save(trip);
        }
        trip.setUser(user);
        tripDao.save(trip);
        return "redirect:/profile";
    }


// Get method to delete trip from database
    @GetMapping("/{id}/delete")
    public String deleteTrip(@PathVariable long id) {
        User user = userDao.findById(Utils.currentUserId());
        Trip trip = tripDao.findById(id);
        // Only deletes post if correct user sending post request
        if (user.getId() == trip.getUser().getId()) {
            tripDao.deleteById(trip.getId());
        }
        return "redirect:/profile";
    }


    // Get method to show create.html view with empty trip object added to model
    @GetMapping("/create")
    public String createTrip(Model model) {
        User currentUser = userDao.findById(Utils.currentUserId());
        model.addAttribute("createTrip", new Trip());
        model.addAttribute("tripBudget", new Budget());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("miscExpense", new MiscExpenses());

        if (currentUser.getUserVehicles().size() == 0) {
            return "redirect:/vehicles/create";
        }
        return "trips/trip_planner";
    }

    @PostMapping("/create")
    public String postTrip(Model model, @ModelAttribute Trip trip, @ModelAttribute Budget budget, @RequestParam(name = "miscexp-title", required = false) List<String> miscTitle, @RequestParam(name = "miscexp-cost", required = false) List<Double> miscCost) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Calculator calculator = new Calculator();
        System.out.println("Inside postTrip. trip received from user: ");
        System.out.println(mapper.writeValueAsString(trip));
        System.out.println("Inside postTrip. budget received from user: ");
        System.out.println(mapper.writeValueAsString(budget));
        // Current user
        User user = userDao.findById(Utils.currentUserId());
        System.out.printf("User: %s%n", user.getUsername());
        // Current user is set as the trip's user
        trip.setUser(user);
        tripDao.save(trip);
        // Vehicle is set to the user's trip
        Vehicle vehicle = trip.getVehicle();
        System.out.println("Vehicle: ");
        System.out.println(mapper.writeValueAsString(vehicle));
        // Number of stops is calculated using the vehicle's info & trip distance
        trip.setStops(
                (int)Math.ceil(
                Calculator.numberOfStops(
                trip.getDistance(),
                vehicle.getMpg(),
                vehicle.getTankSize())
            )
        );
        System.out.println("Trip: ");
        System.out.println(mapper.writeValueAsString(trip));
        budget = TripService.budgetToMiscExpenseMethod(trip, budget, miscTitle, miscCost);

        budget.setGas(calculator.expectedGasConsumptionForTrip(trip));

        trip.setTripBudget(budget);


        tripDao.save(trip);
        System.out.println("trip after saving: ");
        System.out.println(mapper.writeValueAsString(trip));

        model.addAttribute("trip", trip);


        return "redirect:/trips/calculator";
    }


// Testing trip planner template view
    @GetMapping("/testing")
    public String tripMapTest(Model model) {
        User currentUser = userDao.findById(Utils.currentUserId());
        model.addAttribute("createTrip", new Trip());
        return "trips/test-trip-planner";
    }

    // Post method to receive post trip and save to database
    @PostMapping("/testing")
    public String postingTrip(@ModelAttribute Trip trip) {
        User user = userDao.findById(Utils.currentUserId());
        trip.setUser(user);
        tripDao.save(trip);
        return "landing_page/splash_page";

    }

//    @GetMapping("/calculator")
//    public @ResponseBody Trip viewCalculator() {
//        return tripDao.findById(Utils.currentTripId());
//    }

    @GetMapping("/calculator")
    public String postingCalculator(Model model) {

        // Need to find trips that belong to the logged-in user
        // Need to grab all trips and put them in an array list
        // need to iterate through array list and find the most recent trip
        // return most recent trip owned by logged-in user
        Trip lastTrip = new Trip();
        Calculator calculator = new Calculator();

        User currentUser = userDao.findById(Utils.currentUserId());
        List<Trip> currentUserTrips = currentUser.getTrips();

        if (currentUser.getId() <= 0) {
            return "redirect:/login";
        }
        for (int i =0; i < currentUserTrips.size(); i++) {
            if (i == currentUserTrips.size() -1) {
                lastTrip = currentUserTrips.get(i);
            }
        }


        model.addAttribute("miscExpTotal", calculator.miscExpenseSum(lastTrip));

        model.addAttribute("lastTrip", lastTrip);
        return "budget/calculator";
    }



}
