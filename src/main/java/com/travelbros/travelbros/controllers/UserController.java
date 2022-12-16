package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.services.EmailService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    // Dependency Injection
    private final UserRepository usersDao;
    private final PasswordEncoder passwordEncoder;

    private final EmailService emailService;

    // Constructor
    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }


    // Get method to show registration.html with empty user object added to model
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "user_profile/registration";
    }

    // Post method to save new user to database after hashing password
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, HttpServletRequest request) {
        String plainPass = user.getPassword();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);
        authWithHttpServletRequest(request, user.getUsername(), plainPass);
        return "redirect:/dashboard";
    }


    private void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
        try {
            request.login(username, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}