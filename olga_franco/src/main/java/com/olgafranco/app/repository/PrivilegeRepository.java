package com.olgafranco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.olgafranco.app.model.Privilege;


public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}