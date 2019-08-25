/**
 * 
 */
package com.order.management.service.modeler;

import com.order.management.service.model.OrderDetails;
import com.order.management.service.model.request.OrderRequest;
import com.order.management.service.model.request.UpdateOrderRequest;

/**
 * A modeler interface to be used by all modeler class for data modelling.
 *
 */
public interface OrderManagementModerler {

	OrderDetails modelRequestData(OrderRequest request);

	OrderDetails modelupdateRequestData(UpdateOrderRequest request);

}
