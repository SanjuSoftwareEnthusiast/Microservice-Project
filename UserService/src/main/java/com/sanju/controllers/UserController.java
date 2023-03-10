package com.sanju.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanju.entities.User;
import com.sanju.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
	   user = userService.saveUser(user);
	   return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingHotelBreak", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<?> getUserById(@PathVariable("userId")String userId)
	{
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	//creating fall back method for circuit breaker
	
	public ResponseEntity<?> ratingHotelFallback(String userId, Exception ex)
	{
		log.info("Fallback is executed because service is down :"+ex.getMessage());
		User user = new User("ojsnf", "dummy", "mf","dummy", null);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<?> getAllUsers()
	{
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}
}
