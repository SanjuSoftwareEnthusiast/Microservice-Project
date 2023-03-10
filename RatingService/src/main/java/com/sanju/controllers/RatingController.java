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

import com.sanju.entities.Rating;
import com.sanju.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<?> createRating(@RequestBody Rating rating)
	{
		rating = ratingService.create(rating);
		return new ResponseEntity<>(rating, HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getRatingByUserId(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<?> getRatingByHotelId(@PathVariable("hotelId") String hotelId)
	{
		List<Rating> ratings = ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllRatings()
	{
		List<Rating> ratings = ratingService.getAllRatings();
		return new ResponseEntity<>(ratings, HttpStatus.OK);
	}
}
