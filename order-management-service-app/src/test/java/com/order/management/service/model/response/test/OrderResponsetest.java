/**
 * 
 */
package com.order.management.service.model.response.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.service.model.response.OrderResponse;

/**
 * Test class for OrderResponse model. This class will contain the junit
 * test cases for the model methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderResponsetest {

	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {

	}
	
	@Test
	public void testToString() {
		OrderResponse response = new OrderResponse();
		response.setMessage("Something");
		response.toString();
		assertTrue(response.getMessage() == "Something");
	}
}
