package com.travelbros.travelbros.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travelbros.travelbros.repositories.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    //////////////////// Properties ////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // trip joining
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private Budget tripBudget;

    @Column(nullable = false)
    private String startPoint;

    @Column(nullable = false)
    private String endPoint;

    @Column(nullable = false)
    private int stops;

    @Column(nullable = false)
    private double distance;

    // User joining
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    // Vehicle joining
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Column(nullable = false)
    private int numPpl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trip")
    private List<Comments> comments;


    // vehicle joining

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Budget getTripBudget() {
        return tripBudget;
    }

    public void setTripBudget(Budget tripBudget) {
        this.tripBudget = tripBudget;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public int getNumPpl() {
        return numPpl;
    }

    public void setNumPpl(int numPpl) {
        this.numPpl = numPpl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public Trip(){}

    public Trip(long id, User user, Budget tripBudget, String startPoint, String endPoint, int stops, double distance, int numPpl, Vehicle vehicle) {
        this.id = id;
        this.user = user;
        this.tripBudget = tripBudget;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.stops = stops;
        this.distance = distance;
        this.numPpl = numPpl;
        this.vehicle = vehicle;

    }

    public Trip(long id, User user, Budget tripBudget, String startPoint, String endPoint, int stops, double distance, int numPpl, List<Comments> comments, Vehicle vehicle) {
        this.id = id;
        this.user = user;
        this.tripBudget = tripBudget;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.stops = stops;
        this.distance = distance;
        this.numPpl = numPpl;
        this.comments = comments;
        this.vehicle = vehicle;

    }


}
