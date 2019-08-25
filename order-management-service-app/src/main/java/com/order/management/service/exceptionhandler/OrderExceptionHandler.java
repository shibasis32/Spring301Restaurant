package com.order.management.service.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.model.OrderErrorResponse;

/**
 * Exception Handler class which will be used to handle the exceptions.
 *
 */
@ControllerAdvice
public class OrderExceptionHandler {

	/**
	 * Method to handle Order Not found exception.
	 * 
	 * @param prodExcep - the error object
	 * @return - OrderErrorResponse with ResponseEntity
	 */
	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderNotFound prodExcep) {
		OrderErrorResponse error = new OrderErrorResponse(HttpStatus.NOT_FOUND.value(),
				prodExcep.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<OrderErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	/**
	 * Method to handle all other exception.
	 * @param exc - the error object
	 * @return - OrderErrorResponse with ResponseEntity
	 */
	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(RuntimeException exc) {
		OrderErrorResponse error = new OrderErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exc.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<OrderErrorResponse>(error, HttpStatus.OK);
	}

}
