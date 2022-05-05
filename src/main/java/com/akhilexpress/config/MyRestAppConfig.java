package com.akhilexpress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc //activate validation,mapper etc .it helps us to set up necessary n=beans used for web application
@Configuration
@ComponentScan("com")
public class MyRestAppConfig {
	
	/*@Bean
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
	}*/
	
	
	@Bean
	public RestTemplate getrestTemplate()
	{
	//	ClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
		SimpleClientHttpRequestFactory requestFactory=new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(200);
		requestFactory.setReadTimeout(100);
		
		RestTemplate restTemplate=new RestTemplate(requestFactory);
		//restTemplate.setErrorHandler(new AppExceptionHandler());
		
		return restTemplate;
	}
	
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}

}
