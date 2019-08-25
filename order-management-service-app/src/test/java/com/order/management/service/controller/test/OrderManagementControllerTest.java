/**
 * 
 */
package com.order.management.service.controller.test;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.order.management.service.controller.OrderManagementController;
import com.order.management.service.handler.OrderManagementHandler;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;


/**
 * Test class for OrderManagementController.
 * This class will contain the junit test cases for the controller methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderManagementControllerTest {


	/**
	 * Injected mock to create a MVC mock
	 */
	@InjectMocks
	private OrderManagementController testController;
	
	/**
	 * OrderManagementHandler instance injected for testing
	 */
	@Mock
	private OrderManagementHandler testHandler;
	
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
		OrderRequest request = new OrderRequest();
		request.toString();
		ResponseEntity<OrderResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.placeOrder(Mockito.any(OrderRequest.class))).thenReturn(responseEntity);
		assertNotNull(testController.placeOrder(request));
	}
	
	/**
	 * JUNIT test method for updateOrder.
	 */
	@Test
	public void testUpdateOrder() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		ResponseEntity<OrderResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.updateOrder(Mockito.any(UpdateOrderRequest.class))).thenReturn(responseEntity);
		assertNotNull(testController.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for cancelOrder.
	 */
	@Test
	public void testCancelOrder() {
		long id = 2;
		ResponseEntity<OrderResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.cancelOrder(Mockito.anyLong())).thenReturn(responseEntity);
		assertNotNull(testController.cancelOrder(id));
	}
	
	/**
	 * JUNIT test method for viewOrders.
	 */
	@Test
	public void testViewOrders() {
		String userName = "username";
		int startIndex = 0;
		int endIndex = 10;
		ResponseEntity<OrderDetailsResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(testHandler.viewOrders(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(responseEntity);
		assertNotNull(testController.viewOrders(userName, startIndex, endIndex));
	}
}
