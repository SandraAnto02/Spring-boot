package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Name 
{
	@Id
	private int id;
	private String name;
	private String hobby;
	public int getId() {
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getHobby() 
	{
		return hobby;
	}
	public void setHobby(String hobby) 
	{
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Name [id=" + id + ", name=" + name + ", hobby=" + hobby + "]";
	}
	
	
	
	
}
