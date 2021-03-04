package com.webserver.finance.repository;
import com.webserver.finance.models.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory,Integer> {
}
