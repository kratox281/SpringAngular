package com.firstapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

//@RestController
//@Component
@Controller("first")
@Data
public class FirstController {
	
	private String parametro = "parametro";
	
	@RequestMapping("/prueba")
	public String goHome()
	{
		System.out.println("Estamos en el controlador");
		return "redirect:/home.jsp";
	}

	public String getParametro() {

		return parametro;
	}

}
