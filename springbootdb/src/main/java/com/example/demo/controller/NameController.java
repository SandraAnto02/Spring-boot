package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Name;
import com.example.demo.repo.NameRepo;

public class NameController 
{
	@Autowired
	Name name;
	
	@Autowired
	NameRepo repo;
	
	
	@RequestMapping("/")
	//@ResponseBody
	public String home()
	{
		return "index.jsp";
		
	}
	
	public String addName(Name name)
	{
		name.setId(101);
		name.setName("ABC");
		name.setHobby("Playing");
		repo.save(name);
		return name+"Added to db";
	}

}
