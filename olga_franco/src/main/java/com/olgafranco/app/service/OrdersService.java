package com.olgafranco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olgafranco.app.model.Orders;
import com.olgafranco.app.repository.OrdersRepository;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	public List<Orders> findAll(){
		return ordersRepository.findAll();
	}
	
	 public Optional<Orders> findById(Long id) {
	        return ordersRepository.findById(id);
	    }
	 
	 public Orders save(Orders orders) {
	        return ordersRepository.save(orders);
	    }
	
	 public void deleteById(Long id) {
	        ordersRepository.deleteById(id);
	    }
}
