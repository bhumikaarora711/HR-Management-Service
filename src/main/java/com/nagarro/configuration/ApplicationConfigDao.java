package com.nagarro.configuration;
/*
 * @Author Bhumika_Arora
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.dao.HRManagerDao;

@Configuration
public class ApplicationConfigDao {
	
	@Bean
	public HRManagerDao getHRManager() {
		return new HRManagerDao();
	}
}
