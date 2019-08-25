/**
 * 
 */
package com.order.management.service.handler.test;

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

import com.order.management.service.handler.impl.OrderManagementHandlerImpl;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;
import com.order.management.service.service.impl.OrderManagementServiceImpl;

/**
 * Test class for OrderManagementHandlerImplTest.
 * This class will contain the junit test cases for the handler methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderManagementHandlerImplTest {

	/**
	 * Injected mock to create a MVC mock
	 */
	@InjectMocks
	private OrderManagementHandlerImpl testHandler;
	
	/**
	 * OrderManagementService instance injected for testing
	 */
	@Mock
	private OrderManagementServiceImpl testService;
	
	/**
	 * response
	 */
	private OrderResponse response;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		response = new OrderResponse();
	}
	
	/**
	 * JUNIT test method for placeOrder.
	 */
	@Test
	public void testPlaceOrder() {
		OrderRequest request = new OrderRequest();
		when(testService.placeOrder(Mockito.any(OrderRequest.class))).thenReturn(response);
		assertNotNull(testHandler.placeOrder(request));
	}
	
	/**
	 * JUNIT test method for updateOrder.
	 */
	@Test
	public void updateOrder() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		when(testService.updateOrder(Mockito.any(UpdateOrderRequest.class))).thenReturn(response);
		assertNotNull(testHandler.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for cancelOrder.
	 */
	@Test
	public void cancelOrder() {
		long id = 3;
		when(testService.cancelOrder(Mockito.anyLong())).thenReturn(response);
		assertNotNull(testHandler.cancelOrder(id));
	}
	
	/**
	 * JUNIT test method for viewOrders.
	 */
	@Test
	public void viewOrders() {
		OrderDetailsResponse response = new OrderDetailsResponse();
		String name = "user name";
		when(testService.viewOrders(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(response);
		assertNotNull(testHandler.viewOrders(name, 0, 10));
	}
}
