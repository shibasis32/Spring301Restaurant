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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.restaurant.search.service.dao.ItemSearchRepository;
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
	 * ItemSearchRepository instance injected for testing
	 */
	@Mock
	private ItemSearchRepository iRepository;

	/**
	 * pageablePage
	 */
	private Pageable pageablePage;
	
	/**
	 * restaurant
	 */
	private Restaurant restaurant;
	
	/**
	 * restaurantRequest
	 */
	private RestaurantRequest restaurantRequest;

	/**
	 * pageNumber
	 */
	private int pageNumber;

	/**
	 * pageSize
	 */
	private int pageSize;

	/**
	 * request
	 */
	private List<Restaurant> restaurantsList;

	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		restaurantsList = new ArrayList<>();
		restaurant = new Restaurant();
		restaurantRequest = new RestaurantRequest();
		pageNumber = 0;
		pageSize = 1;
		pageablePage = PageRequest.of(pageNumber, pageSize);
	}

	/**
	 * JUNIT test method for getRestaurants by location.
	 */
	@Test
	public void getRestaurantsLocation() {
		String location = "location";
		restaurantsList.add(restaurant);
		when(testRepository.findByLocation(Mockito.anyString(), Mockito.any(Pageable.class)))
				.thenReturn(restaurantsList);
		assertNotNull(testService.getByLocation(location, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by location page size is 0.
	 */
	@Test
	public void getRestaurantsLocationPageSize() {
		pageSize = 0;
		String location = "location";
		restaurantsList.add(restaurant);
		when(testRepository.findByLocation(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByLocation(location, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by location Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsLocationRE() {
		pageSize = 0;
		String location = "location";
		restaurantsList.add(restaurant);
		when(testRepository.findByLocation(Mockito.anyString())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByLocation(location, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by location Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsLocationEmpty() {
		pageSize = 0;
		String location = "location";
		when(testRepository.findByLocation(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByLocation(location, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by distance.
	 */
	@Test
	public void getRestaurantsDistance() {
		long distance = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByDistance(Mockito.anyLong(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getByDistance(distance, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Distance page size is 0.
	 */
	@Test
	public void getRestaurantsDistancePageSize() {
		pageSize = 0;
		long distance = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByDistance(Mockito.anyLong())).thenReturn(restaurantsList);
		assertNotNull(testService.getByDistance(distance, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by distance Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsDistanceRE() {
		pageSize = 0;
		long distance = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByDistance(Mockito.anyLong())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByDistance(distance, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by distance Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsDistanceEmpty() {
		pageSize = 0;
		long distance = 2;
		when(testRepository.findByDistance(Mockito.anyLong())).thenReturn(restaurantsList);
		assertNotNull(testService.getByDistance(distance, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ratings.
	 */
	@Test
	public void getRestaurantsRatings() {
		int ratings = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByRatings(Mockito.anyInt(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getByRatings(ratings, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ratings page size is 0.
	 */
	@Test
	public void getRestaurantsRatingsPageSize() {
		pageSize = 0;
		int ratings = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByRatings(Mockito.anyInt())).thenReturn(restaurantsList);
		assertNotNull(testService.getByRatings(ratings, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ratings Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsRatingsRE() {
		pageSize = 0;
		int ratings = 2;
		restaurantsList.add(restaurant);
		when(testRepository.findByRatings(Mockito.anyInt())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByRatings(ratings, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ratings Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsRatingsEmpty() {
		pageSize = 0;
		int ratings = 2;
		when(testRepository.findByRatings(Mockito.anyInt())).thenReturn(restaurantsList);
		assertNotNull(testService.getByRatings(ratings, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Cuisine.
	 */
	@Test
	public void getRestaurantsCuisine() {
		String cuisine = "Cuisine";
		restaurantsList.add(restaurant);
		when(testRepository.findByCuisine(Mockito.anyString(), Mockito.any(Pageable.class)))
				.thenReturn(restaurantsList);
		assertNotNull(testService.getByCuisine(cuisine, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Cuisine page size is 0.
	 */
	@Test
	public void getRestaurantsCuisinePageSize() {
		pageSize = 0;
		String cuisine = "Cuisine";
		restaurantsList.add(restaurant);
		when(testRepository.findByCuisine(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByCuisine(cuisine, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Cuisine Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsCuisineRE() {
		pageSize = 0;
		String cuisine = "Cuisine";
		restaurantsList.add(restaurant);
		when(testRepository.findByCuisine(Mockito.anyString())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByCuisine(cuisine, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Cuisine Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsCuisineEmpty() {
		pageSize = 0;
		String cuisine = "Cuisine";
		when(testRepository.findByCuisine(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByCuisine(cuisine, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by name.
	 */
	@Test
	public void getRestaurantsName() {
		String name = "Name";
		restaurantsList.add(restaurant);
		when(testRepository.findByName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getByName(name, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Name page size is 0.
	 */
	@Test
	public void getRestaurantsNamePageSize() {
		pageSize = 0;
		String name = "Name";
		restaurantsList.add(restaurant);
		when(testRepository.findByName(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByName(name, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Name Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsNameRE() {
		pageSize = 0;
		String name = "Name";
		restaurantsList.add(restaurant);
		when(testRepository.findByName(Mockito.anyString())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByName(name, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Name Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsNameEmpty() {
		pageSize = 0;
		String name = "Name";
		when(testRepository.findByName(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByName(name, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ItemName.
	 */
	@Test
	public void getRestaurantsItemName() {
		String itemName = "ItemName";
		restaurantsList.add(restaurant);
		when(iRepository.findByItemName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getByItem(itemName, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ItemName page size is 0.
	 */
	@Test
	public void getRestaurantsItemNamePageSize() {
		pageSize = 0;
		String itemName = "ItemName";
		restaurantsList.add(restaurant);
		when(iRepository.findByItemName(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByItem(itemName, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ItemName Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsItemNameRE() {
		pageSize = 0;
		String itemName = "ItemName";
		restaurantsList.add(restaurant);
		when(iRepository.findByItemName(Mockito.anyString())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByItem(itemName, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by ItemName Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsItemNameEmpty() {
		pageSize = 0;
		String itemName = "ItemName";
		when(iRepository.findByItemName(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByItem(itemName, pageNumber, pageSize));
	}
	
	/**
	 * JUNIT test method for getRestaurants by Budget.
	 */
	@Test
	public void getRestaurantsBudget() {
		String budget = "budget";
		restaurantsList.add(restaurant);
		when(testRepository.findByBudget(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(restaurantsList);
		assertNotNull(testService.getByBudget(budget, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Budget page size is 0.
	 */
	@Test
	public void getRestaurantsBudgetPageSize() {
		pageSize = 0;
		String budget = "budget";
		restaurantsList.add(restaurant);
		when(testRepository.findByBudget(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByBudget(budget, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Budget Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsBudgetRE() {
		pageSize = 0;
		String budget = "budget";
		restaurantsList.add(restaurant);
		when(testRepository.findByBudget(Mockito.anyString())).thenThrow(new RuntimeException());
		assertNotNull(testService.getByBudget(budget, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for getRestaurants by Budget Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsBudgetEmpty() {
		pageSize = 0;
		String budget = "budget";
		when(testRepository.findByBudget(Mockito.anyString())).thenReturn(restaurantsList);
		assertNotNull(testService.getByBudget(budget, pageNumber, pageSize));
	}
	
	/**
	 * JUNIT test method for get ALL Restaurants.
	 */
	@Test
	public void getRestaurantsTest() {
		restaurantsList.add(restaurant);
		Page<Restaurant> tasks = new PageImpl(restaurantsList);
		when(testRepository.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn(tasks);
		assertNotNull(testService.getRestaurants(restaurantRequest, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for get All Restaurants page size is 0.
	 */
	@Test
	public void getRestaurantsTestPageSize() {
		pageSize = 0;
		restaurantsList.add(restaurant);
		when(testRepository.findAll()).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(restaurantRequest, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for get All Restaurants Runtime Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void getRestaurantsTestRE() {
		pageSize = 0;
		restaurantsList.add(restaurant);
		when(testRepository.findAll()).thenThrow(new RuntimeException());
		assertNotNull(testService.getRestaurants(restaurantRequest, pageNumber, pageSize));
	}

	/**
	 * JUNIT test method for get All Restaurants Empty.
	 */
	@Test(expected = RestaurantNotFound.class)
	public void getRestaurantsTestEmpty() {
		pageSize = 0;
		when(testRepository.findAll()).thenReturn(restaurantsList);
		assertNotNull(testService.getRestaurants(restaurantRequest, pageNumber, pageSize));
	}
}