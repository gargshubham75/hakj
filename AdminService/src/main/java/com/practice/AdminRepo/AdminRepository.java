package com.practice.AdminRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin,String> {
	Admin findByUsername(String username);
}
