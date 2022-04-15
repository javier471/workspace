package com.jacaranda.videojuegos;

import java.time.LocalDate;

public class NewGen extends Videojuego {

	private int valoracion;
	private LocalDate fechaSalida;

	public NewGen(String nombre, double precio, String genero, int valoracion, LocalDate fechaSalida) {
		super(nombre, precio, genero);
		this.valoracion = valoracion;
		this.fechaSalida = fechaSalida;
	}

	// Aplica de impuesto el porcentaje que recibe más 1.5 por estrella de
	// valoracion
	@Override
	public boolean impuestoVideojuego(double porcentaje) throws VideojuegoException {
		if (porcentaje < 0) {
			throw new VideojuegoException("Error en la operación");
		}
		double subida = (super.getPrecio() * porcentaje) / 100;
		double estrellas = valoracion * 1.5;
		super.setPrecio(super.getPrecio() + subida + estrellas);
		return true;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String resul = super.toString() + "Valoracion: " + valoracion + " .Fecha de salida: " + fechaSalida;
		return resul;
	}

}
