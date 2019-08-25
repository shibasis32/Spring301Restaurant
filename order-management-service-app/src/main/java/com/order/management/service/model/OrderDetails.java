/**
 * 
 */
package com.order.management.service.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is a model class containing all the order details.
 *
 */
@ApiModel(description = " Entity used for Order Details")
@Entity
@Table(name = "Order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderDetailsId;
	@ApiModelProperty(notes = "name of the restaurant for which order will be placed")
	private String restaurantName;
	@ApiModelProperty(notes = "name of the user who will place the order")
	private String userName;
	@ApiModelProperty(notes = "total price of the items ordered")
	private double totalPrice;
	@ApiModelProperty(notes = "order status (COMPLETED/ACTIVE/CANCELED)")
	private String orderStatus;
	@ApiModelProperty(notes = "date of the ordered placed")
	private Date placedOrderDate;
	@ApiModelProperty(notes = "date of the ordered once it is completed")
	private Date completedOrderDate;

	@ApiModelProperty(notes = "list of the items ordered")
	@ElementCollection
	//@CollectionTable(name = "ItemIds", joinColumns = @JoinColumn())
	private List<String> itemIds;

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
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

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
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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
	 * @return the placedOrderDate
	 */
	public Date getPlacedOrderDate() {
		return placedOrderDate;
	}

	/**
	 * @param placedOrderDate the placedOrderDate to set
	 */
	public void setPlacedOrderDate(Date placedOrderDate) {
		this.placedOrderDate = placedOrderDate;
	}

	/**
	 * @return the completedOrderDate
	 */
	public Date getCompletedOrderDate() {
		return completedOrderDate;
	}

	/**
	 * @param completedOrderDate the completedOrderDate to set
	 */
	public void setCompletedOrderDate(Date completedOrderDate) {
		this.completedOrderDate = completedOrderDate;
	}

	/**
	 * @return the itemIds
	 */
	public List<String> getItemIds() {
		return itemIds;
	}

	/**
	 * @param itemIds the itemIds to set
	 */
	public void setItemIds(List<String> itemIds) {
		this.itemIds = itemIds;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetails [orderDetailsId=");
		builder.append(orderDetailsId);
		builder.append(", restaurantName=");
		builder.append(restaurantName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", placedOrderDate=");
		builder.append(placedOrderDate);
		builder.append(", completedOrderDate=");
		builder.append(completedOrderDate);
		builder.append(", itemIds=");
		builder.append(itemIds);
		builder.append("]");
		return builder.toString();
	}

}
