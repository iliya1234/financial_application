package com.webserver.finance.repository;

import com.webserver.finance.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByAuthorizationClientCategoryId(int id);
}
