package com.akhilexpress.exception;

import java.io.IOException;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class AppExceptionHandler implements ResponseErrorHandler {
	
	ResponseErrorHandler errorHandler=new DefaultResponseErrorHandler();

	public boolean hasError(ClientHttpResponse response) throws IOException {
		// TODO Auto-generated method stub

		// Check if there is error in the response
	/*	System.out.println("Inside error method ");
		if(response.getStatusCode()!=HttpStatus.ACCEPTED)
		{
			System.out.println("Status text :"+response.getStatusText());
			System.out.println("Status code :"+response.getRawStatusCode());
			
			return true;
		}*/
		//this response is the same we get from the api call and it got injected by spring 
		
		System.out.println("Inside error method ");
		return errorHandler.hasError(response);
	}

	public void handleError(ClientHttpResponse response) throws IOException {
		
		System.out.println("Inside handle error method ");
		System.out.println(response.getStatusCode());
		Properties properties=new Properties();
		properties.put("body", response.getBody().toString());
		properties.put("status code", response.getStatusCode());
		properties.put("headers",response.getHeaders());
		
		CustomException exception=new CustomException();
		exception.setProperties(properties);
		throw exception;
		
		


	}

}
