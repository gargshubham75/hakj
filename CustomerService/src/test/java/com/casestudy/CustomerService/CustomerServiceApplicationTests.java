package com.casestudy.CustomerService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.CustomerService.Customer;
import com.practice.CustomerService.CustomerRepository;
import com.practice.CustomerService.CustomerService;

import antlr.collections.List;

@RunWith(SpringRunner.class)
@SpringBootApplication
class CustomerServiceApplicationTests {

	@Autowired
	private CustomerService service;
	@MockBean
	private CustomerRepository repo;
	@Test
	public void getcustomersTest() {
		when(repo.findAll()).thenReturn((java.util.List<Customer>) Stream
				.of(new Customer(5,"shubham","gargshubham75@gmail.com",6767,"male","agra"), new Customer(12,"garg","garg@gmail.com",6565,"male","mathura")));
		assertEquals(2, service.getcustomers().size());
	}
	
}
