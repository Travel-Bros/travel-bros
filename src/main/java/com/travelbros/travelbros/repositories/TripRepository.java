package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findById(long id);


}
