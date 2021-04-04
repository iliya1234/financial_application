package com.webserver.finance.repository;

import com.webserver.finance.models.Target;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TargetRepository extends JpaRepository<Target,Integer> {
    List<Target> findByUsersId(int id);
}
