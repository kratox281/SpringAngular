package com.springcore.previos.inyeccion.ejemplos.a3_beanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {


		ApplicationContext context = new ClassPathXmlApplicationContext("beansEjemplo3.xml");

		// CREAMOS ESTOS DOS BEANS DEFINIDOS EN EL XML PARA PROBAR LA INYECCION POR SETTER
		Student student = context.getBean("student", Student.class);
		student.displayStudentInfo();
		student.cheating();

		Student student2 = context.getBean("student2", Student.class);
		student2.displayStudentInfo();
		student2.cheating();

		// CREAMOS ESTE BEAN DEFINIDO EN EL XML PARA PROBAR LA INYECCION POR CONSTRUCTOR
		Student student3 = context.getBean("student3", Student.class);
		student3.displayStudentInfo();
		student3.cheating();

		// ESTA SERIA LA CONFIGURACION CORRECTA EN EL XML PARA PODER UTILIZAR LA MISMA REFERENCIA A UN OBJETO COMPARTIDO DEL QUE SOLO NECESITARAMOS UNA INSTANCIA PARA EJECUTAR SU FUNCIONALIDAD YA QUE NO CAMBIA SU ESTADO
		OtraClaseUsandoMathCheat student4 = context.getBean("student4", OtraClaseUsandoMathCheat.class);
		student4.displayStudentInfo();
		student4.cheating();
		
		//COMO SE PUEDE VER AQUÍ, LAS DOS CLASES ESTAN COMPARTIENDO EL MISMO OBJETO CREADO POR EL CONTENEDOR
		System.out.println(student3.getMathCheat() + "  " + student4.getMathCheat());
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
