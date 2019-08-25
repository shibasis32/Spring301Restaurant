/**
 * 
 */
package com.restaurant.search.service.model.response.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.model.Restaurant;
import com.restaurant.search.service.model.response.RestaurantResponse;

/**
 * Test class for OrderResponse model. This class will contain the junit
 * test cases for the model methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantResponsetest {
	
	/**
	 * restaurants
	 */
	private List<Restaurant> restaurants;
	/**
	 * setup method for RestaurantResponsetest.
	 */
	@Before
	public void setup() {
		restaurants = new ArrayList<Restaurant>();
		Restaurant resto = new Restaurant();
		resto.setBudget("low");
		Restaurant resto1 = new Restaurant();
		resto1.setDistance(8);
		restaurants.add(resto1);
		restaurants.add(resto);
	}
	
	@Test
	public void testToString() {
		RestaurantResponse response = new RestaurantResponse();
		response.setRestaurants(restaurants);
		response.setMessage("Something");
		response.toString();
		assertTrue(response.getMessage() == "Something");
		assertNotNull(response.getRestaurants());
	}
}
