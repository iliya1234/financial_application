package com.webserver.finance.repository;

import com.webserver.finance.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income,Integer> {

}
