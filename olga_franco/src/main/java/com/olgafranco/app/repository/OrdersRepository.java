package com.olgafranco.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.olgafranco.app.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long>{

}
