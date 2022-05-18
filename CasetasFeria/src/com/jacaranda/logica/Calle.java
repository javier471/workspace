package com.jacaranda.logica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Calle {

	private String nombre;
	private int id_calle;
	protected HashSet<Caseta> listaCasetas;

	public Calle(String nombre, int id_calle) {
		super();
		this.nombre = nombre;
		this.id_calle = id_calle;
		listaCasetas = new HashSet<>();
	}

	public Calle(String nombre) {
		super();
		this.nombre = nombre;
		listaCasetas = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getId_calle() {
		return id_calle;
	}

	public boolean addCaseta(Caseta c) {
		return listaCasetas.add(c);
	}

	public String mostrarCasetas() {
		StringBuilder resul = new StringBuilder();
		for (Caseta c : listaCasetas) {
			resul.append(c.toString() + "\n");
		}
		return resul.toString();
	}

	public String muestraCasetasFamiliar() {
		StringBuilder resul = new StringBuilder();
		for (Caseta c : listaCasetas) {
			if (c.getClase().equalsIgnoreCase("FAMILIAR")) {
				resul.append(c.toString() + "\n");
			}
		}
		return resul.toString();
	}

	public boolean eliminarCaseta(String caseta) {
		boolean encontrado = false;
		Iterator<Caseta> nextCaseta = listaCasetas.iterator();
		while (nextCaseta.hasNext() && !encontrado) {
			Caseta c = nextCaseta.next();
			if (c.getTitulo().equalsIgnoreCase(caseta)) {
				listaCasetas.remove(c);
				encontrado = true;
			}
		}
		return encontrado;
	}

	public HashSet<Caseta> listadoCasetas() {
		HashSet<Caseta> copia = listaCasetas;
		return copia;
	}

	public String muestraCasetasDistrito() {
		StringBuilder resul = new StringBuilder();
		for (Caseta c : listaCasetas) {
			if (c.getClase().equalsIgnoreCase("DISTRITO")) {
				resul.append(c.toString()+"\n");
			}
		}
		return resul.toString();
	}

	public String muestraCasetasDistintas() {
		StringBuilder resul = new StringBuilder();
		for (Caseta c : listaCasetas) {
			if (!(c.getClase().equalsIgnoreCase("DISTRITO")) && !(c.getClase().equalsIgnoreCase("FAMILIAR"))) {
				resul.append(c.toString()+"\n");
			}
		}
		return resul.toString();
	}

	@Override
	public String toString() {
		return "Calle [nombre=" + nombre + ", id_calle=" + id_calle + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calle other = (Calle) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
