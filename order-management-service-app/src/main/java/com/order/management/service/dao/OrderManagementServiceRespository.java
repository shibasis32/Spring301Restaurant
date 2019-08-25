/**
 * 
 */
package com.order.management.service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.management.service.model.OrderDetails;

/**
 * This is a dao interface which extends JPARepository to perform db operations
 * on OrderDetails entity.
 *
 */
@Repository
public interface OrderManagementServiceRespository extends JpaRepository<OrderDetails, Long> {
	List<OrderDetails> findByUserName(String userName, Pageable pageable);

	Optional<OrderDetails> findByOrderDetailsId(long orderDetailsId);
	
}
