package com.springcore.previos.inyeccion.ejemplos.a3_inyeccionporconstruccion;

import org.springframework.stereotype.Component;


//PODEMOS NO UTILIZAR LA ANOTACION AQUÍ Y HACERLO DENTRO DE LA CLASE DE CONFIGURACION
//@Component("collegeBean") --> En caso de tener que utilizar esta anotacion y no tener nombre, su id será el nombre de la clase con la letra en minuscula. Importante respetar la notación recomendada para que esto funcione

//EN PRINCIPIO ESTE TIPO DE CLASE NO NECESITA TENER ANOTACIONES YA QUE SE REALIZA TODO EN SU CLASE DE CONFIGURACION

//TAMPOCO TENDRIAMOS LA NECESIDAD DE ESCANEAR EN LA CLASE DE CONFIGURACION YA QUE HAY QUE HACEMOS REFERENCIA DESDE ELLA A ESTA MISMA CLASE
public class College {
	
	
	private Director director;
	
	
	//para inyectar las dependencias creamos setter o constructor que pasamos desde la clase de configuración que es la que nos gestiona los objetos
	public College(Director director) {
		super();
		this.director = director;
	}
	
	
	public void test()
	{
		System.out.println("Probando desde college");
		director.principalInfo();
	}


	
}
