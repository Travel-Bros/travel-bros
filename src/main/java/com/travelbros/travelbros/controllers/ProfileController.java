package com.travelbros.travelbros.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/profile")
public class ProfileController {


// Dependency Injection
    private final UserRepository userDao;
    private final TripRepository tripDao;


// Constructor
    public ProfileController(UserRepository userDao, TripRepository tripDao){
        this.tripDao = tripDao;
        this.userDao = userDao;

    }


    @GetMapping
    public String showPreviousTrips(Model model) throws JsonProcessingException {
        User currentUser = userDao.findById(Utils.currentUserId());
//        List<Trip> sortedList = currentUser
        List<Trip> descendingOrderTrips = tripDao.findAllByUserOrderByIdDesc(currentUser);
//        List<Trip> userTrips = currentUser.getTrips();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("sortedTrips", descendingOrderTrips);
//        model.addAttribute("sortedTrips", userTrips);
        return "/user_profile/profile_page";
    }

// Get method to show edit.html view with trip object added to model
    @GetMapping("/{id}/edit")
    public String showEditProfileForm(@PathVariable long id, Model model) {
        User user = userDao.findById(Utils.currentUserId());
        // redirects back to all posts if user is not the owner of the post
        if(!user.equals(userDao.findById(id))) {
            return "redirect:/profile";
        }
        model.addAttribute("user", user);
        return "/user_profile/edit_user_profile";
    }


// Post method to receive trip object and save to database
    @PostMapping("/{id}/edit")
    public String editProfile(@ModelAttribute User user, @PathVariable long id) {
        User currentUser = userDao.findById(Utils.currentUserId());
        userDao.save(user);
//            return "redirect:/profile?user-saved";
// ^ use this once the view is created so that you can include a div that says "profile successfully updated"
//        }
        return "redirect:/profile";
    }



}
