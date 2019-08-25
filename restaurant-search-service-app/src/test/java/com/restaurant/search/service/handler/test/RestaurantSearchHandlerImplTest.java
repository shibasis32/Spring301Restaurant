/**
 * 
 */
package com.restaurant.search.service.handler.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import com.restaurant.search.service.handler.handlerImpl.RestaurantSearchHandlerImpl;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.RestaurantResponse;
import com.restaurant.search.service.service.impl.RestaurantSearchServiceImpl;

/**
 * Test class for RestaurantSearchHandlerImplTest.
 * This class will contain the junit test cases for the handler methods.
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
	 * request
	 */
	private RestaurantRequest request;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		//pageRequest = new 
		request = new RestaurantRequest();
		request.setStartIndex(0);
		request.setNoOfElements(10);
	}
	
	/**
	 * JUNIT test method for getRestaurants.
	 */
	@Test
	public void testGetRestaurants() {
		RestaurantResponse response = new RestaurantResponse();
		response.toString();
		when(testService.getRestaurants(Mockito.any(RestaurantRequest.class), Mockito.any(Pageable.class))).thenReturn(response);
		assertNotNull(testHandler.getRestaurants(request));
	}
}
