package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig 
{
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	@Bean
	public UserDetailsService userCredentialService()
	{
		UserDetails adminCredentials = User.withUsername("Admin").password(passwordEncoder().encode("111")).roles("ADMIN").build();
		UserDetails customerCredentials = User.withUsername("Customer").password(passwordEncoder().encode("222")).roles("CUSTOMER").build();
		
		//since UserDetails 
		
		InMemoryUserDetailsManager myUserDetails = new InMemoryUserDetailsManager(adminCredentials,customerCredentials);   //<-constructor
		return myUserDetails;

	}
	
	
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity hs) throws Exception
	{
		hs.csrf().disable()           				//disabling other access
		.authorizeHttpRequests() 
//		.requestMatchers("/ADMIN")
//		.hasRole("ADMIN")							//client req autherizing
//		.requestMatchers("/customer")
//		.hasRole("CUSTOMER") 
//		.requestMatchers("/public")					//if public then permit login
//		.permitAll()
		.anyRequest()								//any other req then ask
		.authenticated()
		.and()
		.formLogin();
		
		return hs.build();
		
	}

}
