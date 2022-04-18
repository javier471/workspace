package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.LinkedList;

public class Diccionario {

	private String nombre;
	private HashMap<PalabraEmpiezan, Palabra> contenido;

	public Diccionario(String nombre) {
		super();
		this.nombre = nombre;
		this.contenido=new HashMap<>();
	}
	


}
