package com.jacaranda.logistica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

import com.jacaranda.videojuegos.Videojuego;

public class Tienda {

	private String nombre;
	private String direccion;
	private Set<Videojuego> stock;
	private Set<Usuario> clientes;
	private HashMap<Usuario, Videojuego> reservas;

	public Tienda(String nombre, String direccion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.stock = new HashSet<Videojuego>();
		this.clientes = new HashSet<Usuario>();
	}

	// Metodo privado que devuelve true si el videojuego ya está en el stock y false
	// si no está
	private boolean existeJuego(Videojuego j1) throws TiendaException {
		if (j1 == null) {
			throw new TiendaException("Juego no valido");
		}
		return stock.contains(j1);
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	// Si devuelve false es que el juego ya existe en el stock y no lo puede añadir
	public boolean addJuego(Videojuego j1) throws TiendaException {
		if (j1 == null) {
			throw new TiendaException("Juego no valido");
		}
		boolean resul = false;
		if (!existeJuego(j1)) {
			stock.add(j1);
			resul = true;
		}
		return resul;
	}

	// Devuelve true si el juego existe y lo ha borrado y false si no existe el
	// juego que se quiere borrar
	public boolean delJuego(Videojuego j1) throws TiendaException {
		if (j1 == null) {
			throw new TiendaException("Juego no valido");
		}
		boolean resul = false;
		if (existeJuego(j1)) {
			stock.remove(j1);
			resul = true;
		}
		return resul;
	}

	// Se le pasa el nombre de un juego y devuelve su toString()
	public String buscarJuego(String nombre) {
		String resul = "Juego no encontrado";
		Iterator<Videojuego> siguiente = stock.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			Videojuego aux = siguiente.next();
			if (aux.getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
				resul = aux.toString();
			}
		}
		return resul;
	}

	// Devuelve verdadero si existe el juego a reservar y si el usuario es mayor de
	// edad
	public boolean reservar(Videojuego j1, Usuario u1) throws TiendaException {
		if (j1 == null || reservas.containsValue(j1) || reservas.containsKey(u1)) {
			throw new TiendaException("No se puede hacer la reserva");
		}
		boolean resul = false;
		if (existeJuego(j1) && u1.getEdad() >= 18) {
			resul = true;
			reservas.put(u1, j1);
		}
		return resul;
	}

	public boolean liberarJuego(Videojuego v1, Usuario u1) throws TiendaException {
		boolean resul = false;
		if (!reservas.containsKey(u1) || !reservas.containsValue(v1)) {
			throw new TiendaException("El juego no existe");
		}
		// Hay algo que compruebe si un valor pertenece a una clave?
		for (Usuario u : reservas.keySet()) {
			Videojuego aux = reservas.get(u);
			if (aux.equals(v1)) {
				reservas.remove(u1, v1);
				resul = true;
			}
		}

		return resul;
	}

	public String mostrarStock() {
		return stock.toString();
	}

	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", direccion=" + direccion + ", stock=" + stock + ", clientes=" + clientes
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tienda other = (Tienda) obj;
		return Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre);
	}

}
