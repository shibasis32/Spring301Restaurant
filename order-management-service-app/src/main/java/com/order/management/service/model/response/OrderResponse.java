/**
 * 
 */
package com.order.management.service.model.response;

import java.util.List;

import com.order.management.service.model.OrderDetails;

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

	@ApiModelProperty(notes = "the list of order details which will be sent to the caller.")
	private List<OrderDetails> orderList;

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
	 * @return the orderList
	 */
	public List<OrderDetails> getOrderList() {
		return orderList;
	}

	/**
	 * @param orderList the orderList to set
	 */
	public void setOrderList(List<OrderDetails> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderResponse [message=");
		builder.append(message);
		builder.append(", orderList=");
		builder.append(orderList);
		builder.append("]");
		return builder.toString();
	}

}
