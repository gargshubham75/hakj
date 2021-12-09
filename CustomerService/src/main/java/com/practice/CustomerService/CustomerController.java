package com.practice.CustomerService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	IdRepository idRepo;
	
	// add the customer
	
	@PostMapping(value = "/AddThecustomer")
	public String saveCustomer(@RequestBody Customer customer)
	{
	customerrepository.save(customer);

	return "Added customer with id : " + customer.getId();
	
}
	
	
	@PostMapping("/post")
	public void addCustomer(@RequestBody Customer customer) {
		IdGenerator idGen= idRepo.findById("id").get();
		customer.setId(idGen.getSeq());
		idGen.setSeq(idGen.getSeq()+1);
		idRepo.save(idGen);
		customerrepository.save(customer);
	}
//find all the customers which have added into the database
	
	//@GetMapping("/hello")
   //public Reservation[] getreservations(){
	 //  ResponseEntity<Reservation[]> responseEntity = restTemplate.getForEntity("http://localhost:8001/reservation/findAboutTheReservation/", Reservation[].class);
	   //Reservation[] reservation = responseEntity.getBody();
	   //return reservation;
//	}
   
	@GetMapping("/allreservation")
	public List<?> getReservations(){
		return  this.restTemplate.getForObject("http://localhost:8001/reservation/findAboutTheReservation", List.class);
	}
	
	
	
   @GetMapping("/findAllTheCustomers")
   public List<Customer>getCustomers()
   {
	   return customerrepository.findAll();
	   
   }
   
   // find the specific customer through there id
   
   @GetMapping("/findCusto/{id}")
   public Optional<Customer>getCustomers(@PathVariable String id)
   {
	   return customerrepository.findById(id);
   }
   
   //delete the specific customer through there id
   
   @DeleteMapping("/delete/{id}")
   public String deletecustomer(@PathVariable String id)
   {
	   customerrepository.deleteById(id);
	   return "Customer have been Deleted with id: "+ id;
   }
   
 
}