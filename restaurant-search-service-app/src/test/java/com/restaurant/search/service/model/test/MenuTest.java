/**
 * 
 */
package com.restaurant.search.service.model.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.model.Menu;

/**
 * Test class for OrderDetails model. This class will contain the junit test
 * cases for the model methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MenuTest {

	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {

	}

	@Test
	public void testToString() {
		Menu menu = new Menu();
		menu.setItemName("Chicken biriyani");
		menu.setMenuId(1);
		menu.setPrice(12);
		menu.toString();
		assertNotNull(menu.getItemName());
		assertNotNull(menu.getPrice());
		assertNotNull(menu.getMenuId());
	}

}
