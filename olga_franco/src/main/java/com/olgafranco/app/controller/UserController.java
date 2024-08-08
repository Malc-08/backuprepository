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


import com.olgafranco.app.model.User;

import com.olgafranco.app.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllCategories() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }            
      
    
    @PutMapping("/{id}")
	ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User newUserData ) {
    	Optional<User> user = userService.findById(id);
    	if (user.isPresent())
    	{
    	return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userService.findById(id).isPresent()) {
        	userService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
