package com.jacaranda.main;

import com.jacaranda.diccionario.Diccionario;
import com.jacaranda.diccionario.DiccionarioMapa;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Diccionario d1=new Diccionario();
		d1.addPalabra("coche", "carro");
		System.out.println(d1);
		d1.borrarPalabra("coche");
		System.out.println(d1);
	}

}
