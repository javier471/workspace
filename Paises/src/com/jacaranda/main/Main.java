package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import com.jacaranda.logica.City;
import com.jacaranda.logica.Country;

public class Main {
	public static ArrayList<Country> paises = new ArrayList<>();

	public static void main(String[] args) {
		leerCountry("ficheros//countries.txt");
		leerCity("ficheros//cities.txt");
		leerAddress("ficheros//address2.txt");
		escribirEnFichero("ficheros//resultadop.txt");
		escribirEnFicheroCiudades("ficheros//terminadoCiudades.txt");
	}

	private static void leerCountry(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				// Separo la línea por comas
				String[] campos = linea.split(",");
				// Creo un país con su Id y su nombre
				Country c1 = new Country(Integer.parseInt(campos[0]), campos[1]);
				paises.add(c1); // Lo añado a la lista de paises del main
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerCity(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				// Creo el país con el id solo
				Country c1 = new Country(Integer.parseInt(campos[2]), null);
				// Lo busco y guardo su posicion
				int posicion = paises.indexOf(c1);
				// Le añado la ciudad que creo con su id y su nombre
				paises.get(posicion).addCity(Integer.parseInt(campos[0]), campos[1]);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerAddress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				// Saco el id de la ciudad
				int city_id = (Integer.parseInt(campos[4]));
				// Recorro los paises para ver en que pais introduzco la ciudad
				for (Country c : paises) {
					City cityAux = c.getCiudad(city_id);
					if (cityAux != null) {
						cityAux.addAddress(Integer.parseInt(campos[0]), campos[1]);
					}

				}
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("No existe el fichero " + nombreFichero);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirEnFichero(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			
			for (Country siguiente:paises) {	
				filtroEscritura.println(siguiente.escribirFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void escribirEnFicheroCiudades(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			
			ComparadorPaises cp=new ComparadorPaises();
			Collections.sort(paises,cp);
			for (Country siguiente:paises) {	
				filtroEscritura.println(siguiente.escribirFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}