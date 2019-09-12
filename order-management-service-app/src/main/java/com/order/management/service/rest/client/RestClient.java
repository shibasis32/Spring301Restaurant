/**
 * 
 */
package com.order.management.service.rest.client;

import java.net.URI;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.order.management.service.model.rest.response.ItemWrapperResponse;

/**
 * This is a Rest client class which be used to call other RestFul Web services
 * endpoints.
 *
 */
@Component
public class RestClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	static final String URL_RESTAURANT = "http://localhost:8080/search/";
	
	/**
	 * Injecting the dependency of RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * This method will call the rest service with a designated endpoint.
	 * 
	 * @param list
	 */
	public ItemWrapperResponse callExternalService(String endpoint, List<Long> list) {
		ItemWrapperResponse itemWrapperResponse = new ItemWrapperResponse();
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			String endpointURL = URL_RESTAURANT + endpoint;
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(endpointURL);
			builder.queryParam("itemids", StringUtils.join(list, ","));
			URI uri = builder.build().encode().toUri();
			log.info("Calling external service endpoint with data: {}", uri.toString());
			ResponseEntity<ItemWrapperResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
					ItemWrapperResponse.class);
			log.info("Got the reponse: {}", response);
			itemWrapperResponse = response.getBody();
		} catch (HttpClientErrorException e) {
			RuntimeException re = new RuntimeException("Encountered connection error", e);
			log.error("HttpClientErrorException: {}", re.getMessage());
			throw re;
		} catch (RuntimeException e) {
			RuntimeException re = new RuntimeException("Encountered unknown error", e);
			log.error("RuntimeException: {}", re.getMessage());
			throw re;
		}

		return itemWrapperResponse;
	}
}
