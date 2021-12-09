	package com.practice.CustomerService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{
    List<Customer> findByAddress(String address);
	
}
