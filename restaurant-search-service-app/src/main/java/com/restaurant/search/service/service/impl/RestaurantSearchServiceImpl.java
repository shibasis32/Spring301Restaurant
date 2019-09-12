/**
 * 
 */
package com.restaurant.search.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.restaurant.search.service.dao.ItemSearchRepository;
import com.restaurant.search.service.dao.RestaurantSearchRepository;
import com.restaurant.search.service.exception.RestaurantNotFound;
import com.restaurant.search.service.model.Restaurant;
//github.com/shibasis32/Spring301Restaurant.git
import com.restaurant.search.service.service.RestaurantSearchService;

/**
 * The service class will be used to perform all Business related operations.
 *
 */
@Service
@Transactional
public class RestaurantSearchServiceImpl implements RestaurantSearchService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * RestaurantSearchRepository instance injected which is responsible for all DB
	 * related operations.
	 */
	@Autowired
	private RestaurantSearchRepository rsRepository;

	/**
	 * pageablePage
	 */
	private Pageable pageablePage;

	/**
	 * ItemSearchRepository instance injected which is responsible for all DB
	 * related operations.
	 */
	@Autowired
	private ItemSearchRepository iRepository;

	/**
	 * This method will get the restaurant details coming from the dao layer.
	 */
	@Cacheable(value = "restaurantsName")
	@Override
	public List<Restaurant> getRestaurants(int pageNumber, int pageSize)
			throws RestaurantNotFound {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching all restaurants: {}");
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findAll(pageablePage).getContent();
			} else {
				restaurants = rsRepository.findAll();
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (Exception e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available currently");
			log.error(rnf.getMessage());
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by location coming from the dao
	 * layer.
	 */
	@Cacheable(value = "location")
	@Override
	public List<Restaurant> getByLocation(String location, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on ratings: {}", location);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByLocation(location, pageablePage);
			} else {
				restaurants = rsRepository.findByLocation(location);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given location: {}");
			log.error(rnf.getMessage(), location);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by distance coming from the dao
	 * layer.
	 */
	@Cacheable(value = "distance")
	@Override
	public List<Restaurant> getByDistance(long distance, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on ratings: {}", distance);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByDistance(distance, pageablePage);
			} else {
				restaurants = rsRepository.findByDistance(distance);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given distance: {}");
			log.error(rnf.getMessage(), distance);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by ratings coming from the dao
	 * layer.
	 */
	@Cacheable(value = "ratings")
	@Override
	public List<Restaurant> getByRatings(int ratings, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on ratings: {}", ratings);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByRatings(ratings, pageablePage);
			} else {
				restaurants = rsRepository.findByRatings(ratings);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given ratings: {}");
			log.error(rnf.getMessage(), ratings);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by cuisine coming from the dao
	 * layer.
	 */
	@Cacheable(value = "cuisine")
	@Override
	public List<Restaurant> getByCuisine(String cuisine, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on cuisine: {}", cuisine);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByCuisine(cuisine, pageablePage);
			} else {
				restaurants = rsRepository.findByCuisine(cuisine);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given cuisine: {}");
			log.error(rnf.getMessage(), cuisine);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by name coming from the dao
	 * layer.
	 */
	@Cacheable(value = "name")
	@Override
	public List<Restaurant> getByName(String name, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on name: {}", name);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByName(name, pageablePage);
			} else {
				restaurants = rsRepository.findByName(name);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given name: {}");
			log.error(rnf.getMessage(), name);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by item name coming from the dao
	 * layer.
	 */
	@Cacheable(value = "item_name")
	@Override
	public List<Restaurant> getByItem(String itemName, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on item_name: {}", itemName);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = iRepository.findByItemName(itemName, pageablePage);
			} else {
				restaurants = iRepository.findByItemName(itemName);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given itemName: {}");
			log.error(rnf.getMessage(), itemName);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will get the restaurant details by budget coming from the dao
	 * layer.
	 */
	@Cacheable(value = "budget")
	@Override
	public List<Restaurant> getByBudget(String budget, int pageNumber, int pageSize) {
		List<Restaurant> restaurants = new ArrayList<>();
		try {
			log.info("fetching restaurants based on budget: {}", budget);
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByBudget(budget, pageablePage);
			} else {
				restaurants = rsRepository.findByBudget(budget);
			}
			log.info("list of restaurants after fetching from DB: {}", restaurants);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		if (restaurants.isEmpty()) {
			RestaurantNotFound rnf = new RestaurantNotFound("Sorry no restaurants available for the given budget: {}");
			log.error(rnf.getMessage(), budget);
			throw rnf;
		}
		return restaurants;
	}

	/**
	 * This method will fetch the List of item prices based on the the list of items ids.
	 * @param itemIds - list of item ids.
	 * @return List of item prices.
	 */
	@Cacheable(value = "itemsprice")
	@Override
	public List<Double> getItemsPrice(List<Long> itemIds) {
		List<Double> itemPrices = new ArrayList<>();
		try {
			log.info("fetching item prices based on item id's: {}", itemIds);
			itemPrices = iRepository.findItemPrices(itemIds);
			log.info("list of item prices after fetching from DB: {}", itemPrices);
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Unknown Exception occured while fetching the data.", e); 
			log.error("Exception occured in Service class: {}", re.getMessage());
			throw re;
		}
		return itemPrices;
	}
}
