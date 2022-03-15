package com.jacaranda.main;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.jacaranda.libros.Libro;

public class Main {

	public static void main(String[] args) throws Exception {
		Libro l1=new Libro("Quijote","Cervantes","Anaya");
		Libro l2=new Libro("Juego De Tronos","George Martin","Norma");
		System.out.println(l1);
		System.out.println(l2);
		
	

	}

}
