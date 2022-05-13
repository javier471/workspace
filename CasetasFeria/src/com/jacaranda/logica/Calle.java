package com.jacaranda.logica;

import java.util.HashSet;

public class Calle {

	private String nombre;
	private int id_calle;
	private HashSet<Caseta> listaCasetas;

	public Calle(String nombre, int id_calle) {
		super();
		this.nombre = nombre;
		this.id_calle = id_calle;
		listaCasetas=new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getId_calle() {
		return id_calle;
	}
	
	public void addCaseta(Caseta c) {
		listaCasetas.add(c);
	}
	
	public String mostrarCasetas() {
		StringBuilder resul=new StringBuilder();
		for(Caseta c: listaCasetas) {
			resul.append(c);
		}
		return resul.toString();
	}
	
	public String muestraCasetasFamiliar() {
		StringBuilder resul=new StringBuilder();
		for(Caseta c:listaCasetas) {
			if(c.getClase().equalsIgnoreCase("Familiar"));
			resul.append(c);
		}
		return resul.toString();
	}
	
	public String muestraCasetasDistrito() {
		StringBuilder resul=new StringBuilder();
		for(Caseta c:listaCasetas) {
			if(c.getClase().equalsIgnoreCase("Distrito")) {
				resul.append(c);
			}
		}
		return resul.toString();
	}
	
	public String muestraCasetasDistintas() {
		StringBuilder resul=new StringBuilder();
		for(Caseta c:listaCasetas) {
			if(!c.getClase().equalsIgnoreCase("Distrito") && !c.getClase().equalsIgnoreCase("Familiar")) {
				resul.append(c);
			}
		}
		return resul.toString();
	}

	@Override
	public String toString() {
		return "Calle [nombre=" + nombre + ", id_calle=" + id_calle + "]";
	}

	
	
}
