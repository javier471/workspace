package com.jacaranda.main;

import java.time.LocalDate;

import com.jacaranda.logica.Combinacion;
import com.jacaranda.logica.CombinacionException;
import com.jacaranda.logica.Historial;

public class Main {

	public static void main(String[] args) throws CombinacionException {
		// TODO Auto-generated method stub

		Combinacion c1 = new Combinacion(2, 3, 4, 7, 6, 2, 4);
		Combinacion c2 = new Combinacion(2,11, 11, 11, 29, 5, 8);
		Historial h1 = new Historial();
		System.out.println(c1.compruebaAciertos(c2));
	}

}
