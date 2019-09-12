package com.restaurant.search.service.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restaurant.search.service.exception.BadNullRequest;
import com.restaurant.search.service.exception.ItemNotFound;
import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.exception.TypeNotFound;
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
	 * @return - the Restaurant Error response with the HTTPStatus
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RestaurantNotFound prodExcep) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.NOT_FOUND.value(),
				prodExcep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Method to handle exception for null values in the request.
	 * @param exc
	 * @return - the Restaurant Error response with the HTTPStatus
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(BadNullRequest exc) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method to handle exception for invalid type value in the request.
	 * @param exc
	 * @return - the Restaurant Error response with the HTTPStatus
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(TypeNotFound exc) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Method to handle all other exception.
	 * @param exc
	 * @return - the Restaurant Error response with the HTTPStatus
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(RuntimeException exc) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Method to handle Item Not found exception.
	 * 
	 * @param prodExcep
	 * @return - the Restaurant Error response with the HTTPStatus
	 */
	@ExceptionHandler
	public ResponseEntity<RestaurantErrorResponse> handleException(ItemNotFound prodExcep) {
		RestaurantErrorResponse error = new RestaurantErrorResponse(HttpStatus.NOT_FOUND.value(),
				prodExcep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<RestaurantErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

}
