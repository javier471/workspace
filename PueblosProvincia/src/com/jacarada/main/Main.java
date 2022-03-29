package com.jacarada.main;

import java.util.Scanner;

import com.jacaranda.municipios.Provincia;
import com.jacaranda.municipios.ProvinciaException;
import com.jacaranda.municipios.Pueblo;
import com.jacaranda.municipios.PuebloException;

public class Main {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws ProvinciaException, PuebloException {
		// TODO Auto-generated method stub
		Provincia sevilla = new Provincia("Sevilla", "41");
		sevilla.addPueblo("Lora", "440", 20000, 0, 12);
		sevilla.addPueblo("Cantillana", "431", 2000, 130, 44);
		System.out.println(sevilla);
		sevilla.setSuperficie("Lora", 200);
		System.out.println(sevilla);
	}

}
