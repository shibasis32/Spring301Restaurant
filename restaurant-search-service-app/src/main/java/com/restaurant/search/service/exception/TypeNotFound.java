/**
 * 
 */
package com.restaurant.search.service.exception;

/**
 * 
 * This is a user defined exception class which will be 
 * used for exception throwing
 *
 */
public class TypeNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeNotFound() {
	}

	public TypeNotFound(String message) {
		super(message);
	}

	public TypeNotFound(Throwable cause) {
		super(cause);
	}

	public TypeNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
