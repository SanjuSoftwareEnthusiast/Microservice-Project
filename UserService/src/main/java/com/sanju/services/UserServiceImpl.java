package com.sanju.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sanju.Repositories.UserRepository;
import com.sanju.entities.Hotel;
import com.sanju.entities.Rating;
import com.sanju.entities.User;
import com.sanju.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method 
		//generate unique user id
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		/*User user = userRepository.findById(userId).get();
		if(user==null)
		{
			throw new ResourceNotFoundException("User with given user id not found!!");
		}
		return user;
		*/
		User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());	
		
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
		
		List<Rating> userRatings = new ArrayList<>();
		for(Rating r: ratings)
		{
			userRatings.add(r);
		}
		
		for(Rating rating: userRatings)
		{
			String hotelId = rating.getHotelId();
			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+hotelId, Hotel.class);
			rating.setHotel(hotel);
		}
		user.setRatings(userRatings);
		return user;
	}

}
