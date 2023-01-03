package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Calculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<Calculator, Long> {
    Calculator findById(long id);
}

