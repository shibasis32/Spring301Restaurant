package com.restaurant.search.service.exception;

/**
 * 
 * This is a user defined exception class which will be used for exception throwing
 *
 */
public class RestaurantNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestaurantNotFound() {
	}

	public RestaurantNotFound(String message) {
		super(message);
	}

	public RestaurantNotFound(Throwable cause) {
		super(cause);
	}

	public RestaurantNotFound(String message, Throwable cause) {
		super(message, cause);
	}

}
