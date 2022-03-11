package com.jacaranda.vehiculos;

import java.time.LocalDate;

public class Microbus extends Vehiculo{
	
	private int numPlazas;

	public Microbus(String matricula, String tipoGama, LocalDate fechaSalida, int numPlazas) throws Exception {
		super(matricula, tipoGama, fechaSalida);
		this.numPlazas=numPlazas;
	}

	public int getNumPlazas() {
		return numPlazas;
	}
	
	@Override
	public double getPrecio() {
		return super.getPrecio()+
		(numPlazas*5);
	}

	@Override
	public String toString() {
		return "Microbus [numPlazas=" + numPlazas + ", toString()=" + super.toString() + "]";
	}
	
	

	
	

}
