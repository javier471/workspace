package com.jacaranda.logica;

import java.util.Objects;

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

	public String getCalle() {
		return calle.getNombre();
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

	@Override
	public int hashCode() {
		return Objects.hash(id_caseta, numero, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caseta other = (Caseta) obj;
		return id_caseta == other.id_caseta && numero == other.numero && Objects.equals(titulo, other.titulo);
	}

	
	

}
