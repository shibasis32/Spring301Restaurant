/**
 * 
 */
package com.order.management.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.order.management.service.handler.OrderManagementHandler;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;

import io.swagger.annotations.Api;


/**
 * OrderManagementController is controller class for order management service
 * which will receive the request and pass the same to the handler class.
 *
 */
@Api(value="Api information about the order Service", tags = {"Order Service"})
@Controller
@RequestMapping(value = "/order")
public class OrderManagementController {

	/**
	 * OrderManagementHandler instance injected which is responsible for organinizing the 
	 * requests.
	 */
	@Autowired
	private OrderManagementHandler omHandler;
	
	/**
	 * URL mapping for the placeOrder.
	 * @param request - the request from the caller.
	 * @return OrderResponse
	 */
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
		return omHandler.placeOrder(request);
	}
	
	/**
	 * URL mapping for the updateOrder.
	 * @param request - the request from the caller.
	 * @return OrderResponse
	 */
	@RequestMapping(value = "/updateOrder", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> updateOrder(@RequestBody UpdateOrderRequest request) {
		return omHandler.updateOrder(request);
	}
	
	/**
	 * URL mapping for the cancelOrder.
	 * @param id - the order id from the request
	 * @return OrderResponse
	 */
	@RequestMapping(value = "/cancelOrder/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> cancelOrder(@PathVariable("id") long id) {
		return omHandler.cancelOrder(id);
	}
	
	/**
	 * URL mapping for the viewOrders.
	 * @param id - the order id from the request
	 * @param userName - the name of the user
	 * @param startIndex - the starting index for pagination
	 * @param endIndex - the number of elements to be displayed in one page
	 * @return OrderResponse
	 */
	@RequestMapping(value = "/viewOrder/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetailsResponse> viewOrders(@PathVariable(name = "username", required = true) String userName, @RequestParam(name = "pagenum", defaultValue = "0") int pageNumber, @RequestParam(name = "size", defaultValue = "0") int size) {
		return omHandler.viewOrders(userName, pageNumber, size);
	}
}
