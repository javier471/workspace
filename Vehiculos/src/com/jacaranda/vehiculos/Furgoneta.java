package com.jacaranda.vehiculos;

import java.time.LocalDate;

public class Furgoneta extends Vehiculo {

	private static final double PRECIOPESO = 0.5;
	private double peso;

	public Furgoneta(String matricula, String tipoGama, LocalDate fechaSalida,double peso) throws Exception {
		super(matricula, tipoGama, fechaSalida);
		this.peso=peso;
	}

	public double getPeso() {
		return peso;
	}

	public double getPrecio(){
		return super.getPrecio()+(peso*PRECIOPESO);
	}

	@Override
	public String toString() {
		return "Furgoneta [peso=" + peso + ", toString()=" + super.toString() + "]";
	}
	
	
}
