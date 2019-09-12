/**
 * 
 */
package com.restaurant.search.service.service;

import java.util.List;

import com.restaurant.search.service.model.Restaurant;

/**
 * A Service interface which will be implemented by the service classes 
 * to perform specific operations.
 *
 */
public interface RestaurantSearchService {

	public List<Restaurant> getRestaurants(int pageNumber, int pageSize);

	public List<Restaurant> getByLocation(String location, int pageNumber, int pageSize);

	public List<Restaurant> getByDistance(long distance, int pageNumber, int pageSize);

	public List<Restaurant> getByRatings(int ratings, int pageNumber, int pageSize);

	public List<Restaurant> getByCuisine(String cuisine, int pageNumber, int pageSize);

	public List<Restaurant> getByName(String name, int pageNumber, int pageSize);

	public List<Restaurant> getByItem(String itemName, int pageNumber, int pageSize);

	public List<Restaurant> getByBudget(String budget, int pageNumber, int pageSize);

	public List<Double> getItemsPrice(List<Long> itemIds);
}
