package com.springboot.apirest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.apirest.exception.ResourceNotFoundException;
import com.springboot.apirest.model.Employee;
import com.springboot.apirest.repository.EmployeeRepository;
import com.springboot.apirest.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	//@Autowired
	//CUANDO ESTAMOS EN SPRING 4.3 O SUPERIOR Y EL BEAN TIENE UN SOLO CONSTRUCTOR, LA ANOTACION @AUTOWIRED PUEDE
	//SER OMITIDA Y SPRING UTILIZARA ESTE CONSTRUCTOR PARA INJECTAR LAS DEPENDENCIAS NECESARIAS
		
	private EmployeeRepository employeeRepository;
	
	
	EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		super();
		this.employeeRepository =employeeRepository;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployess() {
		return employeeRepository.findAll();
		
	}

	@Override
	
	public Employee getEmployeeById(long id) {
//		 
//		Optional<Employee> employee =  employeeRepository.findById(id);
//		
//		if(employee.isPresent())
//		{
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		//Buscamos y si no encontramos devolvemos un error con la excepcion
		return this.employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id",id));
	
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//Lo primero es comprobar si el id existe en la BD
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		this.employeeRepository.save(existingEmployee);
		
		
		return existingEmployee;
	}
	
	@Override
	public void deleteEmployee(long id) {
		//Lo primero es comprobar si el id existe en la BD
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
				
		this.employeeRepository.delete(existingEmployee);
		
	}
	
	

}

