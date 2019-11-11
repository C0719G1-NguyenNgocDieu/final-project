package com.codegym;

import com.codegym.service.*;
import com.codegym.service.impl.RoleServiceImpl;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;


@SpringBootApplication
public class CaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseStudyApplication.class, args);
	}


	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsServiceImpl();
	}

	@Bean
	public UserService userService(){
		return new UserServiceImpl();
	}

	@Bean
	public RoleService roleService(){
		return new RoleServiceImpl();
	}



}
