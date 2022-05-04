package com.jacaranda.logica;

import java.util.ArrayList;
import java.util.Objects;

public class Combinacion {

	// Utilizo ArrayList porque voy a necesitar que los números se guarden en orden,
	// por lo tanto no me vale un hashset
	private ArrayList<Integer> numeros;
	private ArrayList<Integer> estrellas;

	public Combinacion(int num1, int num2, int num3, int num4, int num5, int num6, int num7)
			throws CombinacionException {
		super();
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

	private void setNumero(int num) throws CombinacionException {
		if (num <= 0 || num > 50) {
			throw new CombinacionException("El numero no se puede añadir");
		} else {
			numeros.add(num);
		}
	}

	private void setEstrella(int num) throws CombinacionException {
		if (num <= 0 || num > 12) {
			throw new CombinacionException("La estrella no es valida");
		} else {
			estrellas.add(num);
		}
	}

	public String listaNumeros() {
		String resul = "";
		for (Integer i : numeros) {
			resul += i + "-";
		}
		return resul;

	}

	public String listaEstrellas() {
		String resul = "";
		for (Integer i : estrellas) {
			resul += i + "-";
		}
		return resul;
	}

	public String toString() {
		String resul = "";
		resul += listaNumeros();
		resul += " Estrellas: ";
		resul += listaEstrellas();
		return resul;
	}

	public int compruebaAciertos(Combinacion c) {
		int resul = 0;
		// Seria más eficiente con while e Iterator
		for (Integer i : numeros) {
			boolean encontrado = false;
			for (Integer j : c.numeros) {
				if (i.equals(j) && !encontrado) {
					encontrado = true;
					resul += 1;
				}
			}
		}
		for (Integer i : estrellas) {
			boolean flag = false;
			for (Integer j : c.estrellas) {
				if (i.equals(j) && !flag) {
					flag = true;
					resul += 1;
				}
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
