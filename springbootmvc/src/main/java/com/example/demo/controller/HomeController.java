package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class HomeController 
{
	
	
//Can be done 2 ways	
	
//	@RequestMapping("/display")
//	public ModelAndView displayPage(String uname) 
//	{
//		ModelAndView mv = new ModelAndView("display.jsp");
//		mv.addObject("uname",uname);
//		return mv;
//	}
//	
//	@RequestMapping("/display1")
//	@ResponseBody
//	public String display(String uname)
//	{
//		return "Welcome"+uname;
//	}
	
//---------------------------------------------------------------------------
	
	@Autowired
	Employee emp;
	
	@Autowired
	EmployeeService emps ;
	
	

	@RequestMapping("/")
	//@ResponseBody
	public String home()
	{
		return "index.jsp";
	}
	
	
	@RequestMapping("/add")
	public ModelAndView displayPage(Employee employee) 
	{
		ModelAndView mv = new ModelAndView("index.jsp");
		emps.add(employee);
		
		return mv;
	}
	
	@RequestMapping("/view")
	public ModelAndView viewEmployee()
	{
		ModelAndView mv = new ModelAndView("display.jsp");
//		List eList = ;
		mv.addObject("employeeList",emps.getAllEmployee());
		
		return mv;
	}
	
	
}
