package com.springmvc.controllers.envioparametros;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class ControladorCafe {
	
	@RequestMapping(value = "/cafe", method = RequestMethod.GET)
	//Para pasar datos a la vista utilizamos los objetos Model o Model&View
	public ModelAndView cafe(Model model, ModelAndView mv /*ESTE OBJETO CONTIENE LA CAPACIDAD DE REDIRIGIR A LA VISTA*/)
	{
		
		//SETEAMOS VALORES EN EL MODELO PARA QUE PUEDAN SER PASADOS A LA VISTA				
		mv.addObject("title", "Cafe APP");
		
		//SETEAMOS EL NOMBRE DE LA VISTA
		mv.setViewName("cafe");
		
		//DEVOLVEMOS LA VISTA POR SU NOMBRE
		//IMPORTANTE!!! --> LA VISTA DEBE DE TENER ExpressionLanguage ACTIVO PARA PODER MOSTRAR LOS DATOS
		return mv; // "cafe";		
		
	}
	
	
	@RequestMapping(value = "/realizarPedido", method = RequestMethod.GET)
	public String cafe(Model model, HttpServletRequest request)
	{
		//SETEAMOS VALORES EN EL MODELO PARA QUE PUEDAN SER PASADOS A LA VISTA				
		model.addAttribute("comida", request.getParameter("comida"));
		
		
		//DEVOLVEMOS LA VISTA POR SU NOMBRE
		//IMPORTANTE!!! --> LA VISTA DEBE DE TENER EL ACTIVO PARA PODER MOSTRAR LOS DATOS
		return "pedidoRealizado";	
	}
			

}
