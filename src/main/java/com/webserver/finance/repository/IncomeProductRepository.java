package com.webserver.finance.repository;

import com.webserver.finance.models.IncomeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncomeProductRepository extends JpaRepository<IncomeProduct,Integer> {
    List<IncomeProduct> findByIncomeCategoryId(int id);
    List<IncomeProduct> findByIncomeCategoryClientsId(int id);
}
