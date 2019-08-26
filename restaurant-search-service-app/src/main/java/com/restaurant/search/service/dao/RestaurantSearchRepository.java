/**
 * 
 */
package com.restaurant.search.service.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.restaurant.search.service.model.Restaurant;

/**
 * This is a dao interface which extends JPARepository to
 * perform db operations.
 *
 */

//@Repository
public interface RestaurantSearchRepository extends Repository<Restaurant, Long> {

	List<Restaurant> findAll();

	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.location = :location OR "+
            "r.distance = :distance OR "+
            "r.cuisine = :cuisine OR "+
            "r.budget = :budget OR "+
            "r.ratings = :ratings OR "+
            "r.name = :name",
            nativeQuery = true
    )
	List<Restaurant> findByLocationOrDistanceOrCuisineOrBudgetOrRatingsOrName(@Param("location") String location, @Param("distance") long distance,
			@Param("cuisine") String cuisine, @Param("budget") String budget, 
			@Param("ratings") int ratings, @Param("name") String name, Pageable pageable);
	
	/*List<Restaurant> findByDistance(long distance, Pageable pageable);

	List<Restaurant> findByCuisine(String cuisine, Pageable pageable);
	
	List<Restaurant> findByBudget(String budget, Pageable pageable);
	
	List<Restaurant> findByRatings(int ratings, Pageable pageable);
	
	List<Restaurant> findByName(String name, Pageable pageable);*/
	
}