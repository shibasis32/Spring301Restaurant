/**
 * 
 */
package com.restaurant.search.service.bean.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.config.SwaggerConfig;

import springfox.documentation.spring.web.plugins.Docket;

/**
* Test class for SwaggerConfig.
* This class will contain the junit test cases for the bean configuration methods.
*
*/
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SwaggerConfigTest {

	/**
	 * Injected mocks for performing testing
	 */
	@InjectMocks
	private SwaggerConfig swaggerConfig;
	
	/**
	 * setup method for SwaggerConfig test.
	 */
	@Before
	public void setup() {
	}
	
	/**
	 * Junit test case for modelMapper.
	 */
	@Test
	public void testModelMapper() {
		ModelMapper mm = swaggerConfig.modelMapper();
		assertNotNull(mm);
	}
	
	/**
	 * Junit test case for Docket Api.
	 */
	@Test
	public void testDocket() {
		Docket mm = swaggerConfig.api();
		assertNotNull(mm);
	}
}
