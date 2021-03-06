package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TestCalculator {

	@InjectMocks
	Calculator cal;

	@Mock
	CalculatorService service;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("**** setUpBeforeClass ******");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("**** tearDownAfterClass ******");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("**** setUp ******");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("**** tearDown ******");
	}

	@Nested
	@DisplayName("Class for testing Compute Functionality")
	class TestCompute {

		@Test
		public void testComputePositive() {
			when(service.addition(5, 3)).thenReturn(8);
			assertEquals(32, cal.compute(5, 3));
			verify(service).addition(5, 3);
		}

		@Test
		public void testComputeNegative() {
			when(service.addition(-5, 3)).thenReturn(-2);
			assertEquals(-8, cal.compute(-5, 3));
			verify(service).addition(-5, 3);
		}
	}

	@RepeatedTest(3)
	public void testCompute(RepetitionInfo repitionInfo) {
		if (repitionInfo.getCurrentRepetition() == 1) {
			when(service.addition(5, 3)).thenReturn(8);
			assertEquals(32, cal.compute(5, 3));
		}

		if (repitionInfo.getCurrentRepetition() == 2) {
			when(service.addition(6, 4)).thenReturn(10);
			assertEquals(40, cal.compute(6, 4));
		}
	}

	@Test
	void groupedAssertions() {
		assertAll("Multiplication", () -> assertEquals(15, 3 * 5, "3 x 5 = 15"),
				() -> assertEquals(15, 5 * 3, "5 x 3 = 15"));
	}
	
	 @Test
	    void testOnProd() 
	    {
	        System.setProperty("ENV", "PROD");
	        Assumptions.assumeFalse("DEV".equals(System.getProperty("ENV")));
	        assumingThat("sss".equals(System.getProperty("ENV")),
	                () -> {
	                    // run this only if assumingThat condition is true
	                    assertEquals(2, 1 + 1);
	                    System.out.println("in assuming block");
	                });
	       // Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")),() -> "Aborting test: not DEV");
         
	    }
	 
	 
	 @Test
	    void testAssumingThat() {

		 System.setProperty("ENV", "PROD");
		 
	        // run these assertions always, just like normal test
	        assertEquals(2, 1 + 1);

	        assumingThat("PROD".equals(System.getProperty("ENV")),
	                () -> {
	                    // run this only if assumingThat condition is true
	                    assertEquals(2, 1 + 1);
	                });

	        // run these assertions always, just like normal test
	        assertEquals(2, 1 + 1);

	    }

	@Test
	public void testCompe123() {

		when(service.addition(5, 3)).thenReturn(8);
		assertEquals(32, cal.compute(5, 3), () -> "assertions failed");

		verify(service).addition(5, 3);
	}
	
	@Mock
	List<String> mockedList;
	
	@Test
	public void whenUseMockAnnotation_thenMockIsInjected() {
		
	    mockedList.add("one");
	    Mockito.verify(mockedList).add("one");
	    assertEquals(0, mockedList.size());
	 
	    Mockito.when(mockedList.size()).thenReturn(150);
	    assertEquals(150, mockedList.size());
	}

}
