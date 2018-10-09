package com.capgemini.customerapp.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.customerapp.entity.Customer;
import com.capgemini.customerapp.repository.CustomerAppRepository;
import com.capgemini.customerapp.serviceimpl.CustomerAppServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@InjectMocks
	CustomerAppServiceImpl customerAppServiceImpl;
	
	@Mock
	CustomerAppRepository customerAppRepository;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerAppServiceImpl).build();
	}
	
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer(111,"Tom","t1","tom@gmail.com","aaa");
		when(customerAppRepository.save(customer)).thenReturn(customer);
		Customer addCustomer = customerAppServiceImpl.addCustomer(customer);
		assertEquals(111,addCustomer.getCustomerId());
	}
//	@Test
//	public void updateCustomerTest() {
//
//		Customer customer = new Customer(111, "Tom", "t1","tom@gmail.com","abc");
//		when(customerAppRepository.save(customer)).thenReturn(customer);
//		Customer updateProduct = customerAppServiceImpl.updateProfile(customer);
//		assertEquals(111, updateProduct.getCustomerId());
//		assertEquals("Tom", updateProduct.getCustomerName());
//		assertEquals("t1", updateProduct.getCustomerPassword());
//		assertEquals("tom@gmail.com", updateProduct.getCustomerEmail());
//		assertEquals("abc", updateProduct.getCustomerAddress());
//
//	}
//	@Test
//	public void deleteCustomerTest() {
//		
//		Customer customer = new Customer(111, "Tom", "t1","tom@gmail.com","abc");
//		customerAppServiceImpl.deleteCustomer(customer);
//		verify(customerAppRepository, times(1)).delete(customer);
//	}
//	
}
