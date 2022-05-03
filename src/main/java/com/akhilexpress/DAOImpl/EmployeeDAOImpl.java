package com.akhilexpress.DAOImpl;

import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.akhilexpress.DAO.EmployeeDAO;
import com.akhilexpress.model.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployee() {
		
		String sql="Select * from employee";
		List <Employee> employees = jdbcTemplate.query(sql, new RowMapper<Employee>()
				{

					public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
						int empId=rs.getInt("emp_id");
						String empName=rs.getString("emp_name");
						int empAge=rs.getInt("emp_age");
						Employee employee=new Employee(empId, empName, empAge);
						
						return employee;
					}
			
				}
				);
		
		return employees;
	}

}
