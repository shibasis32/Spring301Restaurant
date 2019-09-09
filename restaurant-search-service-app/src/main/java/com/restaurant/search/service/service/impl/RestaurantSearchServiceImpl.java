/**
 * 
 */
package com.restaurant.search.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findAll(pageablePage).getContent();
			} else {
				restaurants = rsRepository.findAll();
			}
		} catch (Exception e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given input");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByLocation(location, pageablePage);
			} else {
				restaurants = rsRepository.findByLocation(location);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given location");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByDistance(distance, pageablePage);
			} else {
				restaurants = rsRepository.findByDistance(distance);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given distance");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByRatings(ratings, pageablePage);
			} else {
				restaurants = rsRepository.findByRatings(ratings);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given rating");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByCuisine(cuisine, pageablePage);
			} else {
				restaurants = rsRepository.findByCuisine(cuisine);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given cuisine");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByName(name, pageablePage);
			} else {
				restaurants = rsRepository.findByName(name);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given name");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = iRepository.findByItemName(itemName, pageablePage);
			} else {
				restaurants = iRepository.findByItemName(itemName);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given item name");
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
			if (pageSize != 0) {
				pageablePage = PageRequest.of(pageNumber, pageSize);
				restaurants = rsRepository.findByBudget(budget, pageablePage);
			} else {
				restaurants = rsRepository.findByBudget(budget);
			}
		} catch (RuntimeException e) {
			throw new RuntimeException("Unknown Exception occured while fetching the data.", e);
		}
		if (restaurants.isEmpty()) {
			throw new RestaurantNotFound("Sorry no restaurants available for the given name");
		}
		return restaurants;
	}
}
