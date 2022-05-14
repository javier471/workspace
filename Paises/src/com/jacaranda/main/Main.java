package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

import com.jacaranda.logica.Address;
import com.jacaranda.logica.City;
import com.jacaranda.logica.Country;

public class Main {

	public static HashMap<Integer, Country> paises = new HashMap<>();

	public static void main(String[] args) {
		leerCountry("ficheros//countries.txt");
		leerCities("ficheros//cities.txt");
		leerAddrress("ficheros//address2.txt");

		escribirEnFicheroPorLineas("ficheros//resultado.txt");

	}

	private static void escribirEnFicheroPorLineas(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Country c : paises.values()) {
				for (City aux : c.getListaCities().values()) {
					filtroEscritura.println(c.getName()+" " + c.getId()+ " " + c.numeroCiudades() + " "+aux.getNumeroDirecciones());
				}
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerAddrress(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");

				// Obtengo el id del address y el address y el id de la ciudad
				// Recorro mi coleccion de paises y miro en cada pais si tiene la ciu
				// dad con codigo id que he leido. Si la tiene, consigo la ciudad
				// y le añado la dirección y termino. Si no la tiene, paso al siguiente
				// país
				Address aux = new Address(Integer.parseInt(campos[0]), campos[1]);
				int codCiudad = Integer.parseInt(campos[4]);
				for (Country c : paises.values()) {
					if (c.getCiudad(codCiudad) != null) {
						City ciudad = c.getCiudad(codCiudad);
						ciudad.addAdrress(codCiudad, aux);
					}
				}
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerCities(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				// Creo la ciudad el nombre de ciudad
				City aux = new City(campos[1]);
				// Obtengo el pais que tiene el id donde esta esa ciudad
				Country paisAux = paises.get(Integer.parseInt(campos[2]));
				// Añado a la lista de ciudades de ese pais la ciudad
				paisAux.addCity(Integer.parseInt(campos[2]), aux);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void leerCountry(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				// Creo el pais y lo añado a la coleccion de paises del main
				Country aux = new Country(campos[1]);
				paises.put(Integer.parseInt(campos[0]), aux);
				linea = filtroLectura.readLine();
			}
			filtroLectura.close();
			flujoLectura.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
