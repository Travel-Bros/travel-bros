package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;


public class Utils {
    public final UserRepository usersDao;

    public Utils(UserRepository usersDao) { this.usersDao = usersDao;}

    public static long currentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}

