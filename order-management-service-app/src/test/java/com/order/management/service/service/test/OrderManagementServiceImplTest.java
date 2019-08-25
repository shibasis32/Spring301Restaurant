/**
 * 
 */
package com.order.management.service.service.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.order.management.service.dao.OrderManagementServiceRespository;
import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.modeler.impl.OrderManagementModelerImpl;
import com.order.management.service.service.impl.OrderManagementServiceImpl;

/**
 * Test class for OrderManagementHandlerImplTest.
 * This class will contain the junit test cases for the service methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderManagementServiceImplTest {

	/**
	 * Injected mock for the Service class
	 */
	@InjectMocks
	private OrderManagementServiceImpl testService;
	
	/**
	 * OrderManagementServiceRespository instance injected for testing
	 */
	@Mock
	private OrderManagementServiceRespository testRepository;
	
	/**
	 * OrderManagementModelerImpl instance injected for testing
	 */
	@Mock
	private OrderManagementModelerImpl testOmModeler;
	
	/**
	 * pageRequest
	 */
	private Pageable pageRequest;
	
	/**
	 * order
	 */
	private OrderDetails order;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		order = new OrderDetails();
	}
	
	/**
	 * JUNIT test method for placeOrder.
	 */
	@Test
	public void testPlaceOrder() {
		OrderRequest request = new OrderRequest();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setItemIds(items);
		when(testOmModeler.modelRequestData(Mockito.any(OrderRequest.class))).thenReturn(order);
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.placeOrder(request));
	}
	
	/**
	 * JUNIT test method for exception.
	 */
	@Test(expected = RuntimeException.class)
	public void testPlaceOrderException() {
		OrderRequest request = new OrderRequest();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setItemIds(items);
		when(testOmModeler.modelRequestData(Mockito.any(OrderRequest.class))).thenReturn(order);
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenThrow(new RuntimeException());
		testService.placeOrder(request);
	}
	
	/**
	 * JUNIT test method for updateOrder.
	 */
	@Test
	public void testUpdateOrder() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		when(testRepository.findByOrderDetailsId(order.getOrderDetailsId())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for updateOrder Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void testUpdateOrderException() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		when(testRepository.findByOrderDetailsId(order.getOrderDetailsId())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenThrow(new RuntimeException());
		testService.updateOrder(request);
	}
	
	/**
	 * JUNIT test method for updateOrder empty value of order id.
	 */
	@Test
	public void testUpdateOrderEmpty() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		when(testRepository.findByOrderDetailsId(Mockito.anyLong())).thenReturn(Optional.empty());
		assertNotNull(testService.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for cancelOrder.
	 */
	@Test
	public void cancelOrder() {
		long id = 1;
		when(testRepository.findByOrderDetailsId(Mockito.anyLong())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.cancelOrder(id));
	}
	
	/**
	 * JUNIT test method for cancelOrder Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void cancelOrderException() {
		long id = 1;
		when(testRepository.findByOrderDetailsId(Mockito.anyLong())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenThrow(new RuntimeException());
		testService.cancelOrder(id);
	}
	
	/**
	 * JUNIT test method for cancelOrder empty value of order id.
	 */
	@Test
	public void cancelOrderEmpty() {
		long id = 1;
		when(testRepository.findByOrderDetailsId(Mockito.anyLong())).thenReturn(Optional.empty());
		assertNotNull(testService.cancelOrder(id));
	}
	
	/**
	 * JUNIT test method for viewOrders.
	 */
	@Test
	public void testViewOrders() {
		pageRequest = PageRequest.of(0, 10);
		String userName = "user Name";
		List<OrderDetails> getOrder = new ArrayList<>();
		order.setOrderStatus("Active");
		getOrder.add(order);
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(getOrder);
		assertNotNull(testService.viewOrders(userName, pageRequest));
	}
	
	/**
	 * JUNIT test method for viewOrders OrderNotFound Excepiton.
	 */
	@Test(expected = OrderNotFound.class)
	public void testViewOrdersException() {
		pageRequest = PageRequest.of(0, 10);
		String userName = "user Name";
		List<OrderDetails> getOrder = new ArrayList<>();
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(getOrder);
		testService.viewOrders(userName, pageRequest);
	}
	
	/**
	 * JUNIT test method for viewOrders RuntimeException.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testViewOrdersRuntimeException() {
		pageRequest = PageRequest.of(0, 10);
		String userName = "user Name";
		//List<OrderDetails> getOrder = new ArrayList<>();
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenThrow(new RuntimeException());
		testService.viewOrders(userName, pageRequest);
	}
}
