/**
 * 
 */
package com.restaurant.search.service.model.dto;

/**
 * This is a DTO class which will hold the values of DAO objects.
 *
 */
public class RestaurantDto {
	private String location;
	private long distance;
	private String cuisine;
	private String budget;
	private int ratings;
	private String name;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantDto [location=");
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
		builder.append("]");
		return builder.toString();
	}

}
