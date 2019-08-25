/**
 * 
 */
package com.order.management.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.order.management.service.dao.OrderManagementServiceRespository;
import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderDetailsResponse;
import com.order.management.service.model.response.OrderResponse;
import com.order.management.service.modeler.OrderManagementModerler;
import com.order.management.service.service.OrderManagementService;

/**
 * The service class will be used to perform all Business related operations.
 *
 */
@Service
@Transactional
public class OrderManagementServiceImpl implements OrderManagementService {

	/**
	 * OrderManagementServiceRespository instance injected which is responsible for
	 * all db related operations.
	 */
	@Autowired
	private OrderManagementServiceRespository omsRepository;

	/**
	 * OrderManagementModerler instance injected which is responsible for modelling
	 * the requests for the service class.
	 */
	@Autowired
	private OrderManagementModerler omModeler;

	/**
	 * This method will place the order requested by user and save it to the DB.
	 */
	@Override
	public OrderResponse placeOrder(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		OrderDetails order = omModeler.modelRequestData(request);
		order.setPlacedOrderDate(new Date());
		order.setOrderStatus("Active");
		double price = 1;
		for (int i = 0; i < order.getItemIds().size(); i++) {
			price = price + (double) i;
		}
		order.setTotalPrice(price);
		try {
			order = omsRepository.save(order);
		} catch (Exception e) {
			response.setMessage("Error placing the order");
			throw new RuntimeException("Error placing the order", e);
		}
		response.setMessage("The order was placed successfully!!! Enjoy maadi");
		return response;
	}

	/**
	 * This method will place the order requested by user and save it to the DB.
	 */
	@Override
	public OrderResponse updateOrder(UpdateOrderRequest request) {
		OrderResponse response = new OrderResponse();
		OrderDetails order = omModeler.modelupdateRequestData(request);
		Optional<OrderDetails> getOrder = omsRepository.findByOrderDetailsId(order.getOrderDetailsId());
		if (!getOrder.isPresent()) {
			response.setMessage("No order found for the order ID " + order.getOrderDetailsId());
		} else {
			double price = 1;
			for (int i = 0; i < order.getItemIds().size(); i++) {
				price = price + (double) i;
			}
			order.setTotalPrice(price);
			order.setPlacedOrderDate(new Date());
			order.setOrderStatus("Active");
			try {
				order = omsRepository.save(order);
			} catch (Exception e) {
				response.setMessage("Error updating the order");
				throw new RuntimeException("Error updating the order", e);
			}
			response.setMessage("The order was updated successfully!!! Enjoy maadi");
		}
		return response;
	}

	/**
	 * This method will delete the order id requested by user and update it to the
	 * DB.
	 */
	@Override
	public OrderResponse cancelOrder(long id) {
		OrderResponse response = new OrderResponse();
		Optional<OrderDetails> getOrder = omsRepository.findByOrderDetailsId(id);
		if (!getOrder.isPresent()) {
			response.setMessage("No order found for the order ID " + id);
		} else {
			OrderDetails canceledOrder = getOrder.get();
			canceledOrder.setOrderStatus("CANCELED");
			try {
				omsRepository.save(canceledOrder);
			} catch (Exception e) {
				response.setMessage("Error cancelling the order");
				throw new RuntimeException("Error cancelling the order", e);
			}
			response.setMessage("The order was deleted successfully.");
		}
		return response;
	}

	/**
	 * This method will get the orders list for a specific user.
	 */
	@Override
	public OrderDetailsResponse viewOrders(String userName, Pageable pageable) {
		OrderDetailsResponse response = new OrderDetailsResponse();
		List<OrderDetails> getOrder = new ArrayList<>();
		try {
			getOrder = omsRepository.findByUserName(userName, pageable);
		} catch(Exception e) {
			throw new RuntimeException("Unknown Exception Occured", e);
		}
		if (getOrder.isEmpty()) {
			throw new OrderNotFound("No order placed for "+userName);
		}
		List<OrderDetails> orders = getOrder.stream().filter(p -> !p.getOrderStatus().equalsIgnoreCase("CANCELED"))
				.collect(Collectors.toList());
		response.setOrderList(orders);
		return response;
	}

}
