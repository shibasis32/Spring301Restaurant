/**
 * 
 */
package com.order.management.service.rest.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.order.management.service.model.rest.response.ItemWrapperResponse;

/**
 * Test class for RestClientTest. This class will contain the junit test cases
 * for the rest client methods.
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestClientTest {

	/**
	 * Injected mock for the Rest client class.
	 */
	@InjectMocks
	private RestClient testRestClient;

	/**
	 * Injected mock for the restTemplate.
	 */
	@Mock
	private RestTemplate restTemplate;

	/**
	 * itemIds.
	 */
	private List<Long> itemIds;

	/**
	 * setup method for RestClientTest.
	 */
	@Before
	public void setup() {
		itemIds = new ArrayList<>();
		itemIds.add(new Long(1));
		itemIds.add(new Long(2));
	}

	/**
	 * JUNIT test method for CallExternalService.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testCallExternalService(){
		String endpoint = "/getItemPrices";
		ResponseEntity<ItemWrapperResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(restTemplate.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class),
				Mockito.any(Class.class))).thenReturn(responseEntity);
		testRestClient.callExternalService(endpoint, itemIds);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	/**
	 * JUNIT test method for CallExternalServiceHttpClient.
	 */
	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
	public void testCallExternalServiceHttpClientException(){
		String endpoint = "/getItemPrices";
		ResponseEntity<ItemWrapperResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(restTemplate.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class),
				Mockito.any(Class.class))).thenThrow(new HttpClientErrorException(HttpStatus.OK));
		testRestClient.callExternalService(endpoint, itemIds);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
	
	/**
	 * JUNIT test method for CallExternalServiceException.
	 */
	@SuppressWarnings("unchecked")
	@Test(expected = RuntimeException.class)
	public void testCallExternalServiceException(){
		String endpoint = "/getItemPrices";
		ResponseEntity<ItemWrapperResponse> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		when(restTemplate.exchange(Mockito.any(URI.class), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class),
				Mockito.any(Class.class))).thenThrow(new RuntimeException());
		testRestClient.callExternalService(endpoint, itemIds);
		assertEquals(200, responseEntity.getStatusCodeValue());
	}
}
