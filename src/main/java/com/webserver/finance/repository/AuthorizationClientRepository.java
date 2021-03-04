package com.webserver.finance.repository;

import com.webserver.finance.models.AuthorizationClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationClientRepository extends JpaRepository<AuthorizationClient,Integer> {
}
