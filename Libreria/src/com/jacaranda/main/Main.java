package com.jacaranda.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.jacaranda.libros.Libro;
import com.jacaranda.libros.LibroDigital;
import com.jacaranda.libros.LibroPapel;

public class Main {

	public static Libro[] libreria = new Libro[100];

	public static int numLibros = 0;

	public static Scanner teclado = new Scanner(System.in);

	public static void menu() {
		System.out.println("1. Dar de alta libro \n" + "2. Dar de alta libro digital\n"
				+ "3. Dar de alta libro en papel\n" + "4. Comparar fecha de libro con otro libro\n"
				+ "5. Comparar precio de libro con otro libro\n" + "6 .Mostrar la libreria\n" + "7 .Salir");
	}

	public static void main(String[] args) throws Exception {
		int opc,pos1,pos2;
		String titulo, autor, editorial, formato, auxNombre,libroComparar;
		double precio, peso;
		Libro l1;
		LibroDigital d1,d2;
		LibroPapel p1,p2;
		do {
			menu();
			System.out.println("Introduzca opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				System.out.println("Introduzca titulo del libro");
				titulo = teclado.nextLine();
				System.out.println("Introduzca autor");
				autor = teclado.nextLine();
				System.out.println("Introduzca editorial");
				editorial = teclado.nextLine();
				l1 = new Libro(titulo, autor, editorial);
				libreria[numLibros] = l1;
				numLibros++;
				break;
			case 2:
				System.out.println("Introduzca titulo del libro");
				titulo = teclado.nextLine();
				System.out.println("Introduzca autor");
				autor = teclado.nextLine();
				System.out.println("Introduzca editorial");
				editorial = teclado.nextLine();
				System.out.println("Introduzca formato");
				formato = teclado.nextLine();
				System.out.println("Introduzca precio ");
				precio = Double.parseDouble(teclado.nextLine());
				l1 = new LibroDigital(titulo, autor, editorial, precio, formato);
				libreria[numLibros] = l1;
				numLibros++;
				break;
			case 3:
				System.out.println("Introduzca titulo del libro");
				titulo = teclado.nextLine();
				System.out.println("Introduzca autor");
				autor = teclado.nextLine();
				System.out.println("Introduzca editorial");
				editorial = teclado.nextLine();
				System.out.println("Introduzca peso");
				peso = Double.parseDouble(teclado.nextLine());
				System.out.println("Introduzca precio");
				precio = Double.parseDouble(teclado.nextLine());
				l1 = new LibroPapel(titulo, autor, editorial, precio, peso);
				libreria[numLibros] = l1;
				numLibros++;
				break;
			case 4:
				System.out.println("Introduzca nombre del libro que quiere comparar");
				auxNombre = teclado.nextLine();
				pos1=buscaLibro(auxNombre);
				System.out.println("Introduzca nombre del libro con el que quiere comparar");
				libroComparar=teclado.nextLine();
				pos2=buscaLibro(libroComparar);
				System.out.println(libreria[pos1].diferenciaFecha(libreria[pos2]));
				break;
			case 5:
				System.out.println("Introduzca nombre del libro que quiere comparar");
				auxNombre = teclado.nextLine();
				pos1=buscaLibro(auxNombre);
				System.out.println("Introduzca nombre del libro con el que quiere comparar");
				libroComparar=teclado.nextLine();
				pos2=buscaLibro(libroComparar);
				if(libreria[pos1] instanceof LibroDigital) {
					d1=(LibroDigital) libreria[pos1];
				}
				else if(libreria[pos2] instanceof LibroPapel) {
					p1=(LibroPapel) libreria[pos1];
				}
				if( libreria[pos2] instanceof LibroDigital) {
					d2=(LibroDigital) libreria[pos2];
				}
				else if (libreria[pos2] instanceof LibroPapel ) {
					p2=(LibroPapel) libreria[pos2];
				}
				break;
			case 6:
				for(int i=0;i<numLibros;i++) {
					System.out.println(libreria[i].toString());
				}
				
			}
		} while (opc != 7);

	}

	public static int buscaLibro(String nombre) throws Exception {
		int resul=-1000;
		boolean encontrado = false;
		for (int i = 0; i < numLibros && !encontrado; i++) {
			if (libreria[i].getTitulo() == nombre) {
				encontrado = true;
				resul=i;
			}
		}
		if (!encontrado) {
			throw new Exception("El libro introducido no existe");
		}
		return resul;
	}
}