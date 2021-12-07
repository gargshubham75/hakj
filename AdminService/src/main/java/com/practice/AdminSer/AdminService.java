package com.practice.AdminSer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Admin;
import com.practice.AdminRepo.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminrepo;
	
	
	public Admin addAdmin(Admin admin) {
		return adminrepo.save(admin);
		
    }
	
	public List<Admin> getAdmin(){
		List<Admin> admin=adminrepo.findAll();
		return admin;
		
		
	}

}



