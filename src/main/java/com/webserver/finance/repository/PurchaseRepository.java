package com.webserver.finance.repository;

import com.webserver.finance.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
    //поиск по определенному клиенту, вывод продукта по имени
    List<Purchase> findByAuthorizationClientId(int id);
}
