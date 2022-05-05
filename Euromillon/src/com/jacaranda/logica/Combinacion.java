package com.jacaranda.logica;

import java.util.ArrayList;
import java.util.Objects;

public class Combinacion {

	// Utilizo ArrayList porque voy a necesitar que los números se guarden en orden,
	// por lo tanto no me vale un hashset
	private ArrayList<Integer> numeros;
	private ArrayList<Integer> estrellas;
	private static final int MAXIMO_NUMEROS = 50;
	private static final int MAXIMO_ESTRELLAS = 12;

	public Combinacion(int num1, int num2, int num3, int num4, int num5, int num6, int num7)
			throws CombinacionException {
		super();
		// Inicializa las collections y comprueba con el set los valores que 
		//se le pasan
		this.numeros = new ArrayList<Integer>();
		setNumero(num1);
		setNumero(num2);
		setNumero(num3);
		setNumero(num4);
		setNumero(num5);
		this.estrellas = new ArrayList<Integer>();
		setEstrella(num6);
		setEstrella(num7);
	}

	/**
	 * Recibe un numero y comprueba ques está entre los valores válidos, si es
	 * correcto lo añade y si no lanza una excepción.
	 * 
	 * @param num
	 * @throws CombinacionException
	 */
	private void setNumero(int num) throws CombinacionException {
		if (num <= 0 || num > MAXIMO_NUMEROS) {
			throw new CombinacionException("El numero no se puede añadir");
		} else {
			numeros.add(num);
		}
	}
	/**
	 * Igual que el setNumero() pero con las estrellas
	 * @param num
	 * @throws CombinacionException
	 */

	private void setEstrella(int num) throws CombinacionException {
		if (num <= 0 || num > MAXIMO_ESTRELLAS) {
			throw new CombinacionException("La estrella no es valida");
		} else {
			estrellas.add(num);
		}
	}
	
	
	/**
	 * 
	 * @return la cadena con los numéros de la combinación
	 */
	public String listaNumeros() {
		String resul = "";
		for (Integer i : numeros) {
			resul += i + "-";
		}
		return resul;

	}
	/**
	 * 
	 * @return La cadena con las estrellas
	 */
	public String listaEstrellas() {
		String resul = "";
		for (Integer i : estrellas) {
			resul += i + "-";
		}
		return resul;
	}

	/**
	 * Devuelve una cadena con los números y estrellas
	 */
	public String toString() {
		String resul = "";
		resul += listaNumeros();
		resul += " Estrellas: ";
		resul += listaEstrellas();
		return resul;
	}

	/**
	 * Comprueba el número de aciertos de una combinación que se le pasa
	 * @param c
	 * @return int
	 */
	public int compruebaAciertos(Combinacion c) {
		int resul = 0;
		//Recorro los números y le hago el indexOf() a los números de la otra 
		//combincación, si es distinto a -1 quiere decir que está en esa lista
		//y aumento mi resul
		for (Integer i : numeros) {
			if (c.numeros.indexOf(i) != -1) {
				resul += 1;
			}
		}
		for (Integer i : estrellas) {
			if (c.estrellas.indexOf(i) != -1) {
				resul += 1;
			}
		}
		return resul;
	}

	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}

}
