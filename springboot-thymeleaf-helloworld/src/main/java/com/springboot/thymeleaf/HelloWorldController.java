package com.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
	
	@GetMapping("/")
	public String hello(Model model)
	{
		model.addAttribute("message", "Hola Mundo");
		return "hello-world";
	}
	
	@GetMapping("/demo")
	public String demoJsCss(Model model)
	{
		model.addAttribute("message", "Hola Mundo");
		return "add-css-js";
	}
	
	@GetMapping("/bootstrap")
	public String demoBootstrap(Model model)
	{
		model.addAttribute("message", "Hola Mundo");
		return "add-bootstrap";
	}

}
