package com.codegym;

import com.codegym.formatter.RoleFormatter;
import com.codegym.model.MyFile;
import com.codegym.service.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableConfigurationProperties({
		MyFile.class
})
public class CaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseStudyApplication.class, args);
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
