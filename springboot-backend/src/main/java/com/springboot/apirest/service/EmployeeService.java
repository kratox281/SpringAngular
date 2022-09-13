package com.springboot.apirest.service;

import java.util.List;

import com.springboot.apirest.model.Employee;



public interface EmployeeService {

	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployess();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);
	
}
