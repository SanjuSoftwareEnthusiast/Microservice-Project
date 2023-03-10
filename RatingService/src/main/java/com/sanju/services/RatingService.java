package com.sanju.services;

import java.util.List;

import com.sanju.entities.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	List<Rating> getRatingsByUserId(String userId);
	List<Rating> getRatingsByHotelId(String hotelId);
	List<Rating> getAllRatings();
}
