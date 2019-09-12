/**
 * 
 */
package com.order.management.service.exception;

/**
 * 
 * This is a user defined exception class which will be used for exception throwing
 * for all invalid request.
 *
 */
public class InvalidRequest extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidRequest() {
	}

	public InvalidRequest(String message) {
		super(message);
	}

	public InvalidRequest(Throwable cause) {
		super(cause);
	}

	public InvalidRequest(String message, Throwable cause) {
		super(message, cause);
	}
}
