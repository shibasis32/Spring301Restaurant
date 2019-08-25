/**
 * 
 */
package com.restaurant.search.service.handler.handlerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.restaurant.search.service.handler.RestaurantSearchHandler;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;
import com.restaurant.search.service.service.RestaurantSearchService;

/**
 * This class will be used to get the request from the controller and 
 * perform any validations and will send the request to the service.
 * 
 * The handler is a component above service layer. It is responsible
 * for oraganizing a response for the incoming requests. 
 *
 */
@Component
public class RestaurantSearchHandlerImpl implements RestaurantSearchHandler{

	/**
	 * RestaurantSearchService instance injected which is responsible for all 
	 * Business and service related operations.
	 */
	@Autowired
	private RestaurantSearchService rsService;
	/**
	 * Handler method to get list of restaurants and pass it to the service
	 */
	@Override
	public ResponseEntity<RestaurantResponse> getRestaurants(RestaurantRequest request) {
		Pageable pageablePage = PageRequest.of(request.getStartIndex(), request.getNoOfElements());
		RestaurantResponse response = rsService.getRestaurants(request, pageablePage);
		return new ResponseEntity<RestaurantResponse>(response, HttpStatus.OK);
	}

}
