/**
 * 
 */
package com.order.management.service.modeler.impl;

import org.springframework.stereotype.Component;

import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.modeler.OrderManagementModerler;

/**
 * A modeler class which will be used to model the request data and send to 
 * the service layer.
 *
 */
@Component
public class OrderManagementModelerImpl implements OrderManagementModerler{

	/**
	 * This method will be used to model the request data and send back
	 * the modeled data to the caller.
	 */
	@Override
	public OrderDetails modelRequestData(OrderRequest request) {
		OrderDetails order = new OrderDetails();
		order.setItemIds(request.getItemIds());
		order.setUserName(request.getUserName());
		order.setRestaurantName(request.getRestaurantName());
		return order;
	}

	/**
	 * This method will be used to model the request data for the update and send back
	 * the modeled data to the caller.
	 */
	@Override
	public OrderDetails modelupdateRequestData(UpdateOrderRequest request) {
		OrderDetails order = new OrderDetails();
		order.setOrderDetailsId(request.getOrderDetailsId());
		order.setItemIds(request.getItemIds());
		order.setUserName(request.getUserName());
		order.setRestaurantName(request.getRestaurantName());
		return order;
	}

}
