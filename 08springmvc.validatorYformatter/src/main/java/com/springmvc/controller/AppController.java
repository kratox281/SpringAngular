package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.api.UserInfoDTO;

@Controller
public class AppController {

	@RequestMapping(path = "/", method = RequestMethod.GET)	
	public String getHome(@ModelAttribute("userInfo") UserInfoDTO userInfo, BindingResult bindigin) {
		return "home";
	}

	@RequestMapping(path = "/calcular", method = RequestMethod.POST)
	public String calcular(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfo, BindingResult errores, Model model) {
		
		
		//COMPROBANDO EL VALOR DEL CHECHBOX
		System.out.println(userInfo.isTerms());
		

		// COMPROBAMOS QUE HAYA ALGUN ERROR Y LOS PROCESAMOS
		// HABRIA QUE ACTUAR EN CONSECUENCIA POR CADA ERROR
		if (errores.hasErrors()) {
			System.out.println("errores en la vinculacion del DTO");

			// PROCESAMOS LA LISTA DE ERRORES
			List<ObjectError> allErrors = errores.getAllErrors();

			for (ObjectError objectError : allErrors) {
				System.out.println(objectError);

			}	
			//SI NO PASAMOS LA VALIDACION VAMOS A LA HOME
			return "home";
		} 
		
		//Los mandamos a la siguiente pagina
		model.addAttribute("nombre", userInfo.getNombre());
		model.addAttribute("otroNombre", userInfo.getOtroNombre());

		//SI LA PASAMOS VAMOS A LA PAGINA DE RESULTADO
		return "resultado-home";
	}

}
