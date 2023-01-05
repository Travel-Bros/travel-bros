package com.travelbros.travelbros.repositories;


import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.MiscExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    Budget findById(long id);



}
