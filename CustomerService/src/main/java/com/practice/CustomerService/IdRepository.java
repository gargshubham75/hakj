package com.practice.CustomerService;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.CustomerService.IdGenerator;

	@Repository
	public interface IdRepository extends MongoRepository<IdGenerator, String>{

	}

