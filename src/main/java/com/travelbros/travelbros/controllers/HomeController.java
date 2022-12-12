package com.travelbros.travelbros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    ////////////////// Landing Page Mapping //////////////////

    @GetMapping("/")
    public String showSplashPage(){
        return "landing_page/splash_page";
    }

    ////////////////// User's Authenticated Dashboard //////////////////
    @GetMapping("/dashboard")
    public String showDashBoard() {
        return "/main_pages/main_page";
    }

    ////////////////// Trip Planning View //////////////////
    // Refer tp TripController

    ////////////////// Final Budget View //////////////////
    @GetMapping("/budget")
    public String showFinalBudget() {
        return "/main_pages/budget_page";
    }



}
