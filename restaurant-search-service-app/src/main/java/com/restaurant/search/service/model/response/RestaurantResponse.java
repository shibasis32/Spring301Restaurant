/**
 * 
 */
package com.restaurant.search.service.model.response;

import java.util.List;

import com.restaurant.search.service.model.dto.RestaurantDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to send the response back to the caller.
 *
 */
@ApiModel(description = "This model will contain the response values to be sent to the caller.")
public class RestaurantResponse {
	@ApiModelProperty(notes = "the list of restaurants which will be sent to the caller.")
	private List<RestaurantDto> restaurants;

	/**
	 * @return the restaurants
	 */
	public List<RestaurantDto> getRestaurants() {
		return restaurants;
	}

	/**
	 * @param restaurants the restaurants to set
	 */
	public void setRestaurants(List<RestaurantDto> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantResponse [restaurants=");
		builder.append(restaurants);
		builder.append("]");
		return builder.toString();
	}

}
