package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tres") // Esto es lo que sería mapear a nivel de clase, y luego tendríamos los metodos como endpoints de la peticion.  //Mapeando el controlador podemos agrupar funcionalidades  por ruta
public class ControladorTres {

	@RequestMapping("/prueba") 
	@ResponseBody
	public String saludar() {
		return "Hola, soy el controlador que tiene un mapeo a nivel de clase";
	}

	
	@RequestMapping("/contestar") 
	@ResponseBody
	public String contestar() {
		return "Hola, respueta desde el segundo metodo del controlador a nivel de clase";
	}

}
