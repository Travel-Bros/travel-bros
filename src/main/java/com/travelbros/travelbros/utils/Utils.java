package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;


public class Utils {
    public final UserRepository usersDao;
    public final TripRepository tripsDao;

    public Utils(UserRepository usersDao, TripRepository tripsDao) {
        this.usersDao = usersDao;
        this.tripsDao = tripsDao;
    }

//    public static User currentUser() {
//        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    }

    public static long currentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    public static long currentTripId() {
        return ((Trip) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}

