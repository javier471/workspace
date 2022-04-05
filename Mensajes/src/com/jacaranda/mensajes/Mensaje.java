package com.jacaranda.mensajes;

import java.time.LocalDateTime;
import java.util.Objects;

public class Mensaje {

	private String mensaje;
	private LocalDateTime fecha;
	private String remitente;
	private String destinatario;
	private int numMensaje;
	private static int siguiente = 1;

	public Mensaje(String remitente,String destinatario, String mensaje) {
		super();
		this.mensaje = mensaje;
		this.fecha = LocalDateTime.now();
		this.remitente = remitente;
		this.numMensaje = siguiente;
		siguiente++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numMensaje);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return numMensaje == other.numMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getRemitente() {
		return remitente;
	}

	public int getNumMensaje() {
		return numMensaje;
	}

	public static int getSiguiente() {
		return siguiente;
	}

	
}
