package com.springmvc.api;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

public class TelefonoFormatter implements Formatter<Telefono>{

		
	//ESTE ES EL METODO QUE SE USA CUANDO QUEREMOS PRESENTAR EL OBJETO DESDE EL OBJETOY PINTARLO EN UN FORMULARIO
	@Override
	public String print(Telefono object, Locale locale) {
		
		System.out.println("Dentro del impresor");

		return object.getPrefijo() + "-" + object.getUserNumber();
	}

	
	//ESTE METODO ES EL QUE SE USA CUANDO ESTAMOS INSERTANDO LOS DATOS PARA QUE SE PUEDAN VINCULAR DE FORMA AUTOMATICA SIN TENER QUE SEPARARLOS EN VARIOS CAMPOS
	@Override
	public Telefono parse(String text, Locale locale) throws ParseException {
        
		System.out.println("Dentro del conversor");
		
		
		//aqui habria que hacer todas la validaciones posibles para los casos en los que no venga el guion, en los que el formato este mal en general
		
		String[] telefonoArray = text.split("-");
		
		Telefono telefono = new Telefono();
		
		telefono.setPrefijo(telefonoArray[0]);
		telefono.setUserNumber(telefonoArray[1]);
		
		
		
		return telefono;
	}
	

}
