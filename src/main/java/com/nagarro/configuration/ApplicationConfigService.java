package com.nagarro.configuration;
/*
 * @Author Bhumika_Arora
 */
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;

import com.nagarro.services.EmployeeManagementServices;
import com.nagarro.services.SignService;

@Configuration
public class ApplicationConfigService {
	
	@Bean
	public SignService getSignService() {
		return new SignService();
	}
	
	@Bean
	public EmployeeManagementServices getEmpService() {
		return new EmployeeManagementServices();
		
	}
}
