package com.jacaranda.municipios;

import java.util.Iterator;
import java.util.LinkedList;

public class ProvinciaLinked {
	private String nombre;
	private String codigo;
	private int numHabitantes;
	private double rentaPerCapita;
	private double superficie;
	private LinkedList<PuebloLinked> listadoPueblos;

	public ProvinciaLinked(String nombre, String codigo) throws ProvinciaException {
		super();
		if(nombre==null|| codigo==null) {
			throw new ProvinciaException("Nombre o codigo no válido");
		}
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		this.listadoPueblos = new LinkedList<PuebloLinked>();
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
		for (PuebloLinked p : listadoPueblos) {
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
		PuebloLinked aux = new PuebloLinked(nombre, nuevoCodigo, numhabitantes, renta, superficie);
		if (!existePueblo(aux.getNombre())) {
			listadoPueblos.add(aux);
			this.superficie += aux.getSuperficie();
			this.numHabitantes += aux.getNumHabitantes();
			this.rentaPerCapita += aux.getRentaPerCapita();
			resultado = true;
		}
		else {
			throw new ProvinciaException("El pueblo no puede crearse");
		}
		return resultado;
	}

	public String listadoPueblosNombre() {
		StringBuilder resul = new StringBuilder();
		for (PuebloLinked p : listadoPueblos) {
			resul.append(p.getNombre() + " ");
		}
		return resul.toString();
	}

	public String listadoPueblos() {
		StringBuilder resul = new StringBuilder();
		for (PuebloLinked p : listadoPueblos) {
			resul.append(p.toString() + " ");
		}
		return resul.toString();
	}

	public boolean delPueblo(String nombre) throws ProvinciaException {
		boolean resul = false;
		if (!existePueblo(nombre)) {
			throw new ProvinciaException("El pueblo no existe");
		}
		for (PuebloLinked p : listadoPueblos) {
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
		Iterator<PuebloLinked> iterator=listadoPueblos.iterator();
		while(iterator.hasNext()&& !resul) {
			PuebloLinked aux=iterator.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				double au=superficie-aux.getSuperficie();
				aux.setSuperficie(superficie);
				this.superficie+=au;
				resul = true;
			}
		}
		return resul;
	}

	public boolean setNumeroHabitantes(String nombre, int numHabitantes) throws PuebloException {
		boolean resul = false;
		Iterator<PuebloLinked> iterator=listadoPueblos.iterator();
		while(iterator.hasNext()&& !resul) {
			PuebloLinked aux=iterator.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				int au=numHabitantes-aux.getNumHabitantes();
				aux.setNumHabitantes(numHabitantes);
				this.numHabitantes+=au;
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
		for (PuebloLinked p : listadoPueblos) {
			if (p.getNombre().equalsIgnoreCase(pueblo)) {
				resul = p.toString();
			}
		}
		return resul;
	}

}

