package com.jacaranda.vehiculos;

public enum Gama {

	BAJA(30), MEDIA(40), ALTA(50);

	private int precio;

	Gama(int p) {
		this.precio = p;
	}

	public int getPrecio() {
		return precio;
	}
	
}
