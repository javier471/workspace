package com.jacaranda.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.jacaranda.libros.Libro;
import com.jacaranda.libros.LibroDigital;

public class Main {

	public static Libro[] libreria = new Libro[100];

	public static int numLibros = 0;

	public static Scanner teclado = new Scanner(System.in);

	public static void menu() {
		System.out.println("1. Dar de alta libro \n" + "2. Dar de alta libro digital\n"
				+ "3. Dar de alta libro en papel\n" + "4. Comparar fecha de libro con otro libro\n"
				+ "5. Comparar precio de libro con otro libro\n" + "6 .Monstrar la libreria\n" + "7 .Salir");
	}

	public static void main(String[] args) throws Exception {
		int opc;
		String titulo,autor,editorial,formato;
		double precio,peso;
		do {
			menu();
			System.out.println("Introduzca opcion");
			opc = Integer.parseInt(teclado.nextLine());
			switch (opc) {
			case 1:
				System.out.println("Introduzca titulo del libro");
				titulo = teclado.nextLine();
				System.out.println("Introduzca autor");
				autor=teclado.nextLine();
				System.out.println("Introduzca editorial");
				editorial=teclado.nextLine();
				Libro l1=new Libro(titulo,autor,editorial);
				libreria[numLibros]=l1;
				numLibros++;
				break;
			case 2:
				System.out.println("Introduzca titulo del libro");
				titulo = teclado.nextLine();
				System.out.println("Introduzca autor");
				autor=teclado.nextLine();
				System.out.println("Introduzca editorial");
				editorial=teclado.nextLine();
				System.out.println("Introduzca formato");
				formato=teclado.nextLine();
				System.out.println("Introduzca precio ");
				precio=Double.parseDouble(teclado.nextLine());
				Libro l= new LibroDigital(titulo, autor, editorial, precio, formato);
				
			}
		} while (opc != 7);

	}

}
