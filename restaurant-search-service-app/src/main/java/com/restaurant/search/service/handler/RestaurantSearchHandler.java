/**
 * 
 */
package com.restaurant.search.service.handler;

import org.springframework.http.ResponseEntity;

import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;

/**
 * This is a handler interface which will be implemented by the handler classes 
 * to perform specific operations
 *
 */
public interface RestaurantSearchHandler {

	public ResponseEntity<RestaurantResponse> getRestaurants(RestaurantRequest request, int pageNumber, int pageSize);
}
