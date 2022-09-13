package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControladorDos {	
	    
		@RequestMapping("/dos")	
		@ResponseBody
		public String saludar() {			
			return "Hola, soy el controlador 2";
		}
		
}
