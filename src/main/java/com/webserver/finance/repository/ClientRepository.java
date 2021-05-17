package com.webserver.finance.repository;

import com.webserver.finance.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByAuthorizationId(int id);
}
