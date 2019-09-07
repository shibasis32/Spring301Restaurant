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
public class RestaurantTest {
	/**
	 * menu
	 */
	private Menu menu;
	
	/**
	 * items
	 */
	private List<Item> items;
	
	/**
	 * restaurant
	 */
	private Restaurant restaurant;
	
	/**
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		restaurant = new Restaurant();
		restaurant.setBudget("Low");
		restaurant.setCuisine("Arabic");
		restaurant.setDistance(34);
		restaurant.setLocation("Village area");
		restaurant.setName("Bihari mess");
		restaurant.setRatings(3);
		restaurant.setRestaurantId(3);
		menu = new Menu();
		Item item1 = new Item();
		item1.setItemId(1);
		item1.setItemName("Chicken biriyani");
		item1.setPrice(34);
		item1.setRestaurant(restaurant);
		items = new ArrayList<>();
		items.add(item1);
		menu.setMenuId(1);
	}

	@Test
	public void testToString() {
		Restaurant restaurant = new Restaurant();
		restaurant.setBudget("Low");
		restaurant.setCuisine("Arabic");
		restaurant.setDistance(34);
		restaurant.setLocation("Village area");
		restaurant.setName("Bihari mess");
		restaurant.setRatings(3);
		restaurant.setRestaurantId(3);
		restaurant.setItems(items);
		restaurant.toString();
		assertNotNull(restaurant.getBudget());
		assertNotNull(restaurant.getCuisine());
		assertNotNull(restaurant.getDistance());
		assertNotNull(restaurant.getLocation());
		assertNotNull(restaurant.getName());
		assertNotNull(restaurant.getRatings());
		assertNotNull(restaurant.getRestaurantId());
		assertNotNull(restaurant.getItems());
	}
}
