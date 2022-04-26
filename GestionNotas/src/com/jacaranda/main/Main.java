package com.jacaranda.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.jacaranda.gestion.Alumnado;
import com.jacaranda.gestion.Modulo;
import com.jacaranda.gestion.Nota;

public class Main {

	public static LinkedList<Alumnado> listaAlumnados = new LinkedList<>();
	public static HashSet<Modulo> listaModulos = new HashSet<>();
	public static ArrayList<Nota> listaNota = new ArrayList<>();
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		int opc;
		leerAlumno("ficheros//alumnos.txt");
		leerModulo("ficheros//modulos.txt");
		leernota("ficheros//notas.txt");

		do {
			muestraMenu();

			opc = Integer.parseInt(teclado.nextLine());

			switch (opc) {
			case 1: {
				System.out.println("Introduce nombre");
				String nombre = teclado.nextLine();
				System.out.println("Introduce dni");
				String dni = teclado.nextLine();
				System.out.println("Introduce correo electronico");
				String correo = teclado.nextLine();
				Alumnado a1 = new Alumnado(nombre, dni, correo);
				listaAlumnados.add(a1);
				break;
			}
			case 2: {
				System.out.println("Introduce nombre");
				String nombre = teclado.nextLine();
				System.out.println("Introduce horas semanales");
				int horas = Integer.parseInt(teclado.nextLine());
				System.out.println("Introduce creditos");
				int creditos = Integer.parseInt(teclado.nextLine());
				Modulo m1 = new Modulo(nombre, horas, creditos);
				listaModulos.add(m1);
				break;
			}
			case 3: {
				System.out.println("Introduzca calificacion");
				double nota = Double.parseDouble(teclado.nextLine());
				System.out.println("Introduzca fecha (YYYY-MM-DD)");
				LocalDate fecha = LocalDate.parse(teclado.nextLine());
				System.out.println("Introduzca dni del alumno");
				String dni = teclado.nextLine();
				boolean encontrado = false;
				Alumnado a1 = null;
				Iterator<Alumnado> siguiente = listaAlumnados.iterator();
				while (siguiente.hasNext() && !encontrado) {
					Alumnado aux = siguiente.next();
					if (aux.getDni().equalsIgnoreCase(dni)) {
						a1 = aux;
						encontrado = true;

					}
				}
				if (!encontrado) {
					throw new Exception("El alumno no se encontró");
				}
				System.out.println("Introduzca nombre del módulo");
				String modulo = teclado.nextLine();
				encontrado = false;
				Modulo m1 = null;
				Iterator<Modulo> sig = listaModulos.iterator();
				while (sig.hasNext() && !encontrado) {
					Modulo aux = sig.next();
					if (aux.getNombre().equalsIgnoreCase(modulo)) {
						m1 = aux;
						encontrado = true;
					}
				}
				if (!encontrado) {
					throw new Exception("El módulo no se encontró");
				}
				Nota n1 = new Nota(nota, fecha, a1, m1);
				listaNota.add(n1);
				break;

			}
			case 4: {
				for (Nota n : listaNota) {
					System.out.println(n);
				}
				break;
			}
			case 5: {
				for (Modulo m : listaModulos) {
					System.out.println(m);
				}
				break;
			}
			case 6: {
				for (Alumnado alu : listaAlumnados) {
					System.out.println(alu);
				}
				break;
			}
			case 7: {
				escribirAlumno("ficheros//alumnos.txt");
				escribirModulo("ficheros//modulo.txt");
				escribirNota("ficheros//notas.txt");
				break;
			}
			default:
				System.out.println("Opcion no permitida");
			}
		} while (opc != 8);
	}

	public static void muestraMenu() {
		System.out.println("1. Alta alumnado");
		System.out.println("2. Alta modulo");
		System.out.println("3. Registrar nota");
		System.out.println("4. Listar notas con todos los alumnos");
		System.out.println("5. Listar módulos");
		System.out.println("6. Listar todos los alumnos");
		System.out.println("7. Guardar datos en fichero");
		System.out.println("8. Salir");
	}

	private static void leerAlumno(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Alumnado aux = new Alumnado(campos[0], campos[1], campos[2]);
				listaAlumnados.add(aux);
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

	private static void leerModulo(String nombreFichero) {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");
				Modulo aux = new Modulo(campos[0], Integer.parseInt(campos[1]), Integer.parseInt(campos[2]));
				listaModulos.add(aux);
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

	private static void leernota(String nombreFichero) throws Exception {
		String linea;
		try {
			FileReader flujoLectura = new FileReader(nombreFichero);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);
			linea = filtroLectura.readLine();
			while (linea != null) {
				String[] campos = linea.split(",");

				// Como se me pide el objeto entero tengo que crear objetos con la String que
				// consigo

				String dni = campos[2];// Consigo la cadena q es el DNI
				Alumnado alu = new Alumnado("kk", dni);// Creo un alumno auxiliar
				int posicion = listaAlumnados.indexOf(alu);// Consigo la pos alumno del que me dan el dni
				if (posicion < 0) {
					throw new Exception("El alumno no está en la lista");
				}
				alu = listaAlumnados.get(posicion);// Copio el alumno con el dni que me dan en el auxiliar

				String nombreModulo = campos[3];// Saco el nombre del modulo
				Modulo resul = null;// Creo el modulo que voy a devolver
				boolean encontrado = false;
				Iterator<Modulo> siguiente = listaModulos.iterator();
				while (siguiente.hasNext() && !encontrado) {// Busco el modulo que tiene el mismo nombre
					Modulo m1 = siguiente.next();
					if (m1.getNombre().equalsIgnoreCase(nombreModulo)) {
						resul = m1;// Guardo el modulo en la auxiliar
						encontrado = true;
					}
				}
				if (!encontrado) {
					throw new Exception("El módulo no esta en la lista");
				}

				// Creo la nota con los campos
				Nota aux = new Nota(Double.parseDouble(campos[0]), LocalDate.parse(campos[1]), alu, resul);
				listaNota.add(aux);
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

	private static void escribirAlumno(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Alumnado alu : listaAlumnados) {
				filtroEscritura.println(alu.escribeFichero());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirModulo(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Modulo m : listaModulos) {
				filtroEscritura.println(m.escribeFichero());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void escribirNota(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Nota n : listaNota) {
				filtroEscritura.println(n.escribeFichero());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
