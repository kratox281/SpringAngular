package com.springcore.previos.inyeccion.ejemplos.a4_inyeccionporsetter;

public class College {
	
	
	private Director director;
	
	private Teacher  teacher;
	
//para inyectar las dependencias creamos setter o constructor que pasamos desde la clase de configuración que es la que nos gestiona los objetos
//	public College(Director director) {
//		super();
//		this.director = director;
//	}
//	
	
	
	//VAMOS A INYECTAR LOS VALORES UTILIZANDO UN SETTER
	//utilizaremos este metodo desde la clase de configuración
	public void setDirector(Director director) {
		this.director = director;
	}	
	
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	public void test()
	{
		System.out.println("Probando desde college");
		director.principalInfo();
		teacher.teach();
	}


	
	
	
}
