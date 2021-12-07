package com.practice.AdminSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.Admin;
import com.practice.AdminRepo.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	AdminRepository adminrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminrepo.findByUsername(username);
		if(admin==null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(admin);
	}

}
