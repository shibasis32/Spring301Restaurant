/**
 * 
 */
package com.restaurant.search.service.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A model class for holding the Item data
 *
 */
@ApiModel(description = " Entity used by Menu Model")
@Entity
@Table(name = "item")
@JsonIgnoreProperties("restaurant")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	@ApiModelProperty(notes = "Name of the item")
	private String itemName;
	@ApiModelProperty(notes = "Price of the item")
	private double price;

	@OneToOne(fetch=FetchType.LAZY)
	private Restaurant restaurant;

	/**
	 * @return the itemId
	 */
	public long getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [itemId=");
		builder.append(itemId);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", price=");
		builder.append(price);
		builder.append(", restaurant=");
		builder.append(restaurant);
		builder.append("]");
		return builder.toString();
	}

}
