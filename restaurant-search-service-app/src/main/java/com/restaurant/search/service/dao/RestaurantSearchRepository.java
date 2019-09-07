/**
 * 
 */
package com.restaurant.search.service.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.search.service.model.Restaurant;

/**
 * This is a dao interface which extends JPARepository to
 * perform db operations.
 *
 */

@Repository
public interface RestaurantSearchRepository extends PagingAndSortingRepository<Restaurant, Long> {

	Page<Restaurant> findAll(Pageable pageable);
	
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
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.location = :location",
            nativeQuery = true
    )
	List<Restaurant> findByLocation(@Param("location") String location, Pageable pageable);
	
	List<Restaurant> findByLocation(String location);
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.distance = :distance",
            nativeQuery = true
    )
	List<Restaurant> findByDistance(@Param("distance") long distance, Pageable pageable);
	
	List<Restaurant> findByDistance(long distance);

	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.cuisine = :cuisine",
            nativeQuery = true
    )
	List<Restaurant> findByCuisine(@Param("cuisine") String cuisine, Pageable pageable);
	
	List<Restaurant> findByCuisine(String cuisine);
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.budget = :budget",
            nativeQuery = true
    )
	List<Restaurant> findByBudget(@Param("budget") String budget, Pageable pageable);
	
	List<Restaurant> findByBudget(String budget);
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.ratings = :ratings",
            nativeQuery = true
    )
	List<Restaurant> findByRatings(@Param("ratings") int ratings, Pageable pageable);
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.ratings = :ratings",
            nativeQuery = true
    )
	List<Restaurant> findByRatings(int ratings);
	
	@Query(value = "SELECT * FROM Restaurant r WHERE " +
            "r.name = :name",
            nativeQuery = true
    )
	List<Restaurant> findByName(@Param("name") String name, Pageable pageable);
	
	List<Restaurant> findByName(String name);
	
}