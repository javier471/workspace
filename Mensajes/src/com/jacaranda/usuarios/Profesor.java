package com.jacaranda.usuarios;

import com.jacaranda.mensajes.Mensaje;

public class Profesor extends Persona{

	public Profesor(String nombre, int edad, String dni) {
		super(nombre, edad, dni);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Profesor [toString()=" + super.toString() + "]";
	}

	
}
