package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.api.Telefono;
import com.springmvc.api.UserContactDTO;
import com.springmvc.api.UserRegisterDTO;

@Controller
public class RegisterController {

		
	@RequestMapping("/register")
	//CUANDO UTILIZAMOS @ModelAttribute no utilizamos el objeto Modelo, ya que el objeto va dentro del modelo
	public String registrar(@ModelAttribute("userRegister") UserRegisterDTO user) {		
		System.out.println("llegamos al registro");		
		
//		DESBLOQUEAR ESTE CÓDIGO PARA PROBAR EL METODO PRINT DEL FORMATTER		
		Telefono telefono = new Telefono();
		telefono.setPrefijo("+36");
		telefono.setUserNumber("4656456");
//		
//		
		UserContactDTO userContact = new UserContactDTO();
//		
		userContact.setTelefono(telefono);
//		
		user.setUserContact(userContact);
		
		return "registro";
	}

    @RequestMapping("/process-register")
    //EL NOMBRE EN LA ETIQUETA PUEDE SER CUALQUIERA PERO MEJOR SEGUIN CON EL MISMO
    //IMPORTANTE, AÑADIR LA ANOTACION @Valid, para activar las validaciones
	public String procesarRegistro(@Valid @ModelAttribute("userRegister") UserRegisterDTO user, BindingResult errores) {
		
    	System.out.println("Vamos a registrar");		
    	
    	if (errores.hasErrors()) {
			System.out.println("errores en la vinculacion del DTO");

			// PROCESAMOS LA LISTA DE ERRORES
			List<ObjectError> allErrors = errores.getAllErrors();

			for (ObjectError objectError : allErrors) {
				System.out.println(objectError);

			}	
			//SI NO PASAMOS LA VALIDACION VAMOS A LA HOME
			return "registro";
		} 
		

		return "index";
	}
    
    
    
    @InitBinder
	public void initBinder(WebDataBinder binder)
	{
		System.out.println("Estamos dentro del metodo de inicializacion del modelo");
		//PODEMOS DESHABILITAR EL VALOR DE ESTOS CAMPOS
		//DEPURANDO DESPUES DE ESTE METODO Y MIRANDO LOS VALORES DEL DTO VEREMOS QUE ESTÁN A NULL
		//binder.setDisallowedFields("name"); EJECUTAR UNA VEZ PORQUE SE PISAN
		binder.setDisallowedFields("gender", "age", "name");
		
		
		
		//VAMOS A ESTABLECER UN CONTROL PARA NO PODER METER ESPACIOS EN LOS CAMPOS, ESTO LO QUE HARA ES MIRAR A VER SI HAY ESPACIOS, QUITARLOS Y SI ESTA VACIO DEVOLVER FALSE EN LA VALIDACION
		//habria que utilizar metodos para poder validar de forma completa la vinculacion
		StringTrimmerEditor edito = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, edito);
		
		//PODRIAMOS ESTABLECER VALIDADORES PARA QUE SE COMPRUEBEN LOS REQUISITOS
		//binder.addValidators(null);
		
		
	}
    

}
