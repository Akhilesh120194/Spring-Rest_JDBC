package com.akhilexpress.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc //activate validation,mapper etc .it helps us to set up necessary n=beans used for web application
@Configuration
@ComponentScan("com")
public class MyRestAppConfig {
	
	@Bean
	public DataSource getDataSource()
	{
		 DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/employees?useSSL=false","hbstudent","hbstudent");
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 return driverManagerDataSource;
		
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate()
	{
		return new JdbcTemplate(getDataSource());
	}

}
