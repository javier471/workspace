package com.jacaranda.tamano;

public class Datos {

	private int ano;
	private int dato;

	public Datos(int ano, int dato) {
		super();
		this.ano = ano;
		this.dato = dato;
	}

	public int getAno() {
		return ano;
	}

	public int getDato() {
		return dato;
	}

	@Override
	public String toString() {
		return "Datos [ano=" + ano + ", dato=" + dato + "]";
	}

}
