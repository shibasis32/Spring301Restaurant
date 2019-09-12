/**
 * 
 */
package com.order.management.service.handler.test;

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

import com.order.management.service.exception.InvalidRequest;
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
	 * orderRequest
	 */
	private OrderRequest orderRequest;
	
	/**
	 * updateOrderRequest
	 */
	private UpdateOrderRequest updateOrderRequest; 
	
	private List<Long> itemIds;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		itemIds = new ArrayList<>();
		itemIds.add(new Long(1));
		itemIds.add(new Long(2));
		orderRequest = new OrderRequest();
		orderRequest.setRestaurantName("Retaurant Name");
		orderRequest.setUserName("User name");
		orderRequest.setItemIds(itemIds);
		
		updateOrderRequest = new UpdateOrderRequest();
		updateOrderRequest.setRestaurantName("Retauraant Name");
		updateOrderRequest.setUserName("User Name");
		updateOrderRequest.setItemIds(itemIds);
		updateOrderRequest.setOrderDetailsId(3);
		response = new OrderResponse();
	}
	
	/**
	 * JUNIT test method for placeOrder.
	 */
	@Test
	public void testPlaceOrder() {
		when(testService.placeOrder(Mockito.any(OrderRequest.class))).thenReturn(response);
		assertNotNull(testHandler.placeOrder(orderRequest));
	}
	
	/**
	 * JUNIT test method for Invalid value.
	 */
	@Test(expected = InvalidRequest.class)
	public void testPlaceOrderInvalidRequest() {
		OrderRequest newOrderRequest = new OrderRequest();
		assertNotNull(testHandler.placeOrder(newOrderRequest));
	}
	
	/**
	 * JUNIT test method for updateOrder.
	 */
	@Test
	public void testUpdateOrder() {
		when(testService.updateOrder(Mockito.any(UpdateOrderRequest.class))).thenReturn(response);
		assertNotNull(testHandler.updateOrder(updateOrderRequest));
	}
	
	/**
	 * JUNIT test method for updateOrderInvalid Request.
	 */
	@Test(expected = InvalidRequest.class)
	public void testUpdateOrderInvalidRequest() {
		UpdateOrderRequest newUpdateOrderRequest = new UpdateOrderRequest();
		assertNotNull(testHandler.updateOrder(newUpdateOrderRequest));
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
	 * JUNIT test method for cancelOrder Invalid.
	 */
	@Test(expected = InvalidRequest.class)
	public void cancelOrderInvalid() {
		long id = 0;
		assertNotNull(testHandler.cancelOrder(id));
	}
	
	/**
	 * JUNIT test method for viewOrders.
	 */
	@Test
	public void viewOrders() {
		OrderDetailsResponse response = new OrderDetailsResponse();
		String name = "user name";
		when(testService.viewOrders(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(response);
		assertNotNull(testHandler.viewOrders(name, 0, 10));
	}
	
	/**
	 * JUNIT test method for viewOrders Invalid Request.
	 */
	@Test(expected = InvalidRequest.class)
	public void viewOrdersInvalidRequest() {
		String name = "";
		assertNotNull(testHandler.viewOrders(name, 0, 10));
	}
}
