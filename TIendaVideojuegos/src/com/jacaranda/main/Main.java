package com.jacaranda.main;

import java.time.LocalDate;

import com.jacaranda.logistica.Tienda;
import com.jacaranda.logistica.TiendaException;
import com.jacaranda.logistica.Usuario;
import com.jacaranda.videojuegos.NewGen;
import com.jacaranda.videojuegos.OldGen;
import com.jacaranda.videojuegos.Videojuego;
import com.jacaranda.videojuegos.VideojuegoException;

public class Main {

	public static void main(String[] args) throws VideojuegoException, TiendaException {
		// TODO Auto-generated method stub

		
		Tienda t1=new Tienda("Game", "Sevilla");
		Usuario u1=new Usuario("Pepe", "1111T", 20);
		Usuario u2=new Usuario("Paco", "2222M", 19);
		NewGen v1=new NewGen("Cod", 70, "Shooter", 4, LocalDate.parse("2022-05-04"));
		OldGen v2=new OldGen("GTA", 40, "ROL", "CD", 2.5);
	
		t1.addUsuario(u1);
		t1.addUsuario(u2);
		System.out.println(t1);
		t1.addJuego(v2);
		System.out.println(t1);
		System.out.println(t1.reservar(v2, u2));
		System.out.println(t1.mostrarReservas());
		
		
		
		
		
	}

}
