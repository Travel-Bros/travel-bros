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


// Get method to show edit.html view with post object added to model
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


    // Post method to receive post object and save to database
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


// Get method to delete post from database
    @GetMapping("/{id}/delete")
    public String deletePost(@PathVariable long id) {
        User user = userDao.findById(Utils.currentUserId());
        Trip trip = tripDao.findById(id);
        // Only deletes post if correct user sending post request
        if (user.getId() == trip.getUser().getId()) {
            tripDao.delete(trip);
        }
        return "redirect:/trips";
    }

    // Testing trip planner template view
    @GetMapping("/testing")
    public String testingTripPlannerView() {
        return "trips/trip_planner";
    }


}
