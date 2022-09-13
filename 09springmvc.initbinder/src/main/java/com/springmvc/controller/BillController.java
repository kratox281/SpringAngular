package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.api.FacturaDTO;

@Controller
public class BillController {
	
	FacturaDTO factura;	
	
	@RequestMapping("/factura")	
	public void factura()	
	{
		FacturaDTO factura = new FacturaDTO();
		
		
	}

}
