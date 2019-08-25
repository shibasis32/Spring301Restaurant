/**
 * 
 */
package com.order.management.service.exceptionhandler.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.exceptionhandler.OrderExceptionHandler;

/**
 * Test class for RestaurantExceptionHandlerTest. This class will contain the
 * junit test cases for the exception handling methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderExceptionHandlerTest {
	/**
	 * Injected mock to create a OrderExceptionHandler instance
	 */
	@InjectMocks
	private OrderExceptionHandler testExceptionHandler;

	/**
	 * setup method for OrderManagementController test.
	 */
	@Before
	public void setup() {

	}

	/**
	 * JUNIT test method for HandleOrderException.
	 */
	@Test
	public void testHandleOrderException() {
		OrderNotFound orderNotFound = new OrderNotFound(new Throwable("Error"));
		assertNotNull(testExceptionHandler.handleException(orderNotFound));
	}

	/**
	 * JUNIT test method for RuntimeException.
	 */
	@Test
	public void testRuntimeException() {
		RuntimeException re = new RuntimeException("Runtime Exception");
		assertNotNull(testExceptionHandler.handleException(re));
	}

}
