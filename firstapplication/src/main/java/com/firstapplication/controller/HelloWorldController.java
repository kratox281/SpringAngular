package com.firstapplication.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//TODAS LAS PETICIONES DE ESTA CLASE DEBEN DE SER ATENTIDAS MEDIANTE PETICIONES 

//GET
//POST 
//PUT
//DELETE


//@Controller
//A nivel de clase si utilizamos esto convertimos el controlador en un controlador REST
//@ResponseBody
//Esta anotacion es la composicion de las dos anotiaciones anteriores
@RestController
public class HelloWorldController {
	
	//Atendera la peticion get para esta URL
	@GetMapping("/hello")
	public String helloWorldGet()
	{
		return "Hello World desde el get";
	}
	
	
	@PostMapping("/hello")
	public String helloWorldPost(HttpServletResponse response)
	{
		response.setStatus(400);
		return "Hello World desde el post";
	}

	
	
	@PutMapping("/hello")
	public String helloWorldPut()
	{
		return "Hello World desde el put";
	}

	
	@DeleteMapping("/hello")
	public String helloWorldDelete()
	{
		return "Hello World desde el delete";
	}


}
