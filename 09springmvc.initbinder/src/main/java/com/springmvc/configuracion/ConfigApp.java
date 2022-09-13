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

//ESTA FORMA DE CONFIGURAR EL DISPATHCER ES PARA TENER TODO EL CONTROL SOBRE SU CONFIGURACIÓN
//EN EL OTRO FICHERO VEREMOS UNA FORMA MAS DE HACERLO

//importante para que se activan todas las configuraciones de mvc 
@EnableWebMvc
//Tan solo con esto ya no necesitaríamos nuestro fichero de configuración de spring, tendría que sustituirlo por estas dos clases que que tenemos en este paquete
@Configuration
@ComponentScan(basePackages = "com.springmvc.controller, com.springmvc.api")


//VAMOS A INTRODUCIR EL USO DE ESTA INTERFZ PARA PODER USAR LOS FORAMTEADORES 
public class ConfigApp implements WebMvcConfigurer {

	// ES MUY IMPORTANTE ACORDARSE DE QUE EL VIEW RESOLVER ES UN BEAN DENTRO DE
	// SPRING, YA QUE TODOS LOS OBJETOS QUE QUEREMOS USAR DESDE SPRING LO SON
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;

	}
	
	@Bean 
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource message = new 	ResourceBundleMessageSource();
		message.setBasename("messages");		
		
		return message;
		
	}
	
	
	@Bean(name="validator")
	//El nombre de esta funcion tiene que ser especificamente validator
	public LocalValidatorFactoryBean  validator() {
		
		LocalValidatorFactoryBean localValidator = new LocalValidatorFactoryBean();
		localValidator.setValidationMessageSource(messageSource());
		
		return localValidator;
	}
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {	
		//Eliminamos lo que hay y registramos nuestro formateador	ç
		System.out.println("Ahora registramos el foramteador");
		registry.addFormatter(new TelefonoFormatter());
	}

	@Override
	public Validator getValidator() {	
		return validator();
	}
	
}
