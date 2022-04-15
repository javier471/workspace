package com.jacaranda.videojuegos;

public class OldGen extends Videojuego {

	private String formato;
	private boolean alquilado;
	private double precioPorDia;

	public OldGen(String nombre, double precio, String genero, String formato, double precioPorDia) {
		super(nombre, precio, genero);
		this.formato = formato;
		this.precioPorDia = precioPorDia;
		this.alquilado = false;
		// TODO Auto-generated constructor stub
	}

	// Suma un impuesto al PVP, se le pasa un porcentaje que no puede ser negativo
	// ni superior al precio original
	@Override
	public boolean impuestoVideojuego(double porcentaje) throws VideojuegoException {
		if (porcentaje < 0 || porcentaje >= 100) {
			throw new VideojuegoException("No se puede aplicar ese porcentaje");
		}
		double subida = (super.getPrecio() * porcentaje) / 100;
		super.setPrecio(super.getPrecio() + subida);
		return true;

	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public double getPrecioPorDia() {
		return precioPorDia;
	}

	public void setPrecioPorDia(double precioPorDia) {
		this.precioPorDia = precioPorDia;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	/*
	 * ALquila X días el juego,devuelve el precio del alquiler que se obtiene de
	 * multiplicar los días por el precio que tenga ese juego. Si ya está alquilado
	 * o no pasa días válidos lanza exception
	 */
	public double alquila(int dias) throws VideojuegoException {
		if (alquilado || dias <= 0) {
			throw new VideojuegoException("Error en la operación");
		}
		double resul = dias * precioPorDia;
		alquilado = true;
		return resul;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String resul = super.toString() + " Alquilado:" + alquilado + " .Formato:" + formato + " .Precio por día:"
				+ precioPorDia;
		return resul;
	}

}
