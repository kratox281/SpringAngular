package com.springboot.studentmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.studentmanagement.entity.Student;
import com.springboot.studentmanagement.repository.StudentRepository;


//IMPORTANTE. IMPLEMENTAMOS ESA INTERFAZ PARA PODER UTILIZAR EL METODO RUN Y PODER, POR EJEMPLO, CARGAR DATOS
@SpringBootApplication
public class SpringbootThymeleafHelloworld1Application implements CommandLineRunner{

	@Autowired
	private StudentRepository student;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafHelloworld1Application.class, args);
	}

	
	//vamos a utiilzar esto para introducir algun objeto en la base de datos
	
	
	@Override
	public void run(String[] args) throws Exception {
		System.out.println("llamamos al run");
		//Cargamos datos
		this.student.save(new Student(12l,"Javi", "Apellido","email@gmail.com"));
		this.student.save(new Student(13L,"Javi2", "Apellido2","email@gmail.com"));
		this.student.save(new Student(14l,"Javi3", "Apellido3","email@gmail.com"));
	}
	

}
