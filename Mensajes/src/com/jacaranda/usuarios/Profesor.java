package com.jacaranda.usuarios;

import com.jacaranda.mensajes.Mensaje;

public class Profesor extends Persona{

	public Profesor(String nombre, int edad, String dni) {
		super(nombre, edad, dni);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public boolean sendMensaje(Persona p,String texto) throws ProfesorException {
		boolean resul=false;
		if(p==null || texto==null) {
			throw new ProfesorException("Mensaje no válido");
		}
		Mensaje aux=new Mensaje(super.getNombre(),p.getNombre(),texto);
		enviados.add(aux);
		p.recibidos.add(aux);
		resul=true;
		return resul;
	}

	@Override
	public String toString() {
		return "Profesor [toString()=" + super.toString() + "]";
	}

	
}
