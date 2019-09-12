/**
 * 
 */
package com.restaurant.search.service.model.response;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * This class will be used to send the response back to the caller.
 *
 */
@ApiModel(description = "This model will contain the response values to be sent to the caller.")
public class ItemWrapperResponse {

	List<Double> itemPrices;

	/**
	 * @return the itemPrices
	 */
	public List<Double> getItemPrices() {
		return itemPrices;
	}

	/**
	 * @param itemPrices the itemPrices to set
	 */
	public void setItemPrices(List<Double> itemPrices) {
		this.itemPrices = itemPrices;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemWrapperResponse [itemPrices=");
		builder.append(itemPrices);
		builder.append("]");
		return builder.toString();
	}

}
