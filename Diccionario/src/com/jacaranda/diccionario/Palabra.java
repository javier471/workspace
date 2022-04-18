package com.jacaranda.diccionario;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Palabra {

	private String palabra;
	private Set<String> significados;

	public Palabra(String palabra) {
		super();
		this.palabra = palabra;
		this.significados = new HashSet<>();
	}

	public Palabra(String palabra, String significado) {
		super();
		this.palabra = palabra;
		this.significados = new HashSet<>();
		this.significados.add(significado);
	}

	public String getPalabra() {
		return palabra;
	}

	public Character getInicialPalabra() {
		Character inicial = palabra.charAt(0);
		return inicial;
	}

	public void addSignificado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("Significado no válido");
		}
		if(!(significados.add(significado))) {
			throw new PalabraException("Significado repetido");
		}
	}

	public void delSignificado(String significado) throws PalabraException {
		if (significado == null) {
			throw new PalabraException("Significado no válido");
		}
		if(!(significados.remove(significado))) {
			throw new PalabraException("No se puede borrar siginificado");
		}
	}
	
	public boolean delTodosSignificados() throws PalabraException {
		significados.clear();
		return true;
		
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Palabra other = (Palabra) obj;
		return Objects.equals(palabra, other.palabra);
	}

	@Override
	public String toString() {
		return "Palabra [palabra=" + palabra + ", significados=" + significados.toString() + "]";
	}

}
