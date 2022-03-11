package com.jacaranda.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Coche extends Vehiculo {

	private TipoGasolina combustible;

	public Coche(String matricula, String tipoGama, LocalDate fechaSalida, String combustible) throws Exception {
		super(matricula, tipoGama, fechaSalida);
		this.combustible=TipoGasolina.valueOf(combustible.toUpperCase());
	}

	public String getCombustible() {
		return combustible.toString();
	}
	
	public void setCombustible(String tipoCombustible) {
		this.combustible=TipoGasolina.valueOf(tipoCombustible.toUpperCase());
	}

	@Override
	public double getPrecio() {
		return super.getPrecio()
				+combustible.getTipo()
				*this.getFechaEntrada().until(getFechaSalida(), ChronoUnit.DAYS);
		
	}
	
	@Override
	public String toString() {
		return "Coche [combustible=" + combustible + ", toString()=" + super.toString() + "]";
	}
	
	

	
}
