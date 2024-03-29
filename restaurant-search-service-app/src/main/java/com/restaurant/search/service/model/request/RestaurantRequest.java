/**
 * 
 */
package com.restaurant.search.service.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to map the request data to our POJO.
 *
 */
@ApiModel(description = "This model will contain the request values coming from the caller.")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestaurantRequest {

	/*
	 * @ApiModelProperty(notes = "the restaurant values coming from the request")
	 * private Restaurant restaurant;
	 */

	@ApiModelProperty(notes = "location of the restaurant")
	private String location;

	@ApiModelProperty(notes = "distance of the restaurant")
	private long distance;

	@ApiModelProperty(notes = "cuisine type of the restaurant")
	private String cuisine;

	@ApiModelProperty(notes = "the budget of the restaurant")
	private String budget;

	@ApiModelProperty(notes = "restaurant rating")
	private int ratings;

	@ApiModelProperty(notes = "restaurant name")
	private String name;

	@ApiModelProperty(notes = "item name")
	private String itemName;

	@ApiModelProperty(notes = "the search type")
	private String type;

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the distance
	 */
	public long getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(long distance) {
		this.distance = distance;
	}

	/**
	 * @return the cuisine
	 */
	public String getCuisine() {
		return cuisine;
	}

	/**
	 * @param cuisine the cuisine to set
	 */
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	/**
	 * @return the budget
	 */
	public String getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(String budget) {
		this.budget = budget;
	}

	/**
	 * @return the ratings
	 */
	public int getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantRequest [location=");
		builder.append(location);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", cuisine=");
		builder.append(cuisine);
		builder.append(", budget=");
		builder.append(budget);
		builder.append(", ratings=");
		builder.append(ratings);
		builder.append(", name=");
		builder.append(name);
		builder.append(", itemName=");
		builder.append(itemName);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
