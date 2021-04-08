package com.webserver.finance.repository;
import com.webserver.finance.models.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory,Integer> {
    List<IncomeCategory> findByClientsId(int id);
}
