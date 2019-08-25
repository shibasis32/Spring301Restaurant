/**
 * 
 */
package com.order.management.service.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is a model class containing the Exception or error details.
 */
@ApiModel(description = " Entity used for any error searching the restaurant")
public class OrderErrorResponse {

	@ApiModelProperty(notes = "HTTP Status of the response")
	private int status;
	@ApiModelProperty(notes = "The error message")
	private String message;
	@ApiModelProperty(notes = "The timeStamp of the request")
	private long timeStamp;
	
	/**
	 * Default constructor.
	 */
	public OrderErrorResponse() {
		
	}

	/**
	 * @param status
	 * @param message
	 * @param timeStamp
	 */
	public OrderErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
