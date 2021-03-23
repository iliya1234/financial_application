package com.webserver.finance.repository;

import com.webserver.finance.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductCategoryAuthorizationClientCategoryId(int id);
}
