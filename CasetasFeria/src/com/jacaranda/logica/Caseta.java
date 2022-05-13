package com.jacaranda.logica;

public class Caseta {
	private String titulo;
	private Calle calle;
	private int numero;
	private int numModulos;
	private String clase;
	private int id_caseta;
	private int id_calle;

	public Caseta(String titulo, Calle calle, int numero, int numModulos, String clase, int id_caseta) {
		super();
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.numModulos = numModulos;
		this.clase = clase;
		this.id_caseta = id_caseta;
		this.id_calle=calle.getId_calle();
	}

	public String getTitulo() {
		return titulo;
	}

	public Calle getCalle() {
		return calle;
	}

	public int getNumero() {
		return numero;
	}

	public int getNumModulos() {
		return numModulos;
	}

	public String getClase() {
		return clase;
	}

	public int getId_caseta() {
		return id_caseta;
	}

	public int getId_calle() {
		return id_calle;
	}

	@Override
	public String toString() {
		return "Caseta [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", numModulos=" + numModulos
				+ ", clase=" + clase + ", id_caseta=" + id_caseta + ", id_calle=" + id_calle + "]";
	}
	
	

}
