package com.jacaranda.usuarios;

import com.jacaranda.mensajes.Mensaje;


public class Alumno extends Persona {

	public Alumno(String nombre, int edad, String dNI) {
		super(nombre, edad, dNI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sendMensaje(Persona p, String texto) throws AlumnoException {
		boolean resul = false;
		if (p instanceof Alumno && this.getEdad() < 18) {
			throw new AlumnoException("No se puede enviar el mensaje");
		}
		Mensaje m1 = new Mensaje(super.getNombre(), p.getNombre(), texto);
		p.recibidos.add(m1);
		super.enviados.add(m1);
		resul = true;
		return resul;
	}

	@Override
	public String toString() {
		return "Alumno [toString()=" + super.toString() + "]";
	}
	
	
}
