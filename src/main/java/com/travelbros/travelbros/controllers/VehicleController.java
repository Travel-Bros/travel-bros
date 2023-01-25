package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.models.Vehicle;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.repositories.VehicleRepository;
import com.travelbros.travelbros.utils.Utils;
import jdk.jshell.execution.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


// Get method to show index.html view with all vehicles added to model
    @GetMapping
    public String allVehicles(Model model){
        User currentUser = usersDao.findById(Utils.currentUserId());
        List<Vehicle> allVehicles = currentUser.getUserVehicles();
//        List<Vehicle> allVehicles = vehicleDao.findAll();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("allVehicles", allVehicles);
        return "vehicle/vehicle_list";
    }


// Get method to show show.html view with vehicle added to model
    @GetMapping("/{id}")
    public String oneVehicle(@PathVariable long id, Model model){
        Vehicle vehicle = vehicleDao.findById(id);
        model.addAttribute("vehicle", vehicle);
        return "vehicle/show";
    }


// Get method to show create.html view with empty vehicle object added to model
    @GetMapping("/create")
    public String createVehicle(Model model) {
        User currentUser = usersDao.findById(Utils.currentUserId());
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("currentUser", currentUser);
        return "vehicle/add_vehicle";
    }


// Post method to receive vehicle object and save to database
    @PostMapping("/create")
    public String submitVehicle(@ModelAttribute Vehicle vehicle, Model model) {
        User user = usersDao.findById(Utils.currentUserId());
        vehicle.setUser(user);
        vehicleDao.save(vehicle);
        return "redirect:/trips/create";
    }


// Get method to show edit.html view with vehicle object added to model
    @GetMapping("/{id}/edit")
    public String showEditVehicleForm(@PathVariable long id, Model model) {
        User user = usersDao.findById(Utils.currentUserId());
        Vehicle vehicle = vehicleDao.findById(id);
        model.addAttribute("currentUser", user);
        // redirects back to all posts if user is not the owner of the post
        if(!user.equals(vehicle.getUser())) {
            return "redirect:/vehicles";
        }
        model.addAttribute("vehicle", vehicle);
        return "vehicle/vehicle_id_edit";
    }


// Post method to receive vehicle object and save to database
    @PostMapping("/{id}/edit")
    public String editVehicle(@ModelAttribute Vehicle vehicle, @PathVariable long id) {
        User user = usersDao.findById(Utils.currentUserId());
        Vehicle currentVehicle = vehicleDao.findById(id);
        // Only edits post if correct user sending post request
        if(user.equals(currentVehicle.getUser())){
            vehicle.setUser(user);
            vehicleDao.save(vehicle);
        }
        vehicle.setUser(user);
        vehicleDao.save(vehicle);
        return "redirect:/vehicles";
    }


// Get method to delete vehicle from database
    @GetMapping("/{id}/delete")
    public String deleteVehicle(@PathVariable long id) {
        User user = usersDao.findById(Utils.currentUserId());
        Vehicle vehicle = vehicleDao.findById(id);
        // Only deletes post if correct user sending post request
        if (user.getId() == vehicle.getUser().getId()) {
            vehicleDao.delete(vehicle);
        }
        return "redirect:/vehicles";
    }


// adding comment pushing main :)

// Here's another comment

    // anotha one



}
