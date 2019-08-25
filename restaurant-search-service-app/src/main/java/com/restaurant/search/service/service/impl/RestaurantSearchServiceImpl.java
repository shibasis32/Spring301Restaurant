/**
 * 
 */
package com.restaurant.search.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restaurant.search.service.dao.RestaurantSearchRepository;
import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.model.Restaurant;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;
import com.restaurant.search.service.service.RestaurantSearchService;

/**
 * The service class will be used to perform all Business related operations.
 *
 */
@Service
@Transactional
public class RestaurantSearchServiceImpl implements RestaurantSearchService {

	/**
	 * RestaurantSearchRepository instance injected which is responsible for all DB
	 * related operations.
	 */
	@Autowired
	private RestaurantSearchRepository rsRepository;

	/**
	 * This method will get the restaurant details coming from the dao layer.
	 */
	@Override
	public RestaurantResponse getRestaurants(RestaurantRequest request, Pageable pageable) throws RestaurantNotFound{

		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		try {
			if (request.getRestaurant().getLocation() != null && !request.getRestaurant().getLocation().isEmpty()) {
				restaurants = rsRepository.findByLocation(request.getRestaurant().getLocation(), pageable);
			} else if (request.getRestaurant().getBudget() != null && !request.getRestaurant().getBudget().isEmpty()) {
				restaurants = rsRepository.findByBudget(request.getRestaurant().getBudget(), pageable);
			} else if (request.getRestaurant().getCuisine() != null
					&& !request.getRestaurant().getCuisine().isEmpty()) {
				restaurants = rsRepository.findByCuisine(request.getRestaurant().getCuisine(), pageable);
			} else if (request.getRestaurant().getName() != null && !request.getRestaurant().getName().isEmpty()) {
				restaurants = rsRepository.findByName(request.getRestaurant().getName(), pageable);
			} else if (!(request.getRestaurant().getRatings() == 0)) {
				restaurants = rsRepository.findByRatings(request.getRestaurant().getRatings(), pageable);
			} else if (!(request.getRestaurant().getDistance() == 0)) {
				restaurants = rsRepository.findByDistance(request.getRestaurant().getDistance(), pageable);
			}
		} catch (Exception e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		RestaurantResponse response = new RestaurantResponse();
		if(!restaurants.isEmpty()) {
			response.setRestaurants(restaurants);
			response.setMessage("Your search is successful");
		}  else {
			throw new RestaurantNotFound("Sorry no restaurants available for the given input");
		}
		return response;
	}
}
