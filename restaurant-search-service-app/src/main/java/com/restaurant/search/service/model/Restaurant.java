/**
 * 
 */
package com.restaurant.search.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Model class for restaurant which will hold the restaurant data.
 *
 */
@ApiModel(description = " Entity used for Restaurant")
@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long restaurantId;
	@ApiModelProperty(notes = "location of the restaurant")
	private String location;
	@ApiModelProperty(notes = "distance of the restaurant")
	private long distance;
	@ApiModelProperty(notes = "the cuisine type of the restaurant")
	private String cuisine;
	@ApiModelProperty(notes = "the budget of the restaurant")
	private String budget;
	@ApiModelProperty(notes = "restaurant rating")
	private int ratings;
	@ApiModelProperty(notes = "restaurant name")
	private String name;
	
	@ApiModelProperty(notes = "the menu of the restaurant")
	@OneToOne
	private Menu menu;

	/**
	 * @return the restaurantId
	 */
	public long getRestaurantId() {
		return restaurantId;
	}

	/**
	 * @param restaurantId the restaurantId to set
	 */
	public void setRestaurantId(long restaurantId) {
		this.restaurantId = restaurantId;
	}

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
	 * @return the menu
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [location=");
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
		builder.append(", menu=");
		builder.append(menu);
		builder.append("]");
		return builder.toString();
	}

}
