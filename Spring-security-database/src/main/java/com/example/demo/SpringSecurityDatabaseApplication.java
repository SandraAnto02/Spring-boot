package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.User;
import com.example.demo.repository.userRepository;

@SpringBootApplication
public class SpringSecurityDatabaseApplication 
{
	
//	@Bean
	public CommandLineRunner createUser(userRepository userRepository)
	{
		return args->{
			User user = new User();
			user.setUid(20);
			user.setUsername("Sandra");
			user.setPswd(new BCryptPasswordEncoder().encode("123"));
			user.setRole("ADMIN");
			userRepository.save(user);
		};
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringSecurityDatabaseApplication.class, args);
	}

}
