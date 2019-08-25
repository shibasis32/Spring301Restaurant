/**
 * 
 */
package com.order.management.service.handler;

import org.springframework.http.ResponseEntity;

import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;

/**
 * This is a handler interface which will be implemented by the handler classes
 * to perform specific operations
 *
 */
public interface OrderManagementHandler {

	public ResponseEntity<OrderResponse> placeOrder(OrderRequest request);

	public ResponseEntity<OrderResponse> updateOrder(UpdateOrderRequest request);

	public ResponseEntity<OrderResponse> cancelOrder(long id);

	public ResponseEntity<OrderDetailsResponse> viewOrders(String userName, int startIndex, int endIndex);
}
