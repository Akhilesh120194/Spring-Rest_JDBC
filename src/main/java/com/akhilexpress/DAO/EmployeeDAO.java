package com.akhilexpress.DAO;

import java.util.List;

import com.akhilexpress.model.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(Employee employee, int id);

	
}
