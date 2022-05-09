package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileReader;

import com.jacaranda.logica.Address;

public class Main {

	public static void main(String[] args) {
		leerAddrress("ficheros//address2.txt");
		
		
	}

	private static void leerAddrress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos=linea.split(",");
				Address aux=new Address(Integer.parseInt(campos[0]), campos[1]);
				System.out.println(aux.toString());
				
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
