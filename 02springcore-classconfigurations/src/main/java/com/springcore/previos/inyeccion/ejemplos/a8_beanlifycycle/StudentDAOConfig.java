package com.springcore.previos.inyeccion.ejemplos.a8_beanlifycycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.springcore.previos.inyeccion.ejemplos.a8_beanlifycycle")
@PropertySource("classpath:studentDB.properties")
public class StudentDAOConfig {

}
