/**
 * 
 */
package com.order.management.service.model.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.service.model.OrderErrorResponse;

/**
 * Test class for RestaurantErrorResponse model. This class will contain the junit test
 * cases for the getter/setter methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderErrorResponseTest {

	
	/**
	 * RestaurantErrorResponse
	 */
	private OrderErrorResponse orderErrorResponse;
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
		orderErrorResponse = new OrderErrorResponse(200, "Success", 45);
		assertNotNull(orderErrorResponse);
	}
	
	/**
	 * Junit test case to test the getter/setter method of the RestaurantErrorResponse class
	 */
	@Test
	public void testGetterSetter() {
		orderErrorResponse = new OrderErrorResponse();
		orderErrorResponse.setMessage("message");
		orderErrorResponse.setStatus(3);
		orderErrorResponse.setTimeStamp(34);
		assertNotNull(orderErrorResponse.getMessage());
		assertNotNull(orderErrorResponse.getStatus());
		assertNotNull(orderErrorResponse.getTimeStamp());
	}
}
