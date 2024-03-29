package com.example.demo.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;

public class MyUserDetails implements UserDetails 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private User user;
	
	public MyUserDetails(User user)
	{
		super();
		this.user = user;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
	}

	@Override
	public String getPassword() 
	{
		return user.getPswd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		// TODO Auto-generated method stub
		return true;
	}

}
