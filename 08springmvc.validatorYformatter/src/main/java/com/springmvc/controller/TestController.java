package com.springmvc.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

//	@ResponseBody
//	@RequestMapping("/")
//	public String home() {
//		return "Hola, el despachador me ha redirigido a la home";
//	}
	
	
	@ResponseBody
	@RequestMapping(path="/test", method = RequestMethod.GET)
	public String test() {
		return "Hola, funcionamos de forma correcta";
	}

	

	@RequestMapping(path="/saludar", method = RequestMethod.GET)
	public String saludar() {
		return "hola";
	}

	
}
