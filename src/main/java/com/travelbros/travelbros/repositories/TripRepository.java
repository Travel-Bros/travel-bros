package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findById(long id);

    public List<Trip> findAllByUserOrderByIdDesc(User user);
}
