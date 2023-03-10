package com.sanju.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
}
