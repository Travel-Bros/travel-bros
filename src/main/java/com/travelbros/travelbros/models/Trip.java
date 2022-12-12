package com.travelbros.travelbros.models;
import com.travelbros.travelbros.repositories.*;
import javax.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {
    //////////////////// Properties ////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_id")
    private Budget tripBudget;

    @Column(nullable = false)
    private String startPoint;

    @Column(nullable = false)
    private String endPoint;

    @Column(nullable = false)
    private int stops;

    // Need to add @ManyToOne for Trip => User
    // User needs @OneToMany User => Trip

    @Column(nullable = false)
    private int numPpl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public Trip(){}



    public Trip(long id, User user, Budget tripBudget, String startPoint, String endPoint, int stops, int numPpl) {
        this.id = id;
        this.user = user;
        this.tripBudget = tripBudget;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.stops = stops;
        this.numPpl = numPpl;
    }


}
