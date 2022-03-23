package com.jacaranda.libros;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Libro {

	private String titulo;
	private String autor;
	private String editorial;
	private LocalDate fechaEdicion;
	private String ISBN;
	private int codigo;
	private static int codSiguiente = 1;

	public Libro(String titulo, String autor, String editorial) throws Exception {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaEdicion = LocalDate.now();
		this.ISBN = generaISBN();
		this.codigo = codSiguiente;
		codSiguiente++;
	}

	public Libro(String titulo, String autor) throws Exception {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.fechaEdicion = LocalDate.now();
		this.ISBN = generaISBN();
		this.codigo = codSiguiente;
		codSiguiente++;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public LocalDate getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(LocalDate fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getCodigo() {
		return codigo;
	}

	private String generaISBN() throws Exception {
		if (titulo.length() < 3 || titulo.length() < 3) {
			throw new Exception("No se puede crear autor con esa longitud");
		}
		StringBuilder resul = new StringBuilder();
		String auxTitulo = titulo.toUpperCase();
		auxTitulo.replaceAll("\\s+", "");
		String auxAutor = autor.toUpperCase();
		auxAutor.replaceAll("\\s+", "");
		resul.append(auxTitulo.substring(0, 4));
		resul.append(auxTitulo.length());
		resul.append(auxAutor.substring(auxAutor.length() - 3));
		resul.append(auxAutor.length());
		return resul.toString();
	}

	public int diferenciaFecha(Libro l1) throws Exception {
		if(l1==null) {
			throw new Exception("Libro no válido");
		}
		int resul;
		LocalDate fechaAnterior, fechaPosterior;
		if (this.fechaEdicion.isBefore(l1.fechaEdicion)) {
			fechaAnterior = this.fechaEdicion;
			fechaPosterior = l1.fechaEdicion;
		} else {
			fechaAnterior = l1.fechaEdicion;
			fechaPosterior = this.fechaEdicion;
		}
		resul = (int) fechaAnterior.until(fechaPosterior, ChronoUnit.DAYS);
		return resul;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(ISBN, other.ISBN);
	}

	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder("Libro: " + this.titulo + ". Autor: " + this.autor + ". ISBN: "
				+ this.ISBN + ". Codigo: " + this.codigo);
		return resul.toString();
	}

}
