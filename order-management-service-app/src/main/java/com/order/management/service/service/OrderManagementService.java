/**
 * 
 */
package com.order.management.service.service;

import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderResponse;

/**
 * A Service interface which will be implemented by the service classes 
 * to perform specific operations.
 *
 */
public interface OrderManagementService {

	OrderResponse placeOrder(OrderRequest request);

	OrderResponse updateOrder(UpdateOrderRequest request);

	OrderResponse cancelOrder(String userName, long id);

	OrderResponse viewOrders(String userName, int pageNumber, int size);

}
