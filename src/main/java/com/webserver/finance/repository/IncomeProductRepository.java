package com.webserver.finance.repository;

import com.webserver.finance.models.IncomeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeProductRepository extends JpaRepository<IncomeProduct,Integer> {
}
