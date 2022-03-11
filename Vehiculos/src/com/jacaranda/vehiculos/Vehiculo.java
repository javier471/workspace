package com.jacaranda.vehiculos;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Vehiculo {

	private String matricula;
	protected Gama tipoGama;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;

	public Vehiculo(String matricula, String tipoGama, LocalDate fechaSalida) throws Exception {
		super();
		this.matricula = matricula;
		this.tipoGama = Gama.valueOf(tipoGama.toUpperCase());
		this.fechaEntrada = LocalDate.now();
		if (fechaSalida.isBefore(fechaEntrada)) {
			throw new Exception("Fecha no válida");
		}
		this.fechaSalida = fechaSalida;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getTipoGama() {
		return tipoGama.toString();
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public double getPrecio() {
		if (fechaSalida == null) {
			fechaSalida = LocalDate.now();
		}
		double resul = tipoGama.getPrecio() * (int) fechaEntrada.until(fechaSalida, ChronoUnit.DAYS);
		return resul;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", tipoGama=" + tipoGama + ", fechaEntrada=" + fechaEntrada
				+ ", fechaSalida=" + fechaSalida + "]";
	}

}
