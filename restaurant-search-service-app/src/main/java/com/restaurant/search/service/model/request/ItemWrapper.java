/**
 * 
 */
package com.restaurant.search.service.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class will be used to map the request data to our POJO.
 *
 */
@ApiModel(description = "This model will contain the request values of item idscoming from the caller.")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWrapper {

	private List<Long> itemIds;

	/**
	 * @return the itemIds
	 */
	@ApiModelProperty(notes = "list of items id's")
	public List<Long> getItemIds() {
		return itemIds;
	}

	/**
	 * @param itemIds the itemIds to set
	 */
	public void setItemIds(List<Long> itemIds) {
		this.itemIds = itemIds;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ItemWrapper [itemIds=");
		builder.append(itemIds);
		builder.append("]");
		return builder.toString();
	}

}
