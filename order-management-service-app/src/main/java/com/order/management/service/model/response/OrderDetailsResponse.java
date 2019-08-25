/**
 * 
 */
package com.order.management.service.model.response;

import java.util.List;

import com.order.management.service.model.OrderDetails;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used as a modeled data class to model the data coming from
 * DB for the service.
 *
 */
@ApiModel(description = "This model will contain the response values to be sent to the caller.")
public class OrderDetailsResponse {
	@ApiModelProperty(notes = "the list of order details which will be sent to the caller.")
	private List<OrderDetails> orderList;

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

}
