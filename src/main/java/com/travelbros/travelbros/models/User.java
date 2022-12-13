package com.travelbros.travelbros.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

// Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 60)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Trip> trips;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comments> comments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Vehicle> userVehicles;

// Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Vehicle> getUserVehicles() {
        return userVehicles;
    }

    public void setUserVehicles(List<Vehicle> userVehicles) {
        this.userVehicles = userVehicles;
    }

    // Constructors

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String password, String email, List<Trip> trips, List<Comments> comments, List<Vehicle> userVehicles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.trips = trips;
        this.comments = comments;
        this.userVehicles = userVehicles;
    }
}

