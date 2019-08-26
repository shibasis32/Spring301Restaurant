/**
 * 
 */
package com.restaurant.search.service.service.test;

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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.restaurant.search.service.dao.RestaurantSearchRepository;
import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.model.Restaurant;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.service.impl.RestaurantSearchServiceImpl;

/**
 * Test class for OrderManagementHandlerImplTest. This class will contain the
 * junit test cases for the service methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantSearchServiceImplTest {
	/**
	 * Injected mock for the Service class
	 */
	@InjectMocks
	private RestaurantSearchServiceImpl testService;

	/**
	 * RestaurantSearchRepository instance injected for testing
	 */
	@Mock
	private RestaurantSearchRepository testRepository;

	/**
	 * restaurant
	 */
	private Restaurant restaurant;
	
	/**
	 * pageRequest
	 */
	private Pageable pageRequest;
	

	/**
	 * request
	 */
	private RestaurantRequest request;

	/**
	 * request
	 */
	//private List<Restaurant> restaurantsList;

	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		restaurant = new Restaurant();
		request = new RestaurantRequest();
		//restaurantsList = new ArrayList<>();
		request.setStartIndex(0);
		request.setNoOfElements(10);
		pageRequest = PageRequest.of(request.getStartIndex(), request.getNoOfElements());
	}

	/**
	 * JUNIT test method for getRestaurants by location.
	 *//*
	@Test
	public void getRestaurantsLocation() {
		restaurant.setLocation("Global Vilalge");
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByLocation(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}
*/
	/**
	 * JUNIT test method for getRestaurants by budget.
	 *//*
	@Test
	public void getRestaurantsBudget() {
		restaurant.setBudget("Low");
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByBudget(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}*/

	/**
	 * JUNIT test method for getRestaurants by getCuisine.
	 *//*
	@Test
	public void getRestaurantsCuisine() {
		restaurant.setCuisine("Arabic");
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByCuisine(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}*/
/*
	*//**
	 * JUNIT test method for getRestaurants by getName.
	 *//*
	@Test
	public void getRestaurantsName() {
		restaurant.setName("Bihari mess");
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}

	*//**
	 * JUNIT test method for getRestaurants by getRatings.
	 *//*
	@Test
	public void getRestaurantsRatings() {
		restaurant.setRatings(4);
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByRatings(Mockito.anyInt(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}

	*//**
	 * JUNIT test method for getRestaurants by getDistance.
	 *//*
	@Test
	public void getRestaurantsDistance() {
		restaurant.setDistance(3);
		request.setRestaurant(restaurant);
		restaurantsList.add(restaurant);
		when(testRepository.findByDistance(Mockito.anyLong(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(request, pageRequest));
	}

	*//**
	 * JUNIT test method for getRestaurants exception.
	 *//*
	@Test(expected = RuntimeException.class)
	public void getRestaurantsException() {
		restaurant.setLocation("Global Vilalge");
		request.setRestaurant(restaurant);

		when(testRepository.findByLocation(Mockito.anyString(), Mockito.any(Pageable.class))).thenThrow(new RuntimeException());
		testService.getRestaurants(request, pageRequest);
	}
	*/
	/**
	 * JUNIT test method for getRestaurants for null.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsNull() {
		RestaurantRequest newRequest = new RestaurantRequest();
		Restaurant newRestaurant = new Restaurant();
		newRequest.setRestaurant(newRestaurant);
		assertNotNull(testService.getRestaurants(newRequest, pageRequest));
	}
	
	/**
	 * Junit test method for getRestaurants based on any request parameter.
	 */
	@Test
	public void getRestaurants() {
		RestaurantRequest newRequest = new RestaurantRequest();
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setLocation("Global Vilalge");
		newRequest.setRestaurant(newRestaurant);
		List<Restaurant> newRestaurantsList = new ArrayList<>();
		newRestaurantsList.add(newRestaurant);
		Mockito.when(testRepository.findByLocationOrDistanceOrCuisineOrBudgetOrRatingsOrName(newRestaurant.getLocation(), newRestaurant.getDistance(), 
				newRestaurant.getCuisine(), newRestaurant.getBudget(), newRestaurant.getRatings(), newRestaurant.getName(), pageRequest)).thenReturn(newRestaurantsList);
		assertNotNull(testService.getRestaurants(newRequest, pageRequest));
	}
	
	/**
	 * JUNIT test method for getRestaurants for Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsException() {
		RestaurantRequest newRequest = new RestaurantRequest();
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setLocation("Global Vilalge");
		newRequest.setRestaurant(newRestaurant);
		List<Restaurant> newRestaurantsList = new ArrayList<>();
		newRestaurantsList.add(newRestaurant);
		Mockito.when(testRepository.findByLocationOrDistanceOrCuisineOrBudgetOrRatingsOrName(newRestaurant.getLocation(), newRestaurant.getDistance(), 
				newRestaurant.getCuisine(), newRestaurant.getBudget(), newRestaurant.getRatings(), newRestaurant.getName(), pageRequest)).thenThrow(new RuntimeException());
		testService.getRestaurants(newRequest, pageRequest);
	}
}
