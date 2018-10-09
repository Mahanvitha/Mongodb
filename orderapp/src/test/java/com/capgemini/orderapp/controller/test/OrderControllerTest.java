package com.capgemini.orderapp.controller.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.orderapp.controller.OrderController;
import com.capgemini.orderapp.service.OrderService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderControllerTest {
private MockMvc mockMvc;

	@Mock
	private OrderService orderService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}
	@Test
	public void testAddOrder() throws Exception {
		String content ="{	\"orderId\" : 111,\r\n" + 
				"	\"customerId\" :111,\r\n" + 
				"\r\n" + 
				"	\"products\" : \"mobile\",\r\n" + 
				"	\"orderDate\" : 01,01,2001\r\n" + 
				"	\r\n" + 
				"	}"
	}

}
