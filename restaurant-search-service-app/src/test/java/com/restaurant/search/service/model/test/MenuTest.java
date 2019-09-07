/**
 * 
 */
package com.restaurant.search.service.model.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.model.Item;
import com.restaurant.search.service.model.Menu;
import com.restaurant.search.service.model.Restaurant;

/**
 * Test class for OrderDetails model. This class will contain the junit test
 * cases for the model methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MenuTest {

	private Restaurant res; 
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
	    res = new Restaurant();
	    res.setRestaurantId(4);
	}

	@Test
	public void testToString() {
		Menu menu = new Menu();
		menu.setMenuId(1);
		Item item1 = new Item();
		item1.setItemId(1);
		item1.setItemName("Chicken biriyani");
		item1.setPrice(34);
		item1.setRestaurant(res);
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		item1.toString();
		menu.setItems(items);
		menu.toString();
		assertNotNull(item1.getPrice());
		assertNotNull(item1.getRestaurant());
		assertNotNull(item1.getItemId());
		assertNotNull(item1.getItemName());
		assertNotNull(menu.getItems());
		assertNotNull(menu.getMenuId());
	}

}
