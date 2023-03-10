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

import com.sanju.entities.Hotel;
import com.sanju.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/test")
	public String test()
	{
		return "ok";
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Hotel hotel)
	{
		hotel = hotelService.create(hotel);
		return new ResponseEntity<>(hotel, HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<?> getById(@PathVariable("hotelId") String id)
	{
		Hotel hotel = hotelService.getHotelById(id);
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll()
	{
		List<Hotel> hotels = hotelService.getAllHotels();
		return new ResponseEntity<>(hotels, HttpStatus.OK);
	}
	
}
