package com.akhilexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhilexpress.DAO.EmployeeDAO;
import com.akhilexpress.model.Employee;

@RestController
public class MyRestController {
	
	@Autowired
	EmployeeDAO employeeDAO;

	@GetMapping(value="/hello")
	public String sayHello()
	{
		return "Welcome to Spring Rest JDBC project " ;
	}
	
	@GetMapping(value="/employee")
	public ResponseEntity<List<Employee>>  getAllEmployee()
	{
		List<Employee> allEmployee = employeeDAO.getAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(allEmployee);
		
	}
}
