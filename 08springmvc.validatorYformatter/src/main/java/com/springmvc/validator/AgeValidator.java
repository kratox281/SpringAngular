package com.springmvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Tenemos que utilizar la interfaz para poder hacer que la clase sea un parametro valido en la interfaz de la anotacion
public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int upper;
	private int lower;

	// Es interesante añadir el metodo initialize para hacer algo en la
	// preconstrucción
	@Override
	public void initialize(Age age) {
		// Asignamos los valores para poder hacer la validación mas adelante
		//las llamadas a estos metodos lo que devuelven son los valores por defecto que hemos declarado en la anotación
		this.upper = age.upper();
		this.lower = age.lower();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {

		if(age == null)
		{
			return false;
		}
		
		if (age < lower || age > upper) {
			return false;
		}

		return true;

	}

}
