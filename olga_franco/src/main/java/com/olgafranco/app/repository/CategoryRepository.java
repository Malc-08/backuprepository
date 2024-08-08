package com.olgafranco.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.olgafranco.app.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}