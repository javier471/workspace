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

	public Mensaje(String remitente, String destinatario, String mensaje) {
		super();
		this.mensaje = mensaje;
		this.fecha = LocalDateTime.now();
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.numMensaje = siguiente;
		siguiente++;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) throws MensajeException {
		if (mensaje == null) {
			throw new MensajeException("Mensaje no válido");
		}
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

	public String getDestinatario() {
		return destinatario;
	}

	public void setRemitente(String remitente) throws MensajeException {
		if (remitente == null) {
			throw new MensajeException("Remitente no válido");
		}
		this.remitente = remitente;
	}

	@Override
	public String toString() {
		return "Numero mensaje " + numMensaje + ":" + "De: " + remitente + " Mensaje: " + mensaje + ", Fecha y hora"
				+ fecha;
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

	public int compareTo(Mensaje m1) throws MensajeException {
		int resul = 0;
		if (m1 == null) {
			throw new MensajeException("Mensaje no válido");
		}
		resul = this.remitente.compareToIgnoreCase(m1.getRemitente());
		return resul;
	}

}
