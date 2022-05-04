package com.akhilexpress.model;

public class EmployeeResponse {
	
	private int employeeId;
	private String employeeName;
	
	public EmployeeResponse() {
		
	}
	
	
	public EmployeeResponse(int employeeId, String employeeName) {
		
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		
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


	@Override
	public String toString() {
		return "EmployeeResponse [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}
	
	
	
	

}
