package com.springboot.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	
	@GetMapping("/if-unless")
	public String ifUnless(Model model)
	{
		List<User> lista = new ArrayList<>();	
		lista.add(new User("Nombre1", "Apellido1", "ADMIN"));
		lista.add(new User( "Nombre2", "Apellido2", "USER"));
		lista.add(new User("Nombre3", "Apellido3", "USER"));
		lista.add(new User("Nombre4", "Apellido4", "ADMIN"));
		model.addAttribute("lista", lista);
		
		return "if-unless";
	}
	
	
	@GetMapping("/switch-case")
	public String switchCase(Model model)
	{
		//List<User> lista = new ArrayList<>();	
//		lista.add(new User("Nombre1", "Apellido1", "ADMIN"));
//		lista.add(new User( "Nombre2", "Apellido2", "MANAGER"));
//		lista.add(new User("Nombre3", "Apellido3", "GUEST"));
//		lista.add(new User("Nombre4", "Apellido4", "GUEST"));
		model.addAttribute("user", new User( "Nombre2", "Apellido2", "MANAGER"));
		
		return "switch-case";
	}

}
