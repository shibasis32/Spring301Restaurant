/**
 * 
 */
package com.order.management.service.service;

import org.springframework.data.domain.Pageable;

import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;

/**
 * A Service interface which will be implemented by the service classes 
 * to perform specific operations.
 *
 */
public interface OrderManagementService {

	OrderResponse placeOrder(OrderRequest request);

	OrderResponse updateOrder(UpdateOrderRequest request);

	OrderResponse cancelOrder(long id);

	OrderDetailsResponse viewOrders(String userName, Pageable pageablePage);

}
