package com.springboot.apirest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.apirest.model.Employee;
import com.springboot.apirest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	// NO NECESITAMOS PONER AUTOWIRED PORQUE SPRING BOOT SI HAY UN SOLO CONSTRUCTOR  TOMARA ESTE PARA CREAR EL BEAN
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		// Esta linea guardara guardara los datos en la base de datos el objeto creado
		
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

	}

	// build getAllSomething REST API
	@GetMapping()
	public List<Employee> getAllEmployees() {

		return this.employeeService.getAllEmployess();

	}

	// build getAllSomethingById REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {

		return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	// build getAllSomethingById REST API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		System.out.println("Estamos en el put");
		return new ResponseEntity<Employee>(this.employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	// build getAllSomethingById REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		System.out.println("Estamos en el delete");
		this.employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("", HttpStatus.OK);

	}
}

