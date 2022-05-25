package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static TamanoMunicipioComunidad aux=new TamanoMunicipioComunidad();
	
	public static void main(String[] args) {
		String salida=leerJson("tamanoMunicipioComunidad.json");
		aux.cargarComunidades(salida);
		System.out.println(aux.muestraComunidadAno(2010, "cantabria"));
	}
	
	
	private static String leerJson(String nombreFichero) {
		String linea;
		StringBuilder resul = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resul.append(linea);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resul.toString();
	}
}
