/**
 * 
 */
package com.order.management.service.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Request class for update order request.
 *
 */
@ApiModel(description = "This model will contain the request values coming from the caller for updating the order.")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateOrderRequest {

	private long orderDetailsId;
	@ApiModelProperty(notes = "name of the restaurant.")
	private String restaurantName;
	@ApiModelProperty(notes = "user who will place the order.")
	private String userName;
	@ApiModelProperty(notes = "number of items in the order.")
	private List<Long> itemIds;

	/**
	 * @return the orderDetailsId
	 */
	public long getOrderDetailsId() {
		return orderDetailsId;
	}

	/**
	 * @param orderDetailsId the orderDetailsId to set
	 */
	public void setOrderDetailsId(long orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	/**
	 * @return the restaurantName
	 */
	public String getRestaurantName() {
		return restaurantName;
	}

	/**
	 * @param restaurantName the restaurantName to set
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the itemIds
	 */
	public List<Long> getItemIds() {
		return itemIds;
	}

	/**
	 * @param itemIds the itemIds to set
	 */
	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}

}
