/**
 * 
 */
package com.restaurant.search.service.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.restaurant.search.service.model.Item;
import com.restaurant.search.service.model.Restaurant;

/**
 * This repository will search the restaurant based on the item name.
 *
 */
public interface ItemSearchRepository extends Repository<Item, Long>{
	@Query(value = "SELECT i.restaurant FROM Item i WHERE " +
            "i.itemName = :itemName"
    )
	List<Restaurant> findByItemName(@Param("itemName") String itemName, Pageable pageable);
	
	@Query(value = "SELECT i.restaurant FROM Item i WHERE " +
            "i.itemName = :itemName"
    )
	List<Restaurant> findByItemName(@Param("itemName") String itemName);
	
	@Query("SELECT i.price FROM Item i WHERE i.itemId IN (:itemids)") 
	List<Double> findItemPrices(@Param("itemids") List<Long> itemIds);
}
