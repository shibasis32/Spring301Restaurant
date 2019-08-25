/**
 * 
 */
package com.restaurant.search.service.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restaurant.search.service.model.Restaurant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to map the request data to our POJO.
 *
 */
@ApiModel(description = "This model will contain the request values coming from the caller.")
@JsonIgnoreProperties
public class RestaurantRequest {
	@ApiModelProperty(notes = "the restaurant values coming from the request")
	private Restaurant restaurant;
	@ApiModelProperty(notes = "the starting index for pagination")
	private int startIndex;
	@ApiModelProperty(notes = "the no of elements to be displayed in one page")
	private int noOfElements;

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

	/**
	 * @return the startIndex
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * @param startIndex the startIndex to set
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @return the noOfElements
	 */
	public int getNoOfElements() {
		return noOfElements;
	}

	/**
	 * @param noOfElements the noOfElements to set
	 */
	public void setNoOfElements(int noOfElements) {
		this.noOfElements = noOfElements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantRequest [restaurant=");
		builder.append(restaurant);
		builder.append(", startIndex=");
		builder.append(startIndex);
		builder.append(", endPage=");
		builder.append(noOfElements);
		builder.append("]");
		return builder.toString();
	}

}
