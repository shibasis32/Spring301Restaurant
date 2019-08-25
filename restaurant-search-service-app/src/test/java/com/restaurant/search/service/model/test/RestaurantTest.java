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
	 * setup method for OrderManagementHandlerImplTest.
	 */
	@Before
	public void setup() {
		menu = new Menu();
		menu.setItemName("Chicken biriyani");
		menu.setMenuId(1);
		menu.setPrice(12);
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
		restaurant.setMenu(menu);
		restaurant.toString();
		assertNotNull(restaurant.getBudget());
		assertNotNull(restaurant.getCuisine());
		assertNotNull(restaurant.getDistance());
		assertNotNull(restaurant.getLocation());
		assertNotNull(restaurant.getName());
		assertNotNull(restaurant.getRatings());
		assertNotNull(restaurant.getRestaurantId());
		assertNotNull(restaurant.getMenu());
	}
}
