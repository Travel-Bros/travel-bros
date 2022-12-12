package com.travelbros.travelbros.utils;

import com.travelbros.travelbros.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {

    public static long currentUserId() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

}

