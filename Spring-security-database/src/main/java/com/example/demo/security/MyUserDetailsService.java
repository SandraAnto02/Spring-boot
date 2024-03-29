package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.userRepository;


@Component
public class MyUserDetailsService implements UserDetailsService 
{
	@Autowired
	userRepository userRepo;
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
			User user = userRepo.findByUsername(username);	
			if(user==null)
				throw new UsernameNotFoundException("User not found");
			
			return new MyUserDetails(user);
	}
}


//UserDetails is interface 
//UserDetailsService is interface