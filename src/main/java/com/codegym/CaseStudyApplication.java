package com.codegym;

import com.codegym.formatter.RoleFormatter;
import com.codegym.property.FileStorageProperties;
import com.codegym.service.*;
import com.codegym.service.impl.*;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})

public class CaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseStudyApplication.class, args);
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public RoleService roleService() {
        return new RoleServiceImpl();
    }

    @Bean
    public ProductsService productsService() {
        return new ProductsServiceImpl();
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
            registry.addFormatter(new RoleFormatter(appContext.getBean(RoleService.class)));
        }
    }
}
