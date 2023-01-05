package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.Budget;
import com.travelbros.travelbros.models.MiscExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MiscExpensesRepository extends JpaRepository<MiscExpenses, Long> {
    MiscExpenses findById(long id);

    List<MiscExpenses> findAllByBudget(Budget budget);
}

