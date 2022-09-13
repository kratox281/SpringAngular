package com.firstapplication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.firstapplication.controller.FirstController;



//ESTA ANOTACIÓN ES LA ENCARGADA DE REALIZAR EL SCANEO DE COMPONENTES DENTRO DEL PAQUETE Y DENTRO DE LOS SUBPAQUETES QUE TENGA ESTE PAQUETE. 
@SpringBootApplication
public class FirstapplicationApplication {

	public static void main(String[] args) {
		//Cremos el contexto
		ConfigurableApplicationContext context =  SpringApplication.run(FirstapplicationApplication.class, args);
		
		//Creamos un bean
		FirstController bean = context.getBean("first", FirstController.class);
		

		System.out.println(bean.getParametro());
		
		
		//CREAMOS UN LOGGER PARA MOSTRAR MENSAJES A TRAVES DEL SERVIDOR
		Logger logger = LogManager.getLogger(FirstapplicationApplication.class);	
		logger.info("<<<<< logger info");
		logger.warn("<<<<< logger warn");
		logger.error("<<<<< logger error");
		
		
		 
		System.out.println("Estamos en una aplicacion de Spring boot");
		
	}
	
	

}
