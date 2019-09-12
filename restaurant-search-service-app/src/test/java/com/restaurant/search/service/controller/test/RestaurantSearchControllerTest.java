/**
 * 
 */
package com.restaurant.search.service.controller.test;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.restaurant.search.service.controller.RestaurantSearchController;
import com.restaurant.search.service.handler.RestaurantSearchHandler;
import com.restaurant.search.service.model.request.RestaurantRequest;
import com.restaurant.search.service.model.response.ItemWrapperResponse;
import com.restaurant.search.service.model.response.RestaurantResponse;

/**
* Test class for RestaurantSearchController.
* This class will contain the junit test cases for the controller methods.
*
*/
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestaurantSearchControllerTest {

	/**
	 * Injected mock to create a RestaurantSearchController instance
	 */
	@InjectMocks
	private RestaurantSearchController testController;
	
	/**
	 * RestaurantSearchHandler instance injected for testing
	 */
	@Mock
	private RestaurantSearchHandler testHandler;
	
	/**
	 * setup method for OrderManagementController test.
	 */
	@Before
	public void setup() {
	}
	
	/**
	 * JUNIT test method for placeOrder.
	 */
	@Test
	public void testPlaceOrder() {
		RestaurantRequest request = new RestaurantRequest();
		request.toString();
		int pageNum = 2;
		int size = 10;
		ResponseEntity<RestaurantResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.getRestaurants(Mockito.any(RestaurantRequest.class), Mockito.anyInt(), Mockito.anyInt())).thenReturn(responseEntity);
		assertNotNull(testController.getRestaurants(pageNum, size, request));
	}
	
	/**
	 * JUNIT test method for getItemsPrice.
	 */
	@Test
	public void testGetItemsPrice() {
		List<Long> itemids = new ArrayList<>();
		ResponseEntity<ItemWrapperResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.getItemsPrice(Mockito.anyList())).thenReturn(responseEntity);
		assertNotNull(testController.getItemsPrice(itemids));
	}
}
