package com.springcore.previos.inyeccion.ejemplos.a7_clasedeconfiguracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


//PODEMOS NO UTILIZAR LA ANOTACION AQUÍ Y HACERLO DENTRO DE LA CLASE DE CONFIGURACION
@Component("collegeBean") //--> En caso de tener que utilizar esta anotacion y no tener nombre, su id será el nombre de la clase con la letra en minuscula. Importante respetar la notación recomendada para que esto funcione
public class College {
	
	//RECORDAD QUE ESTA ETIQUETA INSERTA EL VALOR DIRECTAMENTE EN EL ATRIBUTO
	@Value("${college.name}")
	private String collegeName;
	
	//TENEMOS ANOTACIONES DE COMPONENT EN LAS CLASES QUE QUEREMOS QUE SEAN AUTOINYECTADAS
	@Autowired
	private Director director;

	//PARA ESTE CASO LO QUE HAY QUE HACER ES PONER LA ANOTACION EN LAS CLASES QUE IMPLEMENTAN LA INTERFAZ. 
	//¿QUE OCURRE SI TENEMOS MAS DE UNA CLASE QUE IMPLEMENTA LA INTERFAZ? ocurriria ambiguedad a la hora de resolver y necesitariamos otra anotacion
	@Autowired
	//COMO VEMOS, ESTA ANOTACIÓN TIENE PREFERENCIA SOBRE LA ANOTACION @primary. PODEMOS DEJAR LAS DOS ACTIVAS PERO SE EJECUTARÁ ESTA PRIMERO.
	@Qualifier("scienceTeacher") //Ponemos el nombre en pequeño porque no tenemos un alias para el componente
	private Teacher  teacher;
	

	public void test()
	{
		System.out.println("Probando desde college");
		System.out.println("El nombre del colegio es "+ this.collegeName);
		director.principalInfo();
		teacher.teach();
	}
	
	
}
