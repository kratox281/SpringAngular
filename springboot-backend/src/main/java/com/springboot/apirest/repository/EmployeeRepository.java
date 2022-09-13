package com.springboot.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.apirest.model.Employee;

//NO ES NECESARIO MARCAR ESTAS CLASES COMO REPOSITORIO YA QUE AL EXTENDER LA CLASE EXTENDIDA YA CONTIENE LAS ANOTACIONIES NECESARIAS

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
