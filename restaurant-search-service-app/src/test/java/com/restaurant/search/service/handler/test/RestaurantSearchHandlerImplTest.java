/**
 * 
 */
package com.restaurant.search.service.handler.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.enums.RestaurantParameter;
import com.restaurant.search.service.exception.BadNullRequest;
import com.restaurant.search.service.exception.TypeNotFound;
import com.restaurant.search.service.handler.handlerImpl.RestaurantSearchHandlerImpl;
import com.restaurant.search.service.model.Restaurant;
import com.restaurant.search.service.model.dto.RestaurantDto;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;
import com.restaurant.search.service.service.impl.RestaurantSearchServiceImpl;

/**
 * Test class for RestaurantSearchHandlerImplTest. This class will contain the
 * junit test cases for the handler methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantSearchHandlerImplTest {

	/**
	 * Injected mock to create a MVC mock
	 */
	@InjectMocks
	private RestaurantSearchHandlerImpl testHandler;

	/**
	 * OrderManagementService instance injected for testing
	 */
	@Mock
	private RestaurantSearchServiceImpl testService;
	
	/**
	 * Inject the modelMapper instance for converting Dao object to DTO.
	 */
	@Mock
	private ModelMapper modelMapper;

	/**
	 * request
	 */
	private RestaurantRequest request;

	/**
	 * restaurant
	 */
	private Restaurant restaurant;

	/**
	 * restaurants
	 */
	private List<Restaurant> restaurants;

	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		request = new RestaurantRequest();

		restaurants = new ArrayList<>();
	}

	/**
	 * JUNIT test method for getRestaurantsByLocation.
	 */
	@Test
	public void testGetRestaurantsByLocation() {
		request.setType(RestaurantParameter.LOCATION.toString());
		request.setLocation("location");
		int pageNum = 2;
		int size = 10;
		RestaurantResponse response = new RestaurantResponse();
		response.toString();
		when(testService.getByLocation(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}

	/**
	 * JUNIT test method for getRestaurantsByLocation Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByLocationNull() {
		request.setType(RestaurantParameter.LOCATION.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}

	/**
	 * JUNIT test method for getRestaurantsByDistance.
	 */
	@Test
	public void testGetRestaurantsByDistance() {
		request.setType(RestaurantParameter.DISTANCE.toString());
		request.setDistance(89898);
		int pageNum = 2;
		int size = 10;
		restaurant = new Restaurant();
		restaurant.setBudget("budget");
		restaurant.setCuisine("Cuisine");
		restaurant.setDistance(89898);
		restaurant.setLocation("location");
		restaurant.setName("name");
		restaurant.setRatings(3);
		restaurant.setRestaurantId(4);
		restaurants.add(restaurant);
		RestaurantDto restaurantDto = new RestaurantDto();
		restaurantDto.setBudget("budget");
		restaurantDto.setCuisine("Cuisine");
		restaurantDto.setDistance(89898);
		restaurantDto.setLocation("location");
		restaurantDto.setName("name");
		restaurantDto.setRatings(3);
		when(testService.getByDistance(Mockito.anyLong(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(restaurants);
		when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(restaurantDto);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
		assertNotNull(restaurantDto.getBudget());
		assertNotNull(restaurantDto.getCuisine());
		assertNotNull(restaurantDto.getDistance());
		assertNotNull(restaurantDto.getLocation());
		assertNotNull(restaurantDto.getName());
		assertNotNull(restaurantDto.getRatings());
		assertNotNull(restaurantDto.toString());
	}

	/**
	 * JUNIT test method for getRestaurantsByDistance Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByDISTANCENull() {
		request.setType(RestaurantParameter.DISTANCE.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for getRestaurantsByRATING.
	 */
	@Test
	public void testGetRestaurantsByRATING() {
		request.setType(RestaurantParameter.RATING.toString());
		request.setRatings(2);
		int pageNum = 2;
		int size = 10;
		when(testService.getByRatings(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}
	
	/**
	 * JUNIT test method for getRestaurantsByRATING Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void getRestaurantsByRATINGNull() {
		request.setType(RestaurantParameter.RATING.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for getRestaurantsByBudget.
	 */
	@Test
	public void testGetRestaurantsByBudget() {
		request.setType(RestaurantParameter.BUDGET.toString());
		request.setBudget("Budget");
		int pageNum = 2;
		int size = 10;
		when(testService.getByBudget(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}
	
	/**
	 * JUNIT test method for testGetRestaurantsByBudget Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByBudgetNull() {
		request.setType(RestaurantParameter.BUDGET.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for getRestaurantsByCuisine.
	 */
	@Test
	public void testGetRestaurantsByCuisine() {
		request.setType(RestaurantParameter.CUISINE.toString());
		request.setCuisine("Cuisine");
		int pageNum = 2;
		int size = 10;
		when(testService.getByCuisine(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}
	
	/**
	 * JUNIT test method for getRestaurantsByCuisine Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByCuisineNull() {
		request.setType(RestaurantParameter.CUISINE.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for getRestaurantsByName.
	 */
	@Test
	public void testGetRestaurantsByName() {
		request.setType(RestaurantParameter.NAME.toString());
		request.setName("name");
		int pageNum = 2;
		int size = 10;
		when(testService.getByName(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}
	
	/**
	 * JUNIT test method for getRestaurantsByCuisine Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByNameNull() {
		request.setType(RestaurantParameter.NAME.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for getRestaurantsByItemName.
	 */
	@Test
	public void testGetRestaurantsByItemName() {
		request.setType(RestaurantParameter.ITEMNAME.toString());
		request.setItemName("Item name");
		int pageNum = 2;
		int size = 10;
		when(testService.getByItem(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
				.thenReturn(restaurants);
		assertNotNull(testHandler.getRestaurants(request, pageNum, size));
	}
	
	/**
	 * JUNIT test method for getRestaurantsByCuisine Null.
	 */
	@Test(expected = BadNullRequest.class)
	public void testGetRestaurantsByItemNameNull() {
		request.setType(RestaurantParameter.ITEMNAME.toString());
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
	
	/**
	 * JUNIT test method for Invalid type.
	 */
	@Test(expected = TypeNotFound.class)
	public void testGetRestaurantsInvalidType() {
		request.setType("Type");
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}

	/**
	 * JUNIT test method for null type.
	 */
	@Test(expected = TypeNotFound.class)
	public void testGetRestaurantsNullType() {
		request.setType(null);
		int pageNum = 2;
		int size = 10;
		testHandler.getRestaurants(request, pageNum, size);
	}
}
