package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.repositories.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {


// Dependency Injection

    private final VehicleRepository vehicleDao;
    private final UserRepository usersDao;


// Constructor
    public VehicleController(UserRepository usersDao, VehicleRepository vehicleDao) {
        this.usersDao = usersDao;
        this.vehicleDao = vehicleDao;
    }






}
