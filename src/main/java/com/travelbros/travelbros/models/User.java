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

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false)
    private String password;




}

