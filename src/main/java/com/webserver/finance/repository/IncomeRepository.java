package com.webserver.finance.repository;

import com.webserver.finance.models.Income;
import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeRepository extends JpaRepository<Income,Integer> {
    List<Income> findByIncomeProductIncomeCategoryClientsIdOrderByDateDesc(int id);
    Income findById(int id);
}
