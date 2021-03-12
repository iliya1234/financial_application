package com.webserver.finance.repository;

import com.webserver.finance.models.AuthorizationClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationClientRepository extends JpaRepository<AuthorizationClient,Integer> {

    List<AuthorizationClient> findByUsernameAndPassword(String username, String password);
}
