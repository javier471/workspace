package com.jacaranda.diccionario;

import java.util.LinkedList;

public class Diccionario {

	private String nombre;
	private LinkedList<Palabra> contenido;

	public Diccionario(String nombre) {
		super();
		this.nombre = nombre;
		this.contenido=new LinkedList<>();
	}
	
//	public boolean addLetra(Character letra) {
//		boolean resul=false;
//	}

}
