package com.springcore.previos.inyeccion.ejemplos.a1_inyeccionbasica;


public class Vodafone implements Sim{

	@Override
	public void calling() {
		System.out.println("llamando desde Vodafone");
		
	}

	@Override
	public void data() {
		System.out.println("Navegando desede Vodafone");
		
	}

}