package com.akhilexpress.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhilexpress.DAO.EmployeeDAO;
import com.akhilexpress.model.Employee;
import com.akhilexpress.model.EmployeeResponse;

@RestController
public class MyRestController {

	@Autowired
	EmployeeDAO employeeDAO;

	@GetMapping(value = "/hello")
	public String sayHello() {
		return "Welcome to Spring Rest JDBC project ";
	}

	/*
	 * @GetMapping(value="/employee") public ResponseEntity<List<Employee>>
	 * getAllEmployee() { List<Employee> allEmployee =
	 * employeeDAO.getAllEmployee(); return
	 * ResponseEntity.status(HttpStatus.OK).body(allEmployee);
	 * 
	 * }
	 * 
	 */

	@GetMapping(value = "/employee")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
		List<Employee> allEmployee = employeeDAO.getAllEmployee();
		// EmployeeResponse employeeResponse=new EmployeeResponse()
		List<EmployeeResponse> employeeResponse = new ArrayList<EmployeeResponse>();
		for (Employee temp : allEmployee) {
			employeeResponse.add(new EmployeeResponse(temp.getEmployeeId(), temp.getEmployeeName()));
		}
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);

	}

	@PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeDAO.saveEmployee(employee);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (emp.getEmployeeId() != 0) {
			employeeResponse.setEmployeeId(emp.getEmployeeId());
			employeeResponse.setEmployeeName(emp.getEmployeeName());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}

	@PutMapping(value = "/employee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
		Employee emp = employeeDAO.updateEmployee(employee, id);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (emp.getEmployeeName()!= null) {
			employeeResponse.setEmployeeId(id);
			employeeResponse.setEmployeeName(emp.getEmployeeName());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponse);
	}
}
