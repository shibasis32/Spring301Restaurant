/**
 * 
 */
package com.restaurant.search.service.model.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.model.RestaurantErrorResponse;

/**
 * Test class for RestaurantErrorResponse model. This class will contain the junit test
 * cases for the getter/setter methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantErrorResponseTest {

	
	/**
	 * RestaurantErrorResponse
	 */
	private RestaurantErrorResponse restaurantErrorResponse;
	/**
	 * setup method for RestaurantErrorResponseTest.
	 */
	@Before
	public void setup() {
	}
	
	/**
	 * Junit test case to test the parameterized constructor of RestaurantErrorResponse class 
	 */
	@Test
	public void testToString() {
		restaurantErrorResponse = new RestaurantErrorResponse(200, "Success", 45);
		assertNotNull(restaurantErrorResponse);
	}
	
	/**
	 * Junit test case to test the getter/setter method of the RestaurantErrorResponse class
	 */
	@Test
	public void testGetterSetter() {
		restaurantErrorResponse = new RestaurantErrorResponse();
		restaurantErrorResponse.setMessage("message");
		restaurantErrorResponse.setStatus(3);
		restaurantErrorResponse.setTimeStamp(34);
		assertNotNull(restaurantErrorResponse.getMessage());
		assertNotNull(restaurantErrorResponse.getStatus());
		assertNotNull(restaurantErrorResponse.getTimeStamp());
	}
}
