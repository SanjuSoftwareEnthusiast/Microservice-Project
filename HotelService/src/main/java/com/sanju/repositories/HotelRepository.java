package com.sanju.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanju.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
