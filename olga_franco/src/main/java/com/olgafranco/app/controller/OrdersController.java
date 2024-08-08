package com.olgafranco.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olgafranco.app.model.Orders;
import com.olgafranco.app.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping
	public List<Orders> getAllOrders(){
		return ordersService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Orders> getOrdersById(@PathVariable Long id){
		Optional<Orders> orders = ordersService.findById(id);
		return orders.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());		
	}
	
	 @PostMapping
	    public Orders createOrders(@RequestBody Orders orders) {
	        return ordersService.save(orders);
	    }
	 
	 @PutMapping("/{id}")
		ResponseEntity<Orders> updateUser(@PathVariable Long id, @RequestBody Orders newOrdersData ) {
	    	Optional<Orders> order = ordersService.findById(id);
	    	if (order.isPresent())
	    	{
	    	return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	        if (ordersService.findById(id).isPresent()) {
	        	ordersService.deleteById(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 

}