package com.travelbros.travelbros.services;

import com.travelbros.travelbros.models.TravelBrosUserDetails;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TravelBrosUserDetailsService implements UserDetailsService {

    public final UserRepository usersDao;

    public TravelBrosUserDetailsService(UserRepository usersDao) {
        this.usersDao = usersDao;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User details not found for user: " + username);
        } else {
            return new TravelBrosUserDetails(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
        }

    }
}
