package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
	private int uid;
	private String username;
	private String pswd;
	private String role;
	
	public int getUid() 
	{
		return uid;
	}
	public void setUid(int uid) 
	{
		this.uid = uid;
	}
	
	
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	
	public String getPswd() 
	{
		return pswd;
	}
	public void setPswd(String pswd) 
	{
		this.pswd = pswd;
	}
	
	
	
	public String getRole() 
	{
		return role;
	}
	public void setRole(String role) 
	{
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", pswd=" + pswd + "]";
	}
	
	

}
