package com.jacaranda.logistica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
		this.reservas = new HashMap<>();
	}

	// Metodo privado que devuelve true si el videojuego ya est? en el stock y false
	// si no est?
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

	// A?ade el usuario y delvuelve true o devuelve false si ya estaba
	public boolean addUsuario(Usuario u1) {
		return clientes.add(u1);
	}

	// Si devuelve false es que el juego ya existe en el stock y no lo puede a?adir
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

	// Devuelve verdadero si existe el juego a reservar, si el usuario es mayor de
	// edad y est? en la lista de clientes
	public boolean reservar(Videojuego j1, Usuario u1) throws TiendaException {
		if (j1 == null || reservas.containsValue(j1) || reservas.containsKey(u1)) {
			throw new TiendaException("No se puede hacer la reserva");
		}
		boolean resul = false;
		if (existeJuego(j1) && u1.getEdad() >= 18 && clientes.contains(u1)) {
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

	public String mostrarReservas() {
		return reservas.toString();
	}

	public String addNewGen(String nombre, Double precio, String genero, int valoracion, LocalDate fecha, Connection c)
			throws SQLException {
		String resul = "";
		Statement insert = (Statement) c.createStatement();
		String cadena = "INSERT INTO NEWGEN VALUES('" + nombre + "','" + precio + "','" + genero + "','" + valoracion
				+ "','" + fecha + "');";

		if (insert.executeUpdate(cadena) == 0) {
			resul = "Se produjo un error";
		} else {
			resul = "Operacion exitosa";
		}
		return resul;
	}

	public String addOldGen(String nombre, Double precio, String genero, String formato, Double precioDia, Connection c)
			throws SQLException {
		String resul = "";
		Statement insert = (Statement) c.createStatement();
		String cadena = "INSERT INTO NEWGEN VALUES('" + nombre + "','" + precio + "','" + genero + "','" + formato
				+ "','" + precioDia + "');";

		if (insert.executeUpdate(cadena) == 0) {
			resul = "Se produjo un error";
		} else {
			resul = "Operacion exitosa";
		}
		return resul;
	}

	public String addUserBD(String nombre, String dni, int edad, Connection c) throws SQLException {

		String resul = "";
		Statement insert = (Statement) c.createStatement();
		String cadena = "INSERT INTO USUARIO VALUES('" + nombre + "','" + dni + "','" + edad + "','" + getNombre()
				+ "');";

		if (insert.executeUpdate(cadena) == 0) {
			resul = "Se produjo un error";
		} else {
			resul = "Operacion exitosa";
		}
		return resul;

	}

	public String delUser(String nombre, Connection c) throws SQLException {
		String resul = "";
		Statement insert = (Statement) c.createStatement();
		String cadena = "DELETE FROM USUARIO WHERE NOMBRE='" + nombre + "';";

		if (insert.executeUpdate(cadena) == 0) {
			resul = "Se produjo un error";
		} else {
			resul = "Operacion exitosa";
		}
		return resul;
	}

	public String updateUser(String DNI, String nombre, int edad, Connection c) throws SQLException {
		StringBuilder resul = new StringBuilder();
		Statement insert = (Statement) c.createStatement();
		String cadena = "UPDATE USUARIO SET NOMBRE='" + nombre + "', EDAD='" + edad + "' WHERE DNI='" + DNI + "';";

		if(insert.executeUpdate(cadena)==0) {
			resul.append("Se produjo un error");
		}
		else {
			resul.append("Operacion exitosa");
		}
		return resul.toString();
	}

	public String buscaUser(String nombre, Connection c) throws SQLException {
		StringBuilder resul = new StringBuilder();
		Statement insert = (Statement) c.createStatement();
		String cadena = "SELECT * FROM USUARIO WHERE NOMBRE='" + nombre + "';";

		ResultSet r=insert.executeQuery(cadena);
		while(r.next()) {
			resul.append(r.getString("NOMBRE")+" "+r.getString("DNI")+" "+r.getInt("EDAD")+" "+r.getString("NOMBRE_TIENDA")+"\n");
		}
		
		return resul.toString();
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
