package com.firstapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstapplication.api.Student;

@RestController
public class StudentController {

	// SPRING RABAJA CON LA LIBRERIA GSON PARA CONVERTIR NUESTRO OBJETO EN UNO JSON
	// ESTE PROCESO OCURRE GRACAS A LOS HTTP CONVERTERS
	// El atributo produces="" no sirve para indeicar el tipo devuelto en la
	// peticion, por defect en Spring es Json
	@RequestMapping(path = "/get")
	public Student getStudent() {
		// ESTO DEVUELVE JSON PERO PUEDE DEVOLVER OTROS VALORE		
		return new Student("Nombre", "Apellido");		
	}
	
	

	@RequestMapping(path = "/getStudents")
	public List<Student> getStudents() {
		List<Student> lista = new ArrayList<>();

		lista.add(new Student("Nombre", "Apellido"));
		lista.add(new Student("Nombre", "Apellido"));
		lista.add(new Student("Nombre", "Apellido"));
		lista.add(new Student("Nombre", "Apellido"));

		return lista;
	}

	/*********** @PATHVARIABLE ***********/
	// http:localhost:8080/javi/apellido
	// @GetMapping("{nombre}/{apellido}")
	//esto recibe el nombre de URL TEMPLATE VARIABLE
	@GetMapping("student/{nombre}/{apellido}")
	public Student studentPathVariable(@PathVariable("nombre") String nombre,
			@PathVariable("apellido") String apellido) {
		return new Student(nombre, apellido);
	}

		
	@GetMapping("/enviarNombre")
	public Student studentRequestParam(	@RequestParam("nombre") String nombre) {
		return new Student(nombre, "Pascual");
	}

}
