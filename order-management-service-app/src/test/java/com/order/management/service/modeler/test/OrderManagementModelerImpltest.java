/**
 * 
 */
package com.order.management.service.modeler.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.modeler.impl.OrderManagementModelerImpl;

/**
 * Test class for OrderManagementModelerImpltest.
 * This class will contain the junit test cases for the handler methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderManagementModelerImpltest {

	/**
	 * Injected mock for the Modeler class
	 */
	@InjectMocks
	private OrderManagementModelerImpl testModeler;
	
	/**
	 * order
	 */
	private OrderDetails order;
	
	/**
	 * order
	 */
	private List<String> items;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		order = new OrderDetails();
		List<String> items = new ArrayList<String>();
		items.add("1");
		items.add("4");
		items.add("5");
		order.setItemIds(items);
	}
	
	/**
	 * JUNIT test method for modelRequestData.
	 */
	@Test
	public void testModelRequestData() {
		OrderRequest request = new OrderRequest();
		request.setRestaurantName("Something");
		request.setUserName("user name");
		request.setItemIds(items);
		assertNotNull(testModeler.modelRequestData(request));
	}
	
	/**
	 * JUNIT test method for modelRequestData.
	 */
	@Test
	public void testMmodelupdateRequestData() {
		UpdateOrderRequest request = new UpdateOrderRequest();
		request.setRestaurantName("Something");
		request.setUserName("user name");
		request.setItemIds(items);
		request.setOrderDetailsId(1);
		assertNotNull(testModeler.modelupdateRequestData(request));
	}
}
