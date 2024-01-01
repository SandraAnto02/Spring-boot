package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.userRepository;

@RestController
@RequestMapping("/app")
public class homeController 
{
	@Autowired
	userRepository repo;
	
	
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser()
	{
		User user = new User();
		user.setUid(101);
		user.setUsername("admin");
		user.setPswd(new BCryptPasswordEncoder().encode("123"));
		repo.save(user);
		return ResponseEntity.ok("Public user");
				
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser()
	{
		return ResponseEntity.ok("Admin user");
	}

}
