package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
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

// Constructor
    public TripController(TripRepository tripDao, UserRepository userDao) {
        this.tripDao = tripDao;
        this.userDao = userDao;
    }

// Get method to show index.html view with all posts added to model
    @GetMapping
    public String allTrips(Model model){
        List<Trip> allTrips = tripDao.findAll();
        model.addAttribute("allTrips", allTrips);
        return "trips/index";
    }


// Get method to show show.html view with post added to model
    @GetMapping("/{id}")
    public String oneTrip(@PathVariable long id, Model model){
        Trip trip = tripDao.findById(id);
        model.addAttribute("trip", trip);
        return "trips/show";
    }


// Get method to show create.html view with empty post object added to model
    @GetMapping("/create")
    public String createTrip(Model model) {
        model.addAttribute("trip", new Trip());
        return "trips/create";
    }

// Post method to receive post object and save to database
    @PostMapping("/create")
    public String submitTrip(@ModelAttribute Trip trip) {
        User user = userDao.findById(Utils.currentUserId());
        trip.setUser(user);
        tripDao.save(trip);
        return "redirect:/posts";
    }




}
