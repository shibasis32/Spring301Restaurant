/**
 * 
 */
package com.order.management.service.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.order.management.service.handler.OrderManagementHandler;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;
import com.order.management.service.service.OrderManagementService;

/**
 * This class will be used to get the request from the controller and 
 * perform any validations and will send the request to the service.
 * 
 * The handler is a component above service layer. It is responsible
 * for oraganizing a response for the incoming requests. 
 *
 */
@Component
public class OrderManagementHandlerImpl implements OrderManagementHandler{
	/**
	 * OrderManagementHandler instance injected which is responsible for organinizing the 
	 * requests.
	 */
	@Autowired
	private OrderManagementService omService;
	
	
	/**
	 * Handler method to place order as per request and perform 
	 * validation before passing it to the service layer.
	 * @param request - the request from the controller
	 * @return OrderResponse
	 */
	@Override
	public ResponseEntity<OrderResponse> placeOrder(OrderRequest request) {
		OrderResponse response = omService.placeOrder(request);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}


	/**
	 * Handler method to update order as per request and perform 
	 * validation before passing it to the service layer.
	 * @param request- the request from the controller
	 * @return OrderResponse
	 */
	@Override
	public ResponseEntity<OrderResponse> updateOrder(UpdateOrderRequest request) {
		OrderResponse response = omService.updateOrder(request);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}


	/**
	 * Handler method to delete order as per request and perform 
	 * validation before passing it to the service layer.
	 * @param id- the id from the controller
	 * @return OrderResponse
	 */
	@Override
	public ResponseEntity<OrderResponse> cancelOrder(long id) {
		OrderResponse response = omService.cancelOrder(id);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	/**
	 * Handler method to view order as per request and perform 
	 * validation before passing it to the service layer.
	 * @return OrderDetailsResponse
	 */
	@Override
	public ResponseEntity<OrderDetailsResponse> viewOrders(String userName, int startIndex, int endIndex) {
		Pageable pageablePage = PageRequest.of(startIndex, endIndex);
		OrderDetailsResponse response = omService.viewOrders(userName, pageablePage);
		return new ResponseEntity<OrderDetailsResponse>(response, HttpStatus.OK);
	}

}
