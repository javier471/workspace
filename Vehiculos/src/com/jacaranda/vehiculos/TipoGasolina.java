package com.jacaranda.vehiculos;

public enum TipoGasolina {

	GASOLINA(3.5),DIESEL(2);
	
	private double tipo;

	private TipoGasolina(double tipo) {
		this.tipo = tipo;
	}

	public double getTipo() {
		return tipo;
	}
	
	
	
	
}
