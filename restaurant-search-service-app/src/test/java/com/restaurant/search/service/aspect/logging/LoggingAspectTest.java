/**
 * 
 *//*
package com.restaurant.search.service.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.search.service.loggingaspect.LoggingAspect;

*//**
 * Test class for LoggingAspectTest. This class will contain the junit test
 * cases for the logger methods.
 *
 *//*
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LoggingAspectTest {

	@Mock
	private ProceedingJoinPoint proceedingJoinPoint;
	@Mock
	private JoinPoint joinPoint;
	@InjectMocks
	private LoggingAspect loggingAspect;

	@Test
	public void testPositiveSmallNumber() throws Throwable {
		loggingAspect.logAfterThrowing(joinPoint, new Throwable());
	}

}
*/