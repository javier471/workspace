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

	public Provincia(String nombre, String codigo) throws ProvinciaException {
		super();
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.listadoPueblos = new HashSet<Pueblo>();
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

	private void setCodigo(String codigo) throws ProvinciaException {
		if (codigo.length() != 2 || !(codigo.chars().allMatch(Character::isDigit))) {
			throw new ProvinciaException("Codigo no valido");
		}
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	private boolean existePueblo(String nombre) {
		boolean resul = false;
		for (Pueblo p : listadoPueblos) {
			if (p.getNombre().equals(nombre)) {
				resul = true;
			}
		}
		return resul;
	}

	public boolean addPueblo(String nombre, String codigo, int numhabitantes, double renta, double superficie)
			throws PuebloException, ProvinciaException {
		boolean resultado = false;
		String nuevoCodigo=this.codigo+codigo;
		Pueblo aux = new Pueblo(nombre, nuevoCodigo, numhabitantes, renta, superficie);
		if (!existePueblo(nombre)) {
			listadoPueblos.add(aux);
			resultado = true;
			this.superficie += aux.getSuperficie();
			this.numHabitantes += aux.getNumHabitantes();
			this.rentaPerCapita += aux.getRentaPerCapita();
		}
		else {
			throw new ProvinciaException("El pueblo no puede crearse");
		}
		return resultado;
	}

	public String listadoPueblosNombre() {
		StringBuilder resul = new StringBuilder();
		for (Pueblo p : listadoPueblos) {
			resul.append(p.getNombre() + " ");
		}
		return resul.toString();
	}

	public String listadoPueblos() {
		StringBuilder resul = new StringBuilder();
		for (Pueblo p : listadoPueblos) {
			resul.append(p.toString() + " ");
		}
		return resul.toString();
	}

	public boolean delPueblo(String nombre) throws ProvinciaException {
		boolean resul = false;
		if (!existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo no existe");
		}
		for (Pueblo p : listadoPueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				this.superficie -= p.getSuperficie();
				this.numHabitantes -= p.getNumHabitantes();
				this.rentaPerCapita -= p.getRentaPerCapita();
				listadoPueblos.remove(p);
				resul = true;
			}
		}
		return resul;
	}

	public boolean setSuperficie(String nombre, double superficie) throws PuebloException {
		boolean resul = false;
		for (Pueblo p : listadoPueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				double aux=p.getSuperficie()-superficie;
				p.setSuperficie(superficie);
				this.superficie+=aux;
				resul = true;
			}
		}
		return resul;
	}

	public boolean setNumeroHabitantes(String nombre, int numHabitantes) throws PuebloException {
		boolean resul = false;
		for (Pueblo p : listadoPueblos) {
			if (p.getNombre().equalsIgnoreCase(nombre)) {
				int aux=p.getNumHabitantes()-numHabitantes;
				p.setNumHabitantes(numHabitantes);
				this.numHabitantes+=aux;
				resul = true;
			}
		}
		return resul;
	}

	public int numPueblos() {
		return listadoPueblos.size();
	}

	@Override
	public String toString() {
		return "Provincia [nombre=" + nombre + ", codigo=" + codigo + ", numHabitantes=" + numHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + ", listadoPueblos="
				+ listadoPueblos + "]";
	}

	public String getInformacionPueblo(String pueblo) throws ProvinciaException {
		if (!existePueblo(pueblo)) {
			throw new ProvinciaException("No existe ese pueblo");
		}
		String resul = "";
		for (Pueblo p : listadoPueblos) {
			if (p.getNombre().equalsIgnoreCase(pueblo)) {
				resul = p.toString();
			}
		}
		return resul;
	}

}
