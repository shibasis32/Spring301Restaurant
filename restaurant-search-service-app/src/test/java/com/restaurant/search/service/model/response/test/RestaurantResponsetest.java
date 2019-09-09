/**
 * 
 */
package com.restaurant.search.service.model.response.test;

import static org.junit.Assert.assertNotNull;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

=======
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.model.Restaurant;
>>>>>>> branch 'master' of https://github.com/shibasis32/Spring301Restaurant.git
import com.restaurant.search.service.model.dto.RestaurantDto;
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
	private List<RestaurantDto> restaurants;
	/**
	 * setup method for RestaurantResponsetest.
	 */
	@Before
	public void setup() {
		restaurants = new ArrayList<>();
		RestaurantDto resto = new RestaurantDto();
		resto.setBudget("low");
		RestaurantDto resto1 = new RestaurantDto();
		resto1.setDistance(8);
		restaurants.add(resto1);
		restaurants.add(resto);
	}
	
	@Test
	public void testToString() {
		RestaurantResponse response = new RestaurantResponse();
		response.setRestaurants(restaurants);
		response.toString();
		assertNotNull(response.getRestaurants());
	}
}
