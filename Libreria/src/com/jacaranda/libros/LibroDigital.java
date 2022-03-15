package com.jacaranda.libros;

public class LibroDigital extends Libro{
	
	private double precio;
	private Formato formatoLibro;

	public LibroDigital(String titulo, String autor,double precio,String formatoLibro) throws Exception {
		super(titulo, autor);
		this.precio=precio;
		this.formatoLibro=Formato.valueOf(formatoLibro.toUpperCase());
		
	}

	public LibroDigital(String titulo, String autor, String editorial,double precio, String formatoLibro) throws Exception {
		super(titulo, autor, editorial);
		this.precio=precio;
		this.formatoLibro=Formato.valueOf(formatoLibro.toUpperCase());
	}

	public double getPrecio() {
		return precio;
	}

	public String getFormatoLibro() {
		return formatoLibro.toString();
	}

	public boolean masCaro(LibroDigital l1) throws Exception {
		//Como no se deja muy claro devuelvo true si el precio de this es mayor
		boolean resul=false;
		if(this.getPrecio()>l1.getPrecio()) {
			resul=true;
		}
		return resul;
	}

	@Override
	public String toString() {
		StringBuilder resul=new StringBuilder("Libro: "+this.getTitulo()+". Autor: "+this.getAutor()+". ISBN: "+this.getISBN()+" .Código: "+this.getCodigo()+" .Precio: "+this.getPrecio()+" Formato: "+this.getFormatoLibro());
		return resul.toString();
	}
	
	
	
	
	

}
