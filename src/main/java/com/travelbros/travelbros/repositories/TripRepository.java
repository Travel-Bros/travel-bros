package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findById(long id);

    Trip findByUser(User user);

    Trip findByVehicle(Vehicle vehicle);

    public List<Trip> findAllByUserOrderByIdDesc(User user);
}
