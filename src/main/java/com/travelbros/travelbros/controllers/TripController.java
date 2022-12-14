package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.BudgetRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trips")
public class TripController {

// Dependency Injection
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
        // redirects back to all posts if user is not the owner of the post
        if(!user.equals(trip.getUser())) {
            return "redirect:/posts";
        }
        model.addAttribute("trip", trip);
        return "/trips/edit";
    }


    // Post method to receive trip object and save to database
    @PostMapping("/{id}/edit")
    public String editTrip(@ModelAttribute Trip trip, @PathVariable long id) {
        User user = userDao.findById(Utils.currentUserId());
        Trip currentTrip = tripDao.findById(id);
        // Only edits post if correct user sending post request
        if(user.equals(currentTrip.getUser())){
            trip.setUser(user);
            tripDao.save(trip);
        }
        trip.setUser(user);
        tripDao.save(trip);
        return "redirect:/trips";
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


    // Testing trip planner template view
    // Get method to show create.html view with empty trip object added to model
    @GetMapping("/create")
    public String createTrip(Model model) {
        User currentUser = userDao.findById(Utils.currentUserId());
        model.addAttribute("createTrip", new Trip());
        return "trips/trip_planner";
    }


// Post method to receive post trip and save to database
    @PostMapping("/testing")
    public String postingTrip(@ModelAttribute Trip trip) {
        User user = userDao.findById(Utils.currentUserId());
        trip.setUser(user);
        tripDao.save(trip);
    return "/landing_page/splash_page";
    }

}
