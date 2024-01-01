package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Products;
import com.example.demo.repo.productRepo;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class productController 
{
	
	@Autowired
	private Products product;
	
	@Autowired
	private productRepo repo;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/")
	public String entrypage()
	{
		return "menu.jsp";
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseBody
	@PostMapping("/add")
	public String addProduct(@RequestBody Products products)
	{
		repo.save(products);
		return  "Added to mySql";
	}
	
	
//	@RequestMapping("/search")
//	@ResponseBody
//	public String search(String pdesc)
//	{
//		return repo.findBy(pdesc).toString();
//	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/view")
	@ResponseBody
	public List<Products> viewProduct()
	{
		return repo.findAll();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{pid}")
	@ResponseBody
	public String deleteProductById(@PathVariable("pid") String pid) 
	{

	    repo.deleteById(pid);
	    return "deleted";
	}
	
}
