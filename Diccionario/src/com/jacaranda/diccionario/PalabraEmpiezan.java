package com.jacaranda.diccionario;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class PalabraEmpiezan {

	private Character letra;
	private LinkedList<Palabra> palabras;

	public PalabraEmpiezan(Character letra) {
		super();
		this.letra = Character.toUpperCase(letra);
		palabras = new LinkedList<>();
	}

	public Character getLetra() {
		return letra;
	}

	public boolean addPalabra(String palabra, String significado) throws PalabraException {
		boolean resul = false;
		int pos = buscaPosicion(palabra);
		if (pos == -1) {
			int nuevoSitio = buscaNuevoSitio(palabra);
			Palabra aux = new Palabra(palabra, significado);
			this.palabras.add(nuevoSitio, aux);
			resul = true;
		} else {
			this.palabras.get(pos).addSignificado(significado);
			resul = true;
		}
		return resul;
	}

	private int buscaPosicion(String palabra) {
		Palabra aux = new Palabra(palabra);
		return this.palabras.indexOf(aux);
	}

	private int buscaNuevoSitio(String palabra) {
		int posicion = 0;
		boolean encontrado = false;
		Iterator<Palabra> siguiente = palabras.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Palabra p1 = siguiente.next();
			if (p1.getPalabra().compareTo(palabra) < 0) {
				encontrado = true;
			} else {
				posicion++;
			}
		}
		return posicion;
	}

	public void delPalabra(String palabra) throws PalabraException {
		int pos=buscaPosicion(palabra);
		if(pos==-1) {
			throw new PalabraException("La palabra no existe");
		}
		palabras.remove(pos);
		//Debería borrar los significados de la palabra??
	}

	@Override
	public int hashCode() {
		return Objects.hash(letra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabraEmpiezan other = (PalabraEmpiezan) obj;
		return Objects.equals(letra, other.letra);
	}

	@Override
	public String toString() {
		return "PalabraEmpiezan [letra=" + letra + ", palabras=" + palabras + "]";
	}
	
	
	
}
