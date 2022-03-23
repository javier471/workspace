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
		if(l1==null) {
			throw new Exception("Libro no valido");
		}
		boolean resul=false;
		if(this.getPrecio()>l1.getPrecio()) {
			resul=true;
		}
		return resul;
	}

	@Override
	public String toString() {
		String resul=super.toString();
		resul+="Precio: "+this.precio+" Formato.: "+this.getFormatoLibro();
		return resul;
	}
	
	
	
	
	

}
