package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller() //ESTEREOTIPO DE LA ANOTACION @Component
public class ControladorUno {
	
		//@GetMapping, @PostMapping
		@RequestMapping("/home") //ANOTACION PARA MAPEAR LA PETICION --> COLOCANDO EL PATRON DE ENTRADA CONSEGUIMOS QUE ESTE CONTROLADOR SEA EL PRIMERO QUE ES ATENDIDO POR EL DESPACHADOR SIEMPRE QUE LA RUTA ESTE DEFINIDA EN EL FICHERO DE CONFIGURACION
		@ResponseBody            //ANOTACION PARA INDICAR QUE LA RESPUETA LA ENVIAMOS EN EL BODY (TEXTO EN EL OBJETO RESPONSE DE LA PETICION, COMO HACIAMOS CON LOS SERVLETS)
		public String iniciar() {//EL METODO tiene un termino para referirse a el en este contexto y se conococe como REQUEST HANDLER
			return "Hola, soy el controlador que te envía a la home";
		}
		
				
		@RequestMapping("/saludar")		
		@ResponseBody
		public String saludar() {
					return "Hola, soy el controlador que te saluda desde la ruta raiz";
		}
		
		
		@RequestMapping("/get")
	    public String getPagina1() {
					
			return "pag";
			
			//SIN EL VIEW RESOLVER TENDRIAMOS QUE DEVOLVER TODA LA PAGINA CON LA RUTA DONDE ESTA ALOJADA, PERO ESTO DEBE DE SER CONFIGURABLE
			//return "/WEB-INF/view/pag.jsp";
		}
		
		
	

}
