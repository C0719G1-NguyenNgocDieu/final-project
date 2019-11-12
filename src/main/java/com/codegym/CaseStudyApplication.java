package com.codegym;

import com.codegym.formatter.RoleFormatter;
import com.codegym.service.*;
import com.codegym.service.impl.RoleServiceImpl;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
	@Configuration
	class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

		private ApplicationContext appContext;

		@Override
		public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			appContext = applicationContext;
		}

		@Override
		public void addFormatters(FormatterRegistry registry) {
			RoleService locationService = appContext.getBean(RoleService.class);
			Formatter locationFormatter = new RoleFormatter(locationService);
			registry.addFormatter(locationFormatter);
		}
	}

}
