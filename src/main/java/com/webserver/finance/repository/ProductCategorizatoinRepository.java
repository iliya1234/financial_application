package com.webserver.finance.repository;

import com.webserver.finance.models.ProductCategorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategorizatoinRepository extends JpaRepository<ProductCategorization,Integer> {
}
