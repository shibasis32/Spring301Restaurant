/**
 * 
 */
package com.restaurant.search.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.restaurant.search.service.handler.RestaurantSearchHandler;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;

import io.swagger.annotations.Api;

/**
 * RestaurantSearchController is controller class for restaurant search service
 * which will receive the request and pass the same to the handler class.
 *
 */
@Controller
@RequestMapping(value = "/search")
@Api(value="Information about the restaurants", tags = {"Restaurant Search Service"})
public class RestaurantSearchController {

	/**
	 * RestaurantSearchHandler instance injected which is responsible for organinizing the 
	 * requests.
	 */
	@Autowired
	private RestaurantSearchHandler rsHandler;
	
	@RequestMapping(value = "/getRestaurants", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantResponse> getRestaurants(@RequestBody RestaurantRequest request) {
		return rsHandler.getRestaurants(request);
	}
}
