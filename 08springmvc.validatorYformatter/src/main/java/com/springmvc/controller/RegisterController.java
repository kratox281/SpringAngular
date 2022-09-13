package com.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
		

		return "resultado-registro";
	}
    
    
    

}
