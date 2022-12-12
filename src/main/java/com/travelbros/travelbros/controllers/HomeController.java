package com.travelbros.travelbros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showSplashPage(){
        return "landing_page/splash_page";
    }

    @GetMapping("/dashboard")
    public String showDashBoard() {
        return "/main_pages/main_page";
    }
}
