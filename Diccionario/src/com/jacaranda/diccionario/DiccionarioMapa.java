package com.jacaranda.diccionario;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Diccionario {

	private HashMap<String, HashSet<String>> contenido;

	public Diccionario() {
		super();
		this.contenido = new HashMap<>();
	}

	public boolean addPalabra(String palabra, String significado) {
		boolean resul;
		// Si la palabra no está en el diccionario
		// El get devuelve el hashset porque devuelve el valor de la clave al que
		// está asociado
		if (contenido.get(palabra) == null) {
			HashSet<String> significados = new HashSet<>();
			significados.add(significado);
			if (contenido.put(palabra, significados) == null) {
				resul = false;
			} else {
				resul = true;
			}
		}
		// Si la palabra ya está
		else {
			contenido.get(palabra).add(significado);
			resul = true;
		}

		return resul;
	}
	
	public boolean borrarPalabra(String palabra) {
		boolean resul;
		if(contenido.remove(palabra)==null) {
			resul=false;
		}
		else {
			resul=true;
		}
		return resul;
	}

	public String buscarPalabraPorLetra(String cadena) {
		StringBuilder resul=new StringBuilder();
		for(String s:contenido.keySet()) {
			if(s.toUpperCase().startsWith(cadena.toUpperCase())) {
				resul.append(s.toString()+"\n");
			}
		}
		return resul.toString();
	}
	
	public boolean borrarSignificado(String palabra,String significado) {
		return contenido.get(palabra).remove(significado);
		
	}
	@Override
	public String toString() {
		return "Diccionario [contenido=" + contenido + "]";
	}

}
