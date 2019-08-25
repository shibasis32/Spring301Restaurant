package com.order.management.service.exception;

/**
 * 
 * This is a user defined exception class which will be used for exception throwing
 *
 */
public class OrderNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNotFound() {
	}

	public OrderNotFound(String message) {
		super(message);
	}

	public OrderNotFound(Throwable cause) {
		super(cause);
	}

	public OrderNotFound(String message, Throwable cause) {
		super(message, cause);
	}

}
