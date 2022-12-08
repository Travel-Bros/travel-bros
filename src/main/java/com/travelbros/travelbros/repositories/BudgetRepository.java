package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findById(long id);
}
