package com.jacaranda.paginas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class Historial {

	private String nombre;
	private LinkedList<PaginaWeb> lista;

	public Historial(String nombre) {
		super();
		this.nombre = nombre;
		this.lista = new LinkedList<PaginaWeb>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getLista() {
		return lista.toString();
	}

	private boolean existePagina(PaginaWeb p1) throws HistorialException {
		boolean resul=false;
		if(p1==null) {
			throw new HistorialException("Pagina no valida");
		}
		int pos=lista.indexOf(p1);
		if(pos!=-1) {
			resul=true;
		}
		return resul;
		
	}
	
	public boolean addPagina(PaginaWeb p1) throws HistorialException {
		boolean resul = false;
		if (lista.isEmpty()) {
			lista.add(p1);
		} else if (lista.getLast().getFecha().isAfter(p1.getFecha())) {
			throw new HistorialException("No se puede añadir");
		} else {
			lista.add(p1);
			resul = true;
		}
		return resul;

	}

	public boolean addPagina(String nombre) throws HistorialException {
		boolean resul = false;
		PaginaWeb aux = new PaginaWeb(nombre, LocalDateTime.now());
		if (lista.isEmpty()) {
			lista.add(aux);
		} else if (lista.getLast().getFecha().isAfter(aux.getFecha())) {
			throw new HistorialException("No se puede añadir");
		} else {
			lista.add(aux);
			resul = true;

		}
		return resul;

	}

	public String historialCompleto() {
		StringBuilder resul = new StringBuilder();
		for (PaginaWeb p : lista) {
			resul.append(p.toString() + "\n");
		}
		return resul.toString();
	}

	public String historialDia(LocalDate fecha) {
		StringBuilder resul = new StringBuilder();
		boolean flag=false;
		Iterator <PaginaWeb> siguiente=lista.iterator();
		while(siguiente.hasNext()&& !flag) {
			PaginaWeb aux=siguiente.next();
			if(aux.getFecha().toLocalDate().isAfter(fecha)) {
				flag=true;
			}
			if (aux.getFecha().toLocalDate().equals(fecha)) {
				resul.append(aux.toString() + "\n");
			}
		}
		return resul.toString();
	}

	public void borrarHistorial() {
		lista.clear();;
	}

	@Override
	public String toString() {
		return "Historial nombre=" + nombre + ", historialCompleto()=" + historialCompleto();
	}

}
