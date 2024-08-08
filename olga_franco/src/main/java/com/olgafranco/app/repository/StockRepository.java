package com.olgafranco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olgafranco.app.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}