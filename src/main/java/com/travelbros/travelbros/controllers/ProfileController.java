package com.travelbros.travelbros.controllers;


import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/profile")
public class ProfileController {


// Dependency Injection
    private final UserRepository userDao;


// Constructor
    public ProfileController(UserRepository userDao){

        this.userDao = userDao;

    }

//    @GetMapping
//    public String showAllProfileTrips(Model model) {
//        User user = userDao.findById(Utils.currentUserId());
//        model.addAttribute("currentUser", user);
//
//        return "/user_profile/user_previous_trips";
//    }

    @GetMapping
    public String showPreviousTrips(Model model) {
        User currentUser = userDao.findById(Utils.currentUserId());

        model.addAttribute("currentUser", currentUser);


        return "user_profile/user_previous_trips";
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
        return "/profile/edit";
    }


// Post method to receive trip object and save to database
    @PostMapping("/{id}/edit")
    public String editProfile(@ModelAttribute User user, @PathVariable long id) {
        User currentUser = userDao.findById(Utils.currentUserId());
        if(user.equals(currentUser)){
            userDao.save(user);
//            return "redirect:/profile?user-saved";
// ^ use this once the view is created so that you can include a div that says "profile successfully updated"
        }
        return "redirect:/profile";
    }



}
