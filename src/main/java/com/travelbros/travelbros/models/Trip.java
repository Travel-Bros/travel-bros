package com.travelbros.travelbros.models;

import javax.persistence.*;

@Entity
@Table(name = "trip")
public class Trip {
    //////////////////// Properties ////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "trip")
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

}
