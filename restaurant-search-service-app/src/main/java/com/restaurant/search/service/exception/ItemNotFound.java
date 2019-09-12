package com.restaurant.search.service.exception;

/**
 * 
 * This is a user defined exception class which will be used 
 * for exception throwing for any item not found. 
 *
 */
public class ItemNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFound() {
	}

	public ItemNotFound(String message) {
		super(message);
	}

	public ItemNotFound(Throwable cause) {
		super(cause);
	}

	public ItemNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
