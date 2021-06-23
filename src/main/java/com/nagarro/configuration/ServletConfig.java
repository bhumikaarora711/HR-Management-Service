package com.nagarro.configuration;
/*
 * @Author Bhumika_Arora
 */
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.nagarro.controller")
public class ServletConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
