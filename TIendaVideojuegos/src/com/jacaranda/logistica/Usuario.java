package com.jacaranda.logistica;

import java.util.Objects;

public class Usuario {
	
	private String nombre;
	private String dni;
	private int edad;
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public int getEdad() {
		return edad;
	}
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dni, other.dni);
	}
	
	

}
