package com.jacaranda.logica;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;

public class Historial {

	private HashMap<LocalDate, Combinacion> ganadoras;

	public Historial() {
		super();
		ganadoras = new HashMap<>();
	}

	public boolean addSorteo(LocalDate fecha, Combinacion c) {
		boolean resul = true;
		Iterator<LocalDate> siguiente = ganadoras.keySet().iterator();
		while (siguiente.hasNext() && resul) {
			if ((fecha.equals(siguiente.next()))) {
				resul = false;
			}
		}
		if (resul) {
			ganadoras.put(fecha, c);
		}
		return resul;
	}

	public boolean actualizaSorteo(LocalDate fecha, Combinacion c) {
		boolean resul = false;
		Iterator<LocalDate> siguiente = ganadoras.keySet().iterator();
		while (siguiente.hasNext() && !resul) {
			if (siguiente.next().equals(fecha)) {
				ganadoras.replace(fecha, c);
				resul = true;
			}
		}
		return resul;
	}

	public boolean borrarSorteo(LocalDate fecha) {
		boolean resul = false;
		Iterator<LocalDate> siguiente = ganadoras.keySet().iterator();
		while (siguiente.hasNext() && !resul) {
			if (siguiente.next().equals(fecha)) {
				ganadoras.remove(fecha);
				resul = true;
			}
		}
		return resul;

	}

	public int compruebaFecha(LocalDate fecha, Combinacion c) {
		int resul;
		if (!(ganadoras.containsKey(fecha))) {
			resul = -1;
		}
		Combinacion aux=ganadoras.get(fecha);
		resul=aux.compruebaAciertos(c);
		return resul;
	}
	
	public String toStringAscendente() {
		String resul="";
		for(LocalDate d:ganadoras.keySet()) {
			
		}
		return resul;
	}
	
	public String toStringDescendente() {
		String resul="";
		for(LocalDate d:ganadoras.keySet()) {
			
		}
		return resul;
	}
	
	public String sorteoMes(int mes) {
		String resul="";
		
		
		return resul;
	}

	@Override
	public String toString() {
		return ganadoras.toString();
	}

}
