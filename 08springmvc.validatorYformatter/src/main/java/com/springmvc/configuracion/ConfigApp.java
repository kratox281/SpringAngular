package com.springmvc.configuracion;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.api.TelefonoFormatter;



@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.springmvc.controller, com.springmvc.api")
public class ConfigApp implements WebMvcConfigurer {


	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		System.out.println("Construimos el view resolver");
		
		return viewResolver;
	}
	
	
	//ESTE METODO PERMITE REGISTRAR UN FICHERO DE PROPIEDADES, EN ESTE CASO PARA LOS MENSAJES
	//PRIMERO CREAMOS EL RECURSO PARA LEER EL FICHERO DE PROPIEDADES
	@Bean 
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource message = new ResourceBundleMessageSource();
		
		//Nombre del fichero sin extension
		message.setBasename("messages");		
		
		System.out.println("Construimos messageResource");
		return message;		
	}
	
	
	//ESTABLECEMOS UN METODO PARA DECIRLE A SPRING CUAL VA A SER NUESTRA FUENTE PARA LAS VALIDACIONES
	@Bean(name="validator")	
	public LocalValidatorFactoryBean  validator() {
		
		System.out.println("Estamos en el registro del validador despues de que Spring haya llamado al metodo getValidator");
		LocalValidatorFactoryBean localValidator = new LocalValidatorFactoryBean();
		//REGISTRAMOS EL VALIDADOR LOCAL CON EL VALOR DEVUELTO POR EL METODO DE messageSource
		localValidator.setValidationMessageSource(messageSource());
		
		return localValidator;
	}
	
	//Por ultimo, sobreescribimos el metodo que permite a Spring obtener el validador
	@Override
	public Validator getValidator() {	
		System.out.println("Spring esta obteniendo el validador");
		return validator();
	}
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {	
		//Eliminamos lo que hay y registramos nuestro formateador	ç
		System.out.println("Ahora registramos el foramteador");
		registry.addFormatter(new TelefonoFormatter());
	}

	
	
	

	
}
