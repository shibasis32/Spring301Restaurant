/**
 * 
 */
package com.order.management.service.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to send the response back to the caller.
 *
 */
@ApiModel(description = "This model will contain the response values to be sent to the caller.")
public class OrderResponse {
	@ApiModelProperty(notes = "message to the user after the order place/update/deleted/completed.")
	private String message;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderResponse [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

}
