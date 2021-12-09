package com.practice.CustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public  class CustomerService {
	
	private CustomerRepository customerrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void  add( Customer customer)
	{
		 customerrepository.save(customer);
	}
	
	
	
   public List<Customer> getcustomers()
   {
    List<Customer>customer=customerrepository.findAll();
  return customer;
 }
    
	
   // public List<Customer> getcustomers()
	//{
	//	Customer[] customers= restTemplate.getForObject("http://localhost:8001/reservation/findAboutTheReservation",Customer[].class);
	//	return Arrays.asList(customers);
	//}
    
  public Optional<Customer>getCustomer(String id)
  {
	  return customerrepository.findById(id);
	  
  }
  public void deleteCustomer(Customer customer)
  {
	  customerrepository.delete(customer);
	  
  }
  }