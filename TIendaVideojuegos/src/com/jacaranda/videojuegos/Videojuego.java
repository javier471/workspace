package com.jacaranda.videojuegos;

import java.util.Objects;

public abstract class Videojuego {

	private String nombre;
	private double precio;
	private String genero;

	public Videojuego(String nombre, double precio, String genero) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public abstract boolean impuestoVideojuego(double porcentaje) throws VideojuegoException;

	//Se comparan por el precio
	public int CompareTo(Videojuego v1) {
		int resul=0;
		if(precio<v1.getPrecio()) {
			resul=-1;
		}
		else {
			resul=1;
		}
		return resul;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	// Determino que un juego será igual a otro por su nombre
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Nombre:" + nombre + " .Genero:" + genero + " .Precio:" + precio + ".";
	}

}
