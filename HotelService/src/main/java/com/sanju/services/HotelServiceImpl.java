package com.sanju.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanju.entities.Hotel;
import com.sanju.exceptions.ResourceNotFoundException;
import com.sanju.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String hotelId = UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel with given hotelId not found..!!"));
	}

}
