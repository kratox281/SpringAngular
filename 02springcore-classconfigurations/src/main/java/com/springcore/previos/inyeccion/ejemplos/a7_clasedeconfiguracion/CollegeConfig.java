package com.springcore.previos.inyeccion.ejemplos.a7_clasedeconfiguracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


//solo lo utilizamos si utilizamos la anotación @Component en alguna de las clases que tengamos
@Configuration
@ComponentScan(basePackages="com.springcore.previos.inyeccion.ejemplos.a7_clasedeconfiguracion")
@PropertySource("classpath:college-info.properties") //AÑADIMOS LA ANOTACIÓN DE PROPERTY SOURCE PARA PODER LEER FICHEROS DE PROPIEDADES
public class CollegeConfig {
//NO NECESITAMOS UTILIZAR NINGUN TIPO DE DEFINICIÓN DE BEAN CON LAS PROPIEDADES DE SCANEO Y AUTOWIRING, CON LO QUE SOLO DEFINIMOS, EN ESTE CASO, EL PAQUETE A ESCANEAR y las anotaciones de @component o cualquiera de los estereotipos 
}
