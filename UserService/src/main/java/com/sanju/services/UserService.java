package com.sanju.services;

import java.util.List;

import com.sanju.entities.User;


public interface UserService {

	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
}
