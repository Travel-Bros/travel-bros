package com.travelbros.travelbros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "user_profile/login_page";
    }

    @PostMapping("/login")
    public String loginSubmission(){
        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(){return "redirect:/login?logout";}
}
