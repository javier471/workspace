package com.jacaranda.mensajes;

import java.util.LinkedList;
import java.util.List;

public class Persona {

	private String nombre;
	private int edad;
	private String DNI;
	private List<Mensaje> recibidos;
	private List<Mensaje> enviados;

	public Persona(String nombre, int edad, String dNI) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		DNI = dNI;
		this.recibidos = new LinkedList<>();
		this.enviados = new LinkedList<>();
	}

	public boolean sendMensaje(Persona p, String texto) {
		boolean resul = false;
		try {
			Mensaje aux = new Mensaje(this.nombre, p.nombre, texto);
			this.enviados.add(aux);
			p.recibidos.add(aux);
			resul = true;
		} catch (Exception e) {
			e.getMessage();
		}
		return resul;
	}
}
