package com.webserver.finance.repository;

import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
}
