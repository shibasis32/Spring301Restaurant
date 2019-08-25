/**
 * 
 */
package com.restaurant.search.service.model.response;

import java.util.List;

import com.restaurant.search.service.model.Restaurant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to send the response back to the caller.
 *
 */
@ApiModel(description = "This model will contain the response values to be sent to the caller.")
public class RestaurantResponse {
	private String message;
	@ApiModelProperty(notes = "the list of restaurants which will be sent to the caller.")
	private List<Restaurant> restaurants;

	/**
	 * @return the restaurants
	 */
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	/**
	 * @param restaurants the restaurants to set
	 */
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantResponse [message=");
		builder.append(message);
		builder.append(", restaurants=");
		builder.append(restaurants);
		builder.append("]");
		return builder.toString();
	}

}
