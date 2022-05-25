package com.jacarada.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {

		Gson gson = new Gson();
		String fichero = imprimirFicheroPorLineas("ficheros//prueba2.json");
//		System.out.println("*************");
//		System.out.println(fichero);
//		Persona p1=gson.fromJson(fichero, Persona.class);
//		System.out.println(p1);

		ArrayList<Persona> personas = gson.fromJson(fichero, new TypeToken<ArrayList<Persona>>() {
		}.getType());
		for (Persona p : personas) {
			System.out.println(p.toString());
		}

		Persona aux = new Persona("pepe", "perez", 22);
		personas.add(aux);
		personas.remove(0);

		final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String salida = prettyGson.toJson(personas);
		
		escribirEnFicheroJson("ficheros//prueba3.json", salida);
	}

	private static String imprimirFicheroPorLineas(String nombreFichero) {
		String linea;
		StringBuilder resul = new StringBuilder();
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				resul.append(linea);
				System.out.println(linea);
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

	private static void escribirEnFicheroJson(String nombre,String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
