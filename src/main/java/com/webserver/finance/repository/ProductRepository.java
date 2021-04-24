package com.webserver.finance.repository;


import com.webserver.finance.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByProductCategoryAuthorizationClientCategoryId(int id);
    List<Product> findByProductCategoryId(int id_category);

    @Query("SELECT p FROM Product p WHERE p.name='Стоматолог'")
    public List<Product> getInfo();
}
