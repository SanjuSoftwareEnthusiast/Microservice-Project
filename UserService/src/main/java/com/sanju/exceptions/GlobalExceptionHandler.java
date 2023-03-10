package com.sanju.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sanju.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse(message, true, HttpStatus.NOT_FOUND); 
	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); 
	}
}
