package com.jacaranda.tamano;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {


	public static Scanner teclado = new Scanner(System.in);

	public static TamanoMunicipioComunidad aux = new TamanoMunicipioComunidad();

	public static void main(String[] args) throws Exception {
		String salida = leerJson("tamanoMunicipioComunidad.json");
		aux.cargarComunidades(salida);
		int opc;
		do {
			System.out.println(muestraMenu());
			System.out.println("Introduce opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				System.out.println("Introduce el año");
				int anno = Integer.parseInt(teclado.nextLine());
				System.out.println(aux.mostrarDatosAnno(anno));
				break;
			case 2:
				System.out.println("Introduce comunidad");
				String nombre = teclado.nextLine();
				System.out.println("Introduce año");
				anno = Integer.parseInt(teclado.nextLine());
				System.out.println(aux.muestraComunidadAno(anno, nombre));
				break;
			case 3:
				System.out.println("Introduce nombre de la comunidad");
				nombre = teclado.nextLine();
				System.out.println("Introduce año");
				anno = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce municipio");
				String municipio = teclado.nextLine();
				System.out.println("Introduce dato");
				int dato = Integer.parseInt(teclado.nextLine());
				System.out.println(aux.addDato(nombre, municipio, anno, dato));
				break;
			case 4:
				System.out.println("Introduce nombre de la comunidad");
				nombre=teclado.nextLine();
				System.out.println("Introduce año");
				anno=Integer.parseInt(teclado.nextLine());
				System.out.println(aux.comprobarTotal(nombre, anno));
				break;
			case 5:
				aux.escribeFichero("resultados.json");
				break;
				
			default:
				System.out.println("Opcion no valida");
			}

		} while (opc > 0 && opc <= 5);
	}

	public static String muestraMenu() {
		return "1. Mostrar todos los datos de un año\n" + "2. Mostrar los datos de una comunidad en un año\n"
				+ "3. Añadir dato\n" + "4. Comprobar total \n" +"5. Guardar datos";
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
