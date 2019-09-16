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
import org.springframework.data.domain.Pageable;

import com.order.management.service.dao.OrderManagementServiceRespository;
import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.rest.response.ItemWrapperResponse;
import com.order.management.service.modeler.impl.OrderManagementModelerImpl;
import com.order.management.service.rest.client.RestClient;
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
	 * pageNum
	 */
	private int pageNum;
	
	/**
	 * itemResponse
	 */
	private ItemWrapperResponse itemResponse;
	
	/**
	 * OrderManagementModelerImpl instance injected for testing
	 */
	@Mock
	private RestClient restClient;
	
	/**
	 * doublePriceItems
	 */
	private List<Double> doublePriceItems;
	
	/**
	 * pageSize
	 */
	private int pageSize;
	
	/**
	 * order
	 */
	private OrderDetails order;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		doublePriceItems = new ArrayList<>();
		doublePriceItems.add((double) 1);
		doublePriceItems.add((double) 4);
		doublePriceItems.add((double) 5);
		itemResponse = new ItemWrapperResponse();
		itemResponse.setItemPrices(doublePriceItems);
		order = new OrderDetails();
		pageNum = 1;
		pageSize = 6;
	}
	
	/**
	 * JUNIT test method for placeOrder.
	 */
	@Test
	public void testPlaceOrder() {
		OrderRequest request = new OrderRequest();
		List<Long> items = new ArrayList<Long>();
		items.add((long) 1);
		items.add((long) 4);
		items.add((long) 5);
		order.setItemIds(items);
		when(testOmModeler.modelRequestData(Mockito.any(OrderRequest.class))).thenReturn(order);
		when(restClient.callExternalService(Mockito.anyString(), Mockito.anyList())).thenReturn(itemResponse);
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.placeOrder(request));
		assertNotNull(itemResponse.toString());
	}
	
	/**
	 * JUNIT test method for exception.
	 */
	@Test(expected = RuntimeException.class)
	public void testPlaceOrderException() {
		OrderRequest request = new OrderRequest();
		List<Long> items = new ArrayList<>();
		items.add((long) 1);
		items.add((long) 4);
		items.add((long) 5);
		order.setItemIds(items);
		when(testOmModeler.modelRequestData(Mockito.any(OrderRequest.class))).thenReturn(order);
		when(restClient.callExternalService(Mockito.anyString(), Mockito.anyList())).thenThrow(new RuntimeException());
		testService.placeOrder(request);
	}
	
	/**
	 * JUNIT test method for updateOrder.
	 */
	@Test
	public void testUpdateOrder() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		request.setUserName("user Name");
		request.setOrderDetailsId(1);
		List<Long> items = new ArrayList<>();
		items.add((long) 1);
		items.add((long) 4);
		items.add((long) 5);
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		order.setUserName("user Name");
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		when(testRepository.findByUserNameAndOrderDetailsId(Mockito.anyString(), Mockito.anyLong())).thenReturn(Optional.of(order));
		when(restClient.callExternalService(Mockito.anyString(), Mockito.anyList())).thenReturn(itemResponse);
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for updateOrder Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void testUpdateOrderException() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		List<Long> items = new ArrayList<>();
		items.add((long) 1);
		items.add((long) 4);
		items.add((long) 5);
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		when(testRepository.findByUserNameAndOrderDetailsId(order.getUserName(), order.getOrderDetailsId())).thenReturn(Optional.of(order));
		when(restClient.callExternalService(Mockito.anyString(), Mockito.anyList())).thenThrow(new RuntimeException());
		testService.updateOrder(request);
	}
	
	/**
	 * JUNIT test method for updateOrder empty value of order id.
	 */
	@Test
	public void testUpdateOrderEmpty() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		List<Long> items = new ArrayList<Long>();
		items.add((long) 1);
		items.add((long) 4);
		items.add((long) 5);
		order.setOrderDetailsId(1);
		order.setItemIds(items);
		when(testOmModeler.modelupdateRequestData(Mockito.any(UpdateOrderRequest.class))).thenReturn(order);
		//when(testRepository.findByUserNameAndOrderDetailsId(Mockito.anyString(), Mockito.anyLong())).thenReturn(Optional.empty());
		assertNotNull(testService.updateOrder(request));
	}
	
	/**
	 * JUNIT test method for cancelOrder.
	 */
	@Test
	public void cancelOrder() {
		long id = 1;
		String userName = "USER NAME";
		when(testRepository.findByUserNameAndOrderDetailsId(Mockito.anyString(), Mockito.anyLong())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenReturn(order);
		assertNotNull(testService.cancelOrder(userName, id));
	}
	
	/**
	 * JUNIT test method for cancelOrder Exception.
	 */
	@Test(expected = RuntimeException.class)
	public void cancelOrderException() {
		long id = 1;
		String userName = "USER NAME";
		when(testRepository.findByUserNameAndOrderDetailsId(Mockito.anyString(), Mockito.anyLong())).thenReturn(Optional.of(order));
		when(testRepository.save(Mockito.any(OrderDetails.class))).thenThrow(new RuntimeException());
		testService.cancelOrder(userName, id);
	}
	
	/**
	 * JUNIT test method for cancelOrder empty value of order id.
	 */
	@Test
	public void cancelOrderEmpty() {
		long id = 1;
		String userName = "USER NAME";
		when(testRepository.findByUserNameAndOrderDetailsId(Mockito.anyString(), Mockito.anyLong())).thenReturn(Optional.empty());
		assertNotNull(testService.cancelOrder(userName, id));
	}
	
	/**
	 * JUNIT test method for viewOrders.
	 */
	@Test
	public void testViewOrders() {
		String userName = "user Name";
		List<OrderDetails> getOrder = new ArrayList<>();
		order.setOrderStatus("Active");
		getOrder.add(order);
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(getOrder);
		assertNotNull(testService.viewOrders(userName, pageNum, pageSize));
	}
	
	/**
	 * JUNIT test method for viewOrdersNoPagination.
	 */
	@Test
	public void testViewOrdersNoPagination() {
		String userName = "user Name";
		List<OrderDetails> getOrder = new ArrayList<>();
		order.setOrderStatus("Active");
		pageSize = 0;
		getOrder.add(order);
		when(testRepository.findByUserName(Mockito.anyString())).thenReturn(getOrder);
		assertNotNull(testService.viewOrders(userName, pageNum, pageSize));
	}
	
	/**
	 * JUNIT test method for viewOrders OrderNotFound Excepiton.
	 */
	@Test(expected = OrderNotFound.class)
	public void testViewOrdersException() {
		String userName = "user Name";
		List<OrderDetails> getOrder = new ArrayList<>();
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenReturn(getOrder);
		testService.viewOrders(userName, pageNum, pageSize);
	}
	
	/**
	 * JUNIT test method for viewOrders RuntimeException.
	 *
	 */
	@Test(expected = RuntimeException.class)
	public void testViewOrdersRuntimeException() {
		String userName = "user Name";
		when(testRepository.findByUserName(Mockito.anyString(), Mockito.any(Pageable.class))).thenThrow(new RuntimeException());
		testService.viewOrders(userName, pageNum, pageSize);
	}
}
