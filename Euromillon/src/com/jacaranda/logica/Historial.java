package com.jacaranda.logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Historial {

	private HashMap<LocalDate, Combinacion> ganadoras;

	public Historial() {
		super();
		ganadoras = new HashMap<>();
	}

	/**
	 * Devuelve true si se a�ade el sorteo o false si no lo ha a�adido
	 * 
	 * @param fecha
	 * @param c
	 * @return boolean
	 */
	public boolean addSorteo(LocalDate fecha, Combinacion c) {
		boolean resul = false;
		// Si devuelve false quiere decir que no contiene la fecha, por lo tanto
		// se puede a�adir el sorteo. Si devolviera true significa que la fecha
		// ya est� y por lo tanto no a�ado el sorteo
		if (!(ganadoras.containsKey(fecha))) {
			ganadoras.put(fecha, c);
			resul = true;
		}
		return resul;
	}

	/**
	 * Devuelve true si puede actualizar el sorteo y false si no ha podido
	 * 
	 * @param fecha
	 * @param c
	 * @return boolean
	 */
	public boolean updateSorteo(LocalDate fecha, Combinacion c) {
		boolean resul = false;
		// Si devuelve true quiere decir que el HashMap lo contiene
		// y entonces cambia por la combicaci�n del par�metro
		if (ganadoras.containsKey(fecha)) {
			ganadoras.replace(fecha, c);
			resul = true;
		}
		return resul;
	}

	/**
	 * Devuelve true si ha podido borrar el sorteo y false si no lo pudo borrar
	 * 
	 * @param fecha
	 * @param c
	 * @return boolean
	 */
	public boolean borrarSorteo(LocalDate fecha, Combinacion c) {
		boolean resul = false;
		// Si entra quiere decir que esa fecha existe y entonces al borrar
		// la key se borra tambi�n su valor
		if (ganadoras.containsKey(fecha)) {
			ganadoras.remove(fecha);
			resul = true;
		}
		return resul;
	}

	/**
	 * Comprueba los aciertos de una combicaci�n en una fecha en espec�fico y
	 * devuelve el n�mero de aciertos
	 * 
	 * @param fecha
	 * @param c
	 * @return
	 */
	public int compruebaFecha(LocalDate fecha, Combinacion c) {
		int resul;
		// Si no existe la fecha en el HashMap directamente devuelve -1
		if (!(ganadoras.containsKey(fecha))) {
			resul = -1;
		}
		// Creo una combinaci�n auxiliar con la combinaci�n que hay en esa fecha
		// que me hace falta para usar el m�todo
		Combinacion aux = ganadoras.get(fecha);
		// A la combinaci�n auxiliar le hago el m�todo y devuelvo
		resul = aux.compruebaAciertos(c);
		return resul;
	}

	/**
	 * Devuelve una cadena con los sorteos de forma ascendente (de m�s antiguas a
	 * m�s nuevas)
	 * 
	 * @return String
	 */
	public String toStringAscendente() {
		StringBuilder resul = new StringBuilder();
		// Convierto las fechas en un arrayList para poder ordenarlas
		ArrayList<LocalDate> claves = new ArrayList<>(ganadoras.keySet());
		// Como las fechas tienen su m�todo ordenador de por s�, hago el sort
		Collections.sort(claves);
		// Con las fechas ordenadas, hago un for para sumarlas a la cadena
		for (LocalDate fecha : claves) {
			resul.append("Fecha: " + ganadoras.get(fecha).toString() + "\n");
		}
		return resul.toString();
	}

	/**
	 * Devuelve los sorteos de forma descendentes (m�s viejos primero)
	 * 
	 * @return String
	 */
	public String toStringDescendente() {
		StringBuilder resul = new StringBuilder();
		// Convierto en un arrayList las keys del HashMap para ordenarlas
		ArrayList<LocalDate> claves = new ArrayList<>(ganadoras.keySet());
		// Necesito crear una clase para ordenarlas y hacer un objeto de esta.
		// La clase extiende de comparator y necesita un compareTo() que decida
		// por qu� se va a ordenar la clase
		ComprobadorDescendente d = new ComprobadorDescendente();
		// Se le pasa al sort la collection que tiene que ordenar y el objeto de
		// la clase que se ha creado para ordenar
		Collections.sort(claves, d);
		// Una vez ordenada se imprime
		for (LocalDate fecha : claves) {
			resul.append("Fecha: " + ganadoras.get(fecha).toString() + "\n");
		}
		return resul.toString();
	}

	/**
	 * Devuelve los sorteos que se han hecho en un mes en espec�fico
	 * @param mes
	 * @return String
	 */
	public String sorteoMes(int mes) {
		StringBuilder resul = new StringBuilder();
		//Se convierte las fechas a un arraylist
		ArrayList<LocalDate> claves = new ArrayList<>(ganadoras.keySet());
		Collections.sort(claves);
		//Una vez tenemos la collection ordenada hace falta un iterator
		Iterator<LocalDate> siguiente = claves.iterator();
		boolean encontrado = false;
		while (siguiente.hasNext() && !encontrado) {
			//Objeto aux que va a tener el valor del iterator en esa vuelta
			LocalDate fecha = siguiente.next();
			//Si el mes es igual al que se pasa por par�metro, a�ade ese sorteo
			if (fecha.getMonthValue() == mes) {
				resul.append("Fecha: " + ganadoras.get(fecha).toString() + "\n");
			//Cuando el mes del iterator sea mayor al del par�metro se cambia 
			//la bandera para que no siga buscando
			} else if (fecha.getMonthValue() > mes) {
				encontrado = true;
			}
		}
		return resul.toString();
	}

	@Override
	public String toString() {
		return ganadoras.toString();
	}

}
