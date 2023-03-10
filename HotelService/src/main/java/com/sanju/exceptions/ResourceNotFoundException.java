package com.sanju.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("Resource not found");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
	
}
