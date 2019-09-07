/**
 * 
 */
package com.restaurant.search.service.handler.handlerImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.restaurant.search.service.enums.RestaurantParameter;
import com.restaurant.search.service.exception.BadNullRequest;
import com.restaurant.search.service.exception.TypeNotFound;
import com.restaurant.search.service.handler.RestaurantSearchHandler;
import com.restaurant.search.service.model.Restaurant;
import com.restaurant.search.service.model.dto.RestaurantDto;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;
import com.restaurant.search.service.service.RestaurantSearchService;

/**
 * This class will be used to get the request from the controller and perform
 * any validations and will send the request to the service.
 * 
 * The handler is a component above service layer. It is responsible for
 * organizing a response for the incoming requests.
 *
 */
@Component
public class RestaurantSearchHandlerImpl implements RestaurantSearchHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * RestaurantSearchService instance injected which is responsible for all
	 * Business and service related operations.
	 */
	@Autowired
	private RestaurantSearchService rsService;

	/**
	 * Inject the modelMapper instance for converting Dao object to DTO.
	 */
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Handler method to get list of restaurants and pass it to the service
	 */
	@Override
	public ResponseEntity<RestaurantResponse> getRestaurants(RestaurantRequest request, int pageNumber, int pageSize) throws IllegalArgumentException {
		RestaurantResponse response = new RestaurantResponse();
		List<RestaurantDto> restaurantsDto = null;
		RestaurantParameter rp = null;
		List<Restaurant> restaurants = null;
		if(request.getType() == null || StringUtils.isEmpty(request.getType())) {
			throw new TypeNotFound("Type should not be null. Please enter the search type");
		} 
		try {
			rp = RestaurantParameter.valueOf(request.getType().toUpperCase());
		} catch (IllegalArgumentException  e) {
			log.error(e.getMessage());
			throw new TypeNotFound("Please enter a valid type");
		}
		switch (rp) {
		case LOCATION:
			log.info("Location");
			if (request.getLocation() == null || StringUtils.isEmpty(request.getLocation())) {
				throw new BadNullRequest("Please provide the location. Location cannot be null or empty");
			}
			restaurants = rsService.getByLocation(request.getLocation(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case DISTANCE:
			log.info("Distance");
			if (request.getDistance() == 0 || StringUtils.isEmpty(request.getDistance())) {
				throw new BadNullRequest("Please provide the Distance. Distance cannot be null or empty");
			}
			restaurants = rsService.getByDistance(request.getDistance(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case RATING:
			log.info("RATINGS");
			if (request.getRatings() == 0 || StringUtils.isEmpty(request.getRatings())) {
				throw new BadNullRequest("Please provide the Rating. Rating cannot be null or empty");
			}
			restaurants = rsService.getByRatings(request.getRatings(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case BUDGET:
			log.info("BUDGET");
			if (request.getBudget() == null || StringUtils.isEmpty(request.getBudget())) {
				throw new BadNullRequest("Please provide the Budget. Budget cannot be null or empty");
			}
			restaurants = rsService.getByBudget(request.getBudget(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case CUISINE:
			log.info("CUISINE");
			if (request.getCuisine() == null || StringUtils.isEmpty(request.getCuisine())) {
				throw new BadNullRequest("Please provide the Cuisine. Cuisine cannot be null or empty");
			}
			restaurants = rsService.getByCuisine(request.getCuisine(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case NAME:
			log.info("NAME");
			if (request.getName() == null || StringUtils.isEmpty(request.getName())) {
				throw new BadNullRequest("Please provide the Name. Name cannot be null or empty");
			}
			restaurants = rsService.getByName(request.getName(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		case ITEMNAME:
			log.info("ITEM");
			if (request.getItemName() == null || StringUtils.isEmpty(request.getItemName())) {
				throw new BadNullRequest("Please provide the Item Name. Item Name cannot be null or empty");
			}
			restaurants = rsService.getByItem(request.getItemName(), pageNumber, pageSize);
			restaurantsDto = restaurants.stream().map(restaurant -> convertToDto(restaurant))
					.collect(Collectors.toList());
			break;
		}
		response.setRestaurants(restaurantsDto);
		return new ResponseEntity<RestaurantResponse>(response, HttpStatus.OK);
	}

	/**
	 * This method will convert the dao object to DTO object.
	 * 
	 * @param restaurant - the restaurant dao object
	 * @return - the restaurantDto object
	 */
	private RestaurantDto convertToDto(Restaurant restaurant) {
		RestaurantDto restaurantDto = modelMapper.map(restaurant, RestaurantDto.class);
		return restaurantDto;
	}

}
