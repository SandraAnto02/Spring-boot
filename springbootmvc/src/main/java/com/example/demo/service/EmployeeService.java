package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
@Service
public class EmployeeService 
{
	public static List<Employee> empArr= new ArrayList<>();
	public void add(Employee emp)
	{
		empArr.add(emp);
		System.out.println(emp);
	}
	
	public List<Employee> getAllEmployee()
	{
		return empArr;
	}

}
