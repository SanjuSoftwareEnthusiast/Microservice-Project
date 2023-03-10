package com.sanju.services;

import java.util.List;

import com.sanju.entities.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	List<Hotel> getAllHotels();
	Hotel getHotelById(String hotelId);
}
