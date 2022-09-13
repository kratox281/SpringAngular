package com.springcore.previos.inyeccion.ejemplos.a7_clasedeconfiguracion;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//Obligamos a Spring a que tome este objeto como primera opcion a la hora de la creación
@Primary
public class MathTeacher  implements Teacher {

	@Override
	public void teach() {
		System.out.println("Hola, soy el profesor de matemáticas");
		
	}
	
	

}
