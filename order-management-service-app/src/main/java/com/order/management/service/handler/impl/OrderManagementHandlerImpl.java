/**
 * 
 */
package com.order.management.service.handler.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.order.management.service.exception.InvalidRequest;
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
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
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
		if((request.getUserName() == null || StringUtils.isEmpty(request.getUserName())) 
				&& (request.getRestaurantName() == null || StringUtils.isEmpty(request.getRestaurantName()))
				&& (request.getItemIds() == null || CollectionUtils.isEmpty(request.getItemIds()))) {
			InvalidRequest ir = new InvalidRequest("Please provide the userName, restaurant name and list of item to place an order.");
			log.error(ir.getMessage());
			throw ir;
		}
		log.info("Calling the service to place order with the request: {}", request);
		OrderResponse response = omService.placeOrder(request);
		log.info("Getting the response after placing the order from the service: {}", response);
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
		if((request.getUserName() == null || StringUtils.isEmpty(request.getUserName())) 
				&& (request.getRestaurantName() == null || StringUtils.isEmpty(request.getRestaurantName()))
				&& (request.getItemIds() == null || CollectionUtils.isEmpty(request.getItemIds()))
				&& (request.getOrderDetailsId() == 0 || StringUtils.isEmpty(request.getOrderDetailsId()))) {
			InvalidRequest ir = new InvalidRequest("Please provide the order Id, userName, restaurant name and list of item to update an order.");
			log.error(ir.getMessage());
			throw ir;
		}
		log.info("Calling the service to update order with the request: {}", request);
		OrderResponse response = omService.updateOrder(request);
		log.info("Getting the response after updating the order from the service: {}", response);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}


	/**
	 * Handler method to delete order as per request and perform 
	 * validation before passing it to the service layer.
	 * @param id- the id from the controller
	 * @return OrderResponse
	 */
	@Override
	public ResponseEntity<OrderResponse> cancelOrder(String userName, long id) {
		if((id == 0 || StringUtils.isEmpty(id))
				&& (userName == null || StringUtils.isEmpty(userName))) {
			InvalidRequest ir = new InvalidRequest("Please provide the username and order Id to cancel an order.");
			log.error(ir.getMessage());
			throw ir;
		}
		log.info("Calling the service to delete order with the order id: {}", id," and username: {}", userName);
		OrderResponse response = omService.cancelOrder(userName, id);
		log.info("Getting the response after deleting the order from the service: {}", response);
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	/**
	 * Handler method to view order as per request and perform 
	 * validation before passing it to the service layer.
	 * @return OrderDetailsResponse
	 */
	@Override
	public ResponseEntity<OrderDetailsResponse> viewOrders(String userName, int pageNumber, int size) {
		if(userName == null || StringUtils.isEmpty(userName)) {
			InvalidRequest ir = new InvalidRequest("Please provide the user name to view the orders in your cart.");
			log.error(ir.getMessage());
			throw ir;
		}
		log.info("Calling the service to view orders for the userName: {}", userName);
		OrderDetailsResponse response = omService.viewOrders(userName, pageNumber, size);
		log.info("Getting the list of orders from the service: {}", response);
		return new ResponseEntity<OrderDetailsResponse>(response, HttpStatus.OK);
	}

}
