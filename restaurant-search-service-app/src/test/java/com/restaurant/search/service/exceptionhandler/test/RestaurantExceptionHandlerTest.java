/**
 * 
 */
package com.restaurant.search.service.exceptionhandler.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.exception.BadNullRequest;
import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.exception.TypeNotFound;
import com.restaurant.search.service.exceptionhandler.RestaurantExceptionHandler;

/**
 * Test class for RestaurantExceptionHandlerTest. This class will contain the
 * junit test cases for the exception handling methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantExceptionHandlerTest {
	/**
	 * Injected mock to create a RestaurantExceptionHandler instance
	 */
	@InjectMocks
	private RestaurantExceptionHandler testExceptionHandler;
	
	
	/**
	 * setup method for OrderManagementController test.
	 */
	@Before
	public void setup() {
		
	}
	
	/**
	 * JUNIT test method for HandleRestaurantException.
	 */
	@Test
	public void testHandleRestaurantException() {
		RestaurantNotFound restaurantNotfound = new RestaurantNotFound(new Throwable("Error"));
		assertNotNull(testExceptionHandler.handleException(restaurantNotfound));
	}
	
	/**
	 * JUNIT test method for RuntimeException.
	 */
	@Test
	public void testRuntimeException() {
		RuntimeException re = new RuntimeException("Runtime Exception");
		assertNotNull(testExceptionHandler.handleException(re));
	}
	
	/**
	 * JUNIT test method for BadNullRequest.
	 */
	@Test
	public void testBadNullRequest() {
		BadNullRequest re = new BadNullRequest("BadNullRequest Exception");
		assertNotNull(testExceptionHandler.handleException(re));
	}
	
	/**
	 * JUNIT test method for TypeNotFound.
	 */
	@Test
	public void testTypeNotFound() {
		TypeNotFound re = new TypeNotFound("TypeNotFound Exception");
		assertNotNull(testExceptionHandler.handleException(re));
	}

}
