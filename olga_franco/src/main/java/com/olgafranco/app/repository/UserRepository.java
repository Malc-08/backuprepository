package com.olgafranco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olgafranco.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
