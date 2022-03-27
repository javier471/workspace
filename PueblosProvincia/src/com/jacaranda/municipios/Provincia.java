package com.jacaranda.municipios;

import java.util.HashSet;
import java.util.Set;

public class Provincia {

	private String nombre;
	private String codigo;
	private int numHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private Set<Pueblo> listadoPueblos;

	public Provincia(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.listadoPueblos=new HashSet<Pueblo>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumHabitantes() {
		return numHabitantes;
	}

	public double getRentaPerCapita() {
		return rentaPerCapita;
	}

	public double getSuperficie() {
		return superficie;
	}

	private void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	private boolean existePueblo(String nombre) {
		boolean resul=false;
		for(Pueblo p:listadoPueblos) {
			if(p.getNombre().equals(nombre)) {
				resul=true;
			}
		}
		return resul;
	}
	
	public boolean addPueblo(String nombre, String codigo, int numhabitantes,double renta,double superficie) {
		boolean resultado=false;
		
	}
}
