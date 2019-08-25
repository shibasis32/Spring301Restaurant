/**
 * 
 */
package com.restaurant.search.service.service;

import org.springframework.data.domain.Pageable;

import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;

/**
 * A Service interface which will be implemented by the service classes 
 * to perform specific operations.
 *
 */
public interface RestaurantSearchService {

	public RestaurantResponse getRestaurants(RestaurantRequest request, Pageable pageablePage);
}
