/**
 * 
 */
package com.restaurant.search.service.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.search.service.model.Restaurant;

/**
 * This is a dao interface which extends JPARepository to
 * perform db operations.
 *
 */

@Repository
public interface RestaurantSearchRepository extends JpaRepository<Restaurant, Long> {

	List<Restaurant> findAll();

	List<Restaurant> findByLocation(String location, Pageable pageable);
	
	List<Restaurant> findByDistance(long distance, Pageable pageable);

	List<Restaurant> findByCuisine(String cuisine, Pageable pageable);
	
	List<Restaurant> findByBudget(String budget, Pageable pageable);
	
	List<Restaurant> findByRatings(int ratings, Pageable pageable);
	
	List<Restaurant> findByName(String name, Pageable pageable);
	
}