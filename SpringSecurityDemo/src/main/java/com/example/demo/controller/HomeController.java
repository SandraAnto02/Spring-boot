package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@RequestMapping("/public")
	@ResponseBody
	public String publicUser()
	{
		return "I am public user";
		
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/admin")
	@ResponseBody
	public String adminUser()
	{
		return "I am admin user";
		
	}
	
	@PreAuthorize("hasRole('CUSTOMER')")
	@RequestMapping("/customer")
	@ResponseBody
	public String CustomerUser()
	{
		return "I am customer user";
		
	}



}
