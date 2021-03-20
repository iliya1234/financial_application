package com.webserver.finance.repository;

import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    List<Purchase> findByAuthorizationClientId(Integer id);
}
