package com.webserver.finance.repository;

import com.webserver.finance.models.IncomeCategorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeCategorizationRepository extends JpaRepository<IncomeCategorization,Integer> {
}
