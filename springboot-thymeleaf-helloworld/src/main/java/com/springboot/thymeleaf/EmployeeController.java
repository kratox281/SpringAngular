package com.springboot.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	
	@GetMapping("/iteration")
	public String iteration(Model model)
	{
		List<Employee> lista = new ArrayList<>();	
		lista.add(new Employee(1, "Nombre1", "Apellido1", "nombre1@gmail.com"));
		lista.add(new Employee(2, "Nombre2", "Apellido2", "nombre2@gmail.com"));
		lista.add(new Employee(3, "Nombre3", "Apellido3", "nombre3@gmail.com"));
		lista.add(new Employee(4, "Nombre4", "Apellido4", "nombre4@gmail.com"));
		model.addAttribute("lista", lista);
		
		return "iteration";
	}

}
