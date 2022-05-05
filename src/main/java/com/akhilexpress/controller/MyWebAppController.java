package com.akhilexpress.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.akhilexpress.model.Employee;

@Controller
public class MyWebAppController {
	
String url="http://localhost:8080/spring-rest-jdbc/employee/";
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value="/show-all-employee")
	public String showAllEmpoyees(Model model)
	{
		Employee[] employee;
		employee = restTemplate.getForObject(url, Employee[].class);
		System.out.println(employee);
		
		List<Employee> employeeList = Arrays.asList(employee);
		
		model.addAttribute("employees", employeeList);
		return "employee";
	}
}
