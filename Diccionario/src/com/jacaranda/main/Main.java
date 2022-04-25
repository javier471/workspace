package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diccionario d1=new Diccionario();
		d1.addPalabra("Hola", "significado");
		d1.addPalabra("Hola", "significado2");
		System.out.println(d1.buscarPalabraPorLetra("h"));
	}

}
