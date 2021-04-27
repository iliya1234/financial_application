package com.webserver.finance.repository;

import com.webserver.finance.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByIncomeProductIncomeCategoryClientsIdOrderByDateDesc(int id);
    Income findById(int id);
}
