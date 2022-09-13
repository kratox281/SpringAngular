package com.springcore.previos.inyeccion.ejemplos.a7_clasedeconfiguracion;

import org.springframework.stereotype.Component;

@Component
public class ScienceTeacher implements Teacher{
	
	
	@Override
	public void teach() {
		System.out.println("Hola, soy el profesor de ciencias");

	}

}
