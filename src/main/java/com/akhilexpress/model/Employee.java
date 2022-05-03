package com.akhilexpress.model;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private int age;
	
	public Employee() {
		
	}
	
	
	public Employee(int employeeId, String employeeName, int age) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
