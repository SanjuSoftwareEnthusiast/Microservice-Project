package com.sanju.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanju.entities.Rating;
import com.sanju.repositories.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;
	
	@Override
	public Rating create(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

}
