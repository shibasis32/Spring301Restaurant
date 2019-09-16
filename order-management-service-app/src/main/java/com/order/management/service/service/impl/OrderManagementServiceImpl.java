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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.order.management.service.dao.OrderManagementServiceRespository;
import com.order.management.service.exception.OrderNotFound;
import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;
import com.order.management.service.model.response.OrderResponse;
import com.order.management.service.model.rest.response.ItemWrapperResponse;
import com.order.management.service.modeler.OrderManagementModerler;
import com.order.management.service.rest.client.RestClient;
import com.order.management.service.service.OrderManagementService;

/**
 * The service class will be used to perform all Business related operations.
 *
 */
@Service
@Transactional
public class OrderManagementServiceImpl implements OrderManagementService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
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
	 * RestClient instance injected which is responsible for rest service designated
	 * endpoints.
	 */
	@Autowired
	private RestClient restClient;
	
	private List<OrderDetails> ordersList  = new ArrayList<>();;

	/**
	 * This method will place the order requested by user and save it to the DB.
	 */
	@Override
	@CachePut(value = "orderDetails", key = "#request.userName")
	public OrderResponse placeOrder(OrderRequest request) {
		OrderResponse response = new OrderResponse();
		log.info("Modelling the request object to entity object");
		OrderDetails order = omModeler.modelRequestData(request);
		order.setPlacedOrderDate(new Date());
		order.setOrderStatus("Active");
		try {
			log.info("Calling the Rest Client class to get the itemsPrice");
			ItemWrapperResponse itemResponse = restClient.callExternalService("/getItemsPrice", order.getItemIds());
			Double priceList = itemResponse.getItemPrices().stream()
					.collect(Collectors.summingDouble(Double::doubleValue)); 
			order.setTotalPrice(priceList);
			log.info("Saving the order into the DB");
			order = omsRepository.save(order);
			omsRepository.flush();
			ordersList.add(order);
		} catch (Exception e) {
			RuntimeException re = new RuntimeException("Error placing the order", e);
			log.error(re.getMessage());
			throw re;
		}
		log.info("The order was placed successfully with the order number: {}", order.getOrderDetailsId());
		response.setMessage("The order was placed successfully!!! Enjoy maadi");
		response.setOrderList(ordersList);
		return response;
	}

	/**
	 * This method will place the order requested by user and save it to the DB.
	 */
	@Override
	@CachePut(value = "orderDetails", key = "#request.userName")
	public OrderResponse updateOrder(UpdateOrderRequest request) {
		OrderResponse response = new OrderResponse();
		log.info("Modelling the request object to entity object");
		OrderDetails order = omModeler.modelupdateRequestData(request);
		log.info("Checking if the order id is present in the database");
		Optional<OrderDetails> getOrder = omsRepository.findByUserNameAndOrderDetailsId(request.getUserName(), order.getOrderDetailsId());
		if (!getOrder.isPresent()) {
			log.info("No order found for the order ID: {}", order.getOrderDetailsId());
			response.setMessage("No order found for the order ID " + order.getOrderDetailsId());
		} else {
			try {
			log.info("Calling the Rest Client class to get the itemsPrice");
			ItemWrapperResponse itemResponse = restClient.callExternalService("/getItemsPrice", order.getItemIds());
			Double priceList = itemResponse.getItemPrices().stream()
					.collect(Collectors.summingDouble(Double::doubleValue)); 
			order.setTotalPrice(priceList);
			order.setPlacedOrderDate(new Date());
			order.setOrderStatus("Active");
			ordersList.add(order);
			log.info("Updating the order into the DB for the order ID: {}", order.getOrderDetailsId());
				order = omsRepository.save(order);
			} catch (Exception e) {
				RuntimeException re = new RuntimeException("Error updating the order", e);
				log.error(re.getMessage());
				throw re;
			}
			log.info("The order was updated successfully for the order number: {}", order.getOrderDetailsId());
			response.setMessage("The order was updated successfully!!! Enjoy maadi");
			response.setOrderList(ordersList);
		}
		return response;
	}

	/**
	 * This method will delete the order id requested by user and update it to the
	 * DB.
	 */
	@Override
	@CacheEvict(value = "orderDetails", key = "#userName, #id")
	public OrderResponse cancelOrder(String userName, long id) {
		OrderResponse response = new OrderResponse();
		Optional<OrderDetails> getOrder = omsRepository.findByUserNameAndOrderDetailsId(userName, id);
		if (!getOrder.isPresent()) {
			log.info("No order found for the order ID: {}", id);
			response.setMessage("No order found for the order ID " + id);
		} else {
			OrderDetails canceledOrder = getOrder.get();
			canceledOrder.setOrderStatus("CANCELED");
			try {
				log.info("saving the cancelled order in the db");
				omsRepository.save(canceledOrder);
			} catch (Exception e) {
				RuntimeException re = new RuntimeException("Error cancelling the order", e);
				log.error(re.getMessage());
				throw re;
			}
			log.info("The order was cancelled successfully.");
			response.setMessage("The order was deleted successfully.");
		}
		return response;
	}

	/**
	 * This method will get the orders list for a specific user.
	 */
	@Override
	@Cacheable(value = "orders", key = "#userName")
	public OrderResponse viewOrders(String userName, int pageNumber, int pageSize) {
		OrderResponse response = new OrderResponse();
		List<OrderDetails> getOrder = new ArrayList<>();
		try {
			log.info("Calling the db to get list of orders for the user");
			if(pageSize != 0) {
				Pageable pageablePage = PageRequest.of(pageNumber, pageSize);
				getOrder = omsRepository.findByUserName(userName, pageablePage);
			} else {
				getOrder = omsRepository.findByUserName(userName);
			}
		} catch (Exception e) {
			RuntimeException re = new RuntimeException("Unknown Exception Occured", e);
			log.error(re.getMessage());
			throw re;
		}
		if (getOrder.isEmpty()) {
			OrderNotFound onf = new OrderNotFound("No order placed for " + userName);
			log.error(onf.getMessage());
			throw onf;
		}
		log.info("Got the order details ");
		List<OrderDetails> orders = getOrder.stream().filter(p -> !p.getOrderStatus().equalsIgnoreCase("CANCELED"))
				.collect(Collectors.toList());
		response.setOrderList(orders);
		response.setMessage("Please view the order details");
		return response;
	}

}
