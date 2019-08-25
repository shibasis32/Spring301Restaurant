package com.restaurant.search.service.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.model.RestaurantErrorResponse;

/**
 * Exception Handler class which will be used to handle the exceptions.
 *
 */
@ControllerAdvice
public class RestaurantExceptionHandler {

	/**
	 * Method to handle Restaurant Not found exception.
	 * 
	 * @param prodExcep
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantNotFound prodExcep) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.NOT_FOUND.value(),
				prodExcep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Method to handle all other exception.
	 * @param exc
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RuntimeException exc) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.OK);
	}

}
