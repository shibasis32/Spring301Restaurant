/**
 * 
 */
package com.restaurant.search.service.exception;

/**
 * 
 * This is a user defined exception class which will be used 
 * for exception throwing for null values in the request
 *
 */
public class BadNullRequest extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadNullRequest() {
	}

	public BadNullRequest(String message) {
		super(message);
	}

	public BadNullRequest(Throwable cause) {
		super(cause);
	}

	public BadNullRequest(String message, Throwable cause) {
		super(message, cause);
	}
}
