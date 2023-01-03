package com.travelbros.travelbros.repositories;

import com.travelbros.travelbros.models.MiscExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiscExpensesRepository extends JpaRepository<MiscExpenses, Long> {
    MiscExpenses findById(long id);
}

