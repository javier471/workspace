package com.jacaranda.usuarios;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.jacaranda.mensajes.Mensaje;

public class Persona {

	private String nombre;
	private int edad;
	private String DNI;
	protected List<Mensaje> recibidos;
	protected List<Mensaje> enviados;

	public Persona(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = dni;
		this.recibidos = new LinkedList<>();
		this.enviados = new LinkedList<>();
	}

	public int getEdad() {
		return edad;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean sendMensaje(Persona p, String texto) throws PersonaException, AlumnoException, ProfesorException {
		boolean resul = false;
		if (p == null || texto == null) {
			throw new PersonaException("No se puede enviar el mensaje");
		}
		Mensaje aux = new Mensaje(this.nombre, p.nombre, texto);
		this.enviados.add(aux);
		p.recibidos.add(aux);
		resul = true;
		return resul;
	}

	public String leerMensajesRecibidos() throws PersonaException {
		if (recibidos.isEmpty()) {
			throw new PersonaException("Lista de mensajes vacia");
		}
		return recibidos.toString();
	}

	public String leerMensajesEnviados() throws PersonaException {
		if (enviados.isEmpty()) {
			throw new PersonaException("Lista de mensajes vacio");
		}
		return enviados.toString();
	}

	public boolean delMensajeRecibido(int numMensaje) {
		boolean resul = false;
		boolean encontrado = false;
		Iterator<Mensaje> siguiente = recibidos.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1 = siguiente.next();
			if (m1.getNumMensaje() == numMensaje) {
				recibidos.remove(m1);
				encontrado = true;
			}
		}
		return resul;
	}

	public boolean delMensajeEnviado(int numMensaje) {
		boolean resul = false;
		boolean encontrado = false;
		Iterator<Mensaje> siguiente = recibidos.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Mensaje m1 = siguiente.next();
			if (m1.getNumMensaje() == numMensaje) {
				recibidos.remove(m1);
				encontrado = true;
			}
		}
		return resul;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", DNI=" + DNI + ", recibidos=" + recibidos.toString()
				+ ", enviados=" + enviados.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(DNI, edad, enviados, nombre, recibidos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI) && edad == other.edad && Objects.equals(enviados, other.enviados)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(recibidos, other.recibidos);
	}

}
