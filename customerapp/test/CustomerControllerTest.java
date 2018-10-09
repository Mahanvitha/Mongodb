package com.capgemini.customerapp.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customerapp.controller.CustomerAppController;
import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.service.CustomerAppService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
	private MockMvc mockMvc;

	@Mock
	private CustomerAppService customerAppService;
	@InjectMocks
	private CustomerAppController customerAppController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerAppController).build();
	}

	@Test
	public void testAddCustomer() throws Exception {
		when(customerAppService.addCustomer(Mockito.isA(Customer.class)))
				.thenReturn(new Customer(111, "Tom", "t1", "tom@gmail.com", "abc"));
		String content = "{\"customerId\" : 111,\r\n" + " \"customerName\" : \"Tom\",\r\n"
				+ " \"customerPassword\" : \"t1\",\r\n" + " \"customerEmail\" : \"tom@gmail.com\",\r\n"
				+ " \"customerAddress\" : \"abc\"}";

		mockMvc.perform(post("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.customerId").exists()).andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customerPassword").exists()).andExpect(jsonPath("$.customerEmail").exists())
				.andExpect(jsonPath("$.customerAddress").exists()).andExpect(jsonPath("$.customerId").value("111"))
				.andExpect(jsonPath("$.customerName").value("Tom"))
				.andExpect(jsonPath("$.customerAddress").value("abc"))
				.andExpect(jsonPath("$.customerPassword").value("t1"))
				.andExpect(jsonPath("$.customerEmail").value("tom@gmail.com")).andDo(print());

	}
	
}
//	@Test
//	public void testUpdateProfile() throws Exception {
//		when(customerAppService.updateProfile(Mockito.isA(Customer.class))).thenReturn(new Customer(111,"Tom","t1","tom@gmail.com","aaa"));
//		String content = "{\"customerId\" : 111,\r\n" + 
//				" \"customerName\" : \"Tom\",\r\n" + 
//				" \"customerPassword\" : \"t1\",\r\n" + 
//				" \"customerEmail\" : \"tom@gmail.com\",\r\n" + 
//				" \"customerAddress\" : \"aaa\"}";
//		mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
//				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.customerId").exists()).andExpect(jsonPath("$.customerName").exists())
//				.andExpect(jsonPath("$.customerPassword").exists()).andExpect(jsonPath("$.customerEmail").exists())
//				.andExpect(jsonPath("$.customerAddress").exists()).andExpect(jsonPath("$.customerId").value("111"))
//				.andExpect(jsonPath("$.customerName").value("Tom"))
//				.andExpect(jsonPath("$.customerAddress").value("aaa"))
//				.andExpect(jsonPath("$.customerPassword").value("t1"))
//				.andExpect(jsonPath("$.customerEmail").value("tom@gmail.com")).andDo(print());
//	}
//	@Test 
//	public void testAuthenticateCustomer() throws Exception
//	{
//		String content = "{\r\n" + 
//				"	\"customerId\" : 111,\r\n" + 
//				"	\"customerName\" : \"Tom\",\r\n" + 
//				"	\"customerPassword\" : \"t1\",\r\n" + 
//				"	\"customerEmail\" : \"Tom@gmail.com\",\r\n" + 
//				"	\"customerAddress\" : \"aaa\",\r\n" + 
//				"}";
//		
//	when(customerAppService.updateProfile(Mockito.isA(Customer.class)))
//	.thenReturn(new Customer(111,"Tom","t1","tom@gmail.com","aaa"));
//		mockMvc.perform(put("/customer").contentType(MediaType.APPLICATION_JSON).content(content)
//				.accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk()).andExpect(jsonPath("$.customerId").exists())
//		.andExpect(jsonPath("$.customerName").exists())
//		.andExpect(jsonPath("$.customerPassword").exists())
//		.andExpect(jsonPath("$.customerEmail").exists())
//		.andExpect(jsonPath("$.customerAddress").exists())
//		.andExpect(jsonPath("$.customerDateOfBirth").exists())
//		
//		.andExpect(jsonPath("$.customerId").value(111))
//		.andExpect(jsonPath("$.customerName").value("Tom"))
//		.andExpect(jsonPath("customerPassword").value("t1"))
//		.andExpect(jsonPath("$.customerEmail").value("tom@gmail.com"))
//		.andExpect(jsonPath("$.customerAddress").value("aaa"))
//		.andDo(print());
//	}
//	
//		@Test
//		public void testFindCustomerById() throws Exception {
//	
//			when(customerAppService.getCustomer(111)).thenReturn(new Customer(111,"Tom","t1","tom@gmail.com","aaa"));
//	
//			mockMvc.perform(MockMvcRequestBuilders.get("/customers/111").accept(MediaType.APPLICATION_JSON))
//					.andExpect(status().isOk()).andExpect(jsonPath("$.customerId").exists())
//					.andExpect(jsonPath("$.customerName").exists())
//					.andExpect(jsonPath("$.customerPassword").exists())
//					.andExpect(jsonPath("$.customerEmail").exists())
//					.andExpect(jsonPath("$.customerAddress").exists())
//					.andExpect(jsonPath("$.customerDateOfBirth").exists())
//					
//					.andExpect(jsonPath("$.customerId").value(111))
//					.andExpect(jsonPath("$.customerName").value("Tom"))
//					.andExpect(jsonPath("customerPassword").value("t1"))
//					.andExpect(jsonPath("$.customerEmail").value("tom@gmail.com"))
//					.andExpect(jsonPath("$.customerAddress").value("aaa"))
//					.andDo(print());
//		}
//		@Test
//		public void testDeleteCustomer() throws Exception {
//			when(customerAppService.getCustomer(111)).thenReturn(new Customer(111,"Tom","t1","tom@gmail.com","aaa"));
//			mockMvc.perform(delete("/customers").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//		}
//	}
//	
//
