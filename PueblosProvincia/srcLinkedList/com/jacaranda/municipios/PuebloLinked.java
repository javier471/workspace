package com.jacaranda.municipios;

import java.util.Objects;

public class PuebloLinked {

	private String nombre;
	private String codigo;
	private int numHabitantes;
	private double rentaPerCapita;
	private double superficie;

	public PuebloLinked(String nombre, String codigo, int numHabitantes, double rentaPerCapita, double superficie) throws PuebloException {
		super();
		if(numHabitantes<0|| rentaPerCapita<0|| superficie<0) {
			throw new PuebloException("Datos no validos");
		}
		this.nombre = nombre.toUpperCase();
		setCodigo(codigo);
		setNumHabitantes(numHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	public PuebloLinked(String nombre, String codigo) throws PuebloException {
		super();
		this.nombre = nombre;
		setCodigo(codigo);
		setNumHabitantes(numHabitantes);
		setRentaPerCapita(rentaPerCapita);
		setSuperficie(superficie);
	}

	private void setCodigo(String codigo) throws PuebloException {
		if(codigo.length()!=5 || !(codigo.chars().allMatch(Character::isDigit))) {
			throw new PuebloException("Codigo no valido");
		}
		this.codigo = codigo;
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getCodigo() {
		return codigo;
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

	public void setNumHabitantes(int numHabitantes) throws PuebloException {
		if(numHabitantes<0) {
			throw new PuebloException("Numero de habitantes no valido");
		}
		this.numHabitantes = numHabitantes;
	}

	public void setRentaPerCapita(double rentaPerCapita) throws PuebloException {
		if(rentaPerCapita<0) {
			throw new PuebloException("Renta no valida");
		}
		this.rentaPerCapita = rentaPerCapita;
	}

	public void setSuperficie(double superficie) throws PuebloException {
		if(superficie<0) {
			throw new PuebloException("Superficie no valida");
		}
		this.superficie = superficie;
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
		PuebloLinked other = (PuebloLinked) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int compareTo(PuebloLinked p1) {
		return this.nombre.compareTo(p1.nombre);
	}

	@Override
	public String toString() {
		return "Pueblo [nombre=" + nombre + ", codigo=" + codigo + ", numHabitantes=" + numHabitantes
				+ ", rentaPerCapita=" + rentaPerCapita + ", superficie=" + superficie + "]";
	}
	
	
}

