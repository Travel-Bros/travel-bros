package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findById(long id);
    Vehicle findByYear(String year);
    Vehicle findByMake(String make);
    Vehicle findByModel(String model);
    Vehicle findByTankSize(int tankSize);
    Vehicle findByMpg(double mpg);

//    Vehicle findByTrip(Trip trip);



}
