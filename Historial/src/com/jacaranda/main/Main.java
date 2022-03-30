package com.jacaranda.main;

import java.time.LocalDateTime;

import com.jacaranda.paginas.Historial;
import com.jacaranda.paginas.HistorialException;
import com.jacaranda.paginas.PaginaWeb;

public class Main {

	public static void main(String[] args) throws HistorialException {
		
		PaginaWeb p1=new PaginaWeb("Marca", LocalDateTime.now());
		PaginaWeb p2=new PaginaWeb("Google", LocalDateTime.now());
		Historial h1=new Historial("History");
		h1.addPagina("Amazon");
		h1.addPagina(p1);
		h1.addPagina(p2);
		System.out.println(h1.historialCompleto());

	}

}
