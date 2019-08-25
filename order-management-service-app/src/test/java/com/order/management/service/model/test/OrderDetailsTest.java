/**
 * 
 */
package com.order.management.service.model.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.service.model.OrderDetails;

/**
 * Test class for OrderDetails model. This class will contain the junit
 * test cases for the model methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderDetailsTest {
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {

	}
	
	@Test
	public void testToString() {
		OrderDetails response = new OrderDetails();
		response.setRestaurantName("Something");
		response.setTotalPrice(4);
		response.setUserName("Username");
		response.setCompletedOrderDate(new Date());
		response.setPlacedOrderDate(new Date());
		response.setOrderDetailsId(2);
		response.setOrderStatus("Complete");
		response.toString();
		assertNotNull(response.getCompletedOrderDate());
		assertNotNull(response.getPlacedOrderDate());
		assertNotNull(response.getUserName());
		assertNotNull(response.getOrderStatus());
		assertNotNull(response.getOrderDetailsId());
		assertNotNull(response.getRestaurantName());
		assertNotNull(response.getTotalPrice());
	}
}
