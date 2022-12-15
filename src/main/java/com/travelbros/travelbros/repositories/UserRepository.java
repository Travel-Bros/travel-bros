package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByUsername(String username);
    public List<Trip> findAllByOrderByIdDesc();
}
