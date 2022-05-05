package com.akhilexpress.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.akhilexpress.exception.AppExceptionHandler;
import com.akhilexpress.model.Employee;
import com.akhilexpress.model.Student;

@RestController
public class MyRestController {

	// Consumes the data of employee
	// http://localhost:8080/spring-rest-jdbc/employee/

	String postUrl = "http://localhost:8080/spring-rest-jdbc/employee";
	String host = "http://localhost:8080/spring-rest-jdbc/employee/";
	// String url="http://localhost:8080/spring-rest-jdbc/employee/5";
	// String url="http://localhost:8080/spring-rest-jdbc/employee/{id}";
	// String url="http://localhost:8080/spring-rest-jdbc/employee/{api}/{id}";

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/fetch")
	public ResponseEntity<List<Employee>> fetchEmployeeData() {
		Employee[] employee;

		/*
		 * ResponseErrorhandler will not handle timeout exception .We have to
		 * use try catch block
		 */
		List<Employee> employeeList = null;
		try {
			employee = restTemplate.getForObject(host, Employee[].class);
			System.out.println(employee);

		employeeList = Arrays.asList(employee);
			System.out.println(employeeList);
		} catch (RestClientException e) {
			System.out.println(e);
		}

		/*
		 * for(int i=0;i<=employee.length;i++) {
		 * System.out.println(employee[i]); }
		 */

		return ResponseEntity.status(HttpStatus.OK).body(employeeList);

	}

	@PostMapping(value = "/create-employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		// Post
		// header-->Accept,Content Type

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json"); // produce
		headers.set("Content-Type", "application/json"); // Consumes

		/*
		 * Employee employee=new Employee(); employee.setEmployeeId(6);
		 * employee.setEmployeeName("Shailu");
		 */

		HttpEntity request = new HttpEntity(employee, headers);

		Employee createdEmployee = restTemplate.postForObject(postUrl, request, Employee.class);

		System.out.println("Employee created :" + createdEmployee);

		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@GetMapping(value = "/api/test")
	public String testGetForEntityMethod() {
		ResponseEntity<Employee[]> responseEntity;
		responseEntity = restTemplate.getForEntity(host, Employee[].class);

		// responseEntity = restTemplate.getForEntity(url,
		// Employee[].class,1);//Employee by ID

		// responseEntity = restTemplate.getForEntity(url,
		// Employee[].class,"employee",1);//Employee api and ID

		/*
		 * 
		 * Map<String,Object> uriVariables=new HashMap<String, Object>();
		 * urivariables.put("api","employee"); urivariables.put("id", 2);
		 * responseEntity = restTemplate.getForEntity(url,
		 * Employee[].class,uriVariables);//we can use for mltiples dynamic
		 * variable.
		 * 
		 */

		System.out.println(responseEntity);
		HttpHeaders headers = responseEntity.getHeaders();

		System.out.println("All my headers are :" + headers.keySet());
		Employee[] employeeBody = responseEntity.getBody();
		List<Employee> empList = Arrays.asList(employeeBody);
		System.out.println(empList);
		Set<String> keySet = headers.keySet();

		for (String key : keySet) {
			String value = headers.getFirst(key);
			System.out.println("Key : " + key + " value : " + value);
		}

		responseEntity.getStatusCode();

		return "Check your console";
	}

	@GetMapping(value = "/fetchhello")
	public Student fetchStudentData() {
		String host = "http://springrestdemo-env.eba-brztawyp.us-east-1.elasticbeanstalk.com/student/9?xyz";
		restTemplate.setErrorHandler(new AppExceptionHandler());
		// Student student = restTemplate.getForObject(host, Student.class);
		System.out.println(restTemplate.getForObject(host, Student.class));

		return null;

	}

}
