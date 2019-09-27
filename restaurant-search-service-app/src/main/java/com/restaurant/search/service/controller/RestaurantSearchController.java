/**
 * 
 */
package com.restaurant.search.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.search.service.handler.RestaurantSearchHandler;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.ItemWrapperResponse;
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
	
	/**
	 * This method will fetch the list of restaurants with the specific request.
	 * @param pageNumber - the page number
	 * @param pageSize - the size of the paze
	 * @param request - the request from the user
	 * @return ResponseEntity<RestaurantResponse> - the Restaurant Response along with the HTTP status code
	 */
	@RequestMapping(value = "/getRestaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestaurantResponse> getRestaurants(@RequestParam(name="pagenum", defaultValue="0") Integer pageNumber, @RequestParam(name="size", defaultValue="0") Integer pageSize, @RequestBody RestaurantRequest request) {
		return rsHandler.getRestaurants(request, pageNumber, pageSize);
	}
	
	/**
	 * This method will get the list of items price based on the list of items id provided.
	 * @param itemsId - ItemWrapper of items id's coming from the request.
	 * @return ResponseEntity<>
	 */
	@GetMapping(value = "/getItemsPrice", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemWrapperResponse> getItemsPrice(@RequestParam(value="itemids") List<Long> itemids) {
		return rsHandler.getItemsPrice(itemids);
	}
}
