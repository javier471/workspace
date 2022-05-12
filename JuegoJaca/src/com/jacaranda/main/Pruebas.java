package com.jacaranda.main;


import com.jacaranda.elemento.Coordenada;
import com.jacaranda.elemento.Jugador;
import com.jacaranda.elemento.PlayerType;
import com.jacaranda.logicaJuego.Juego;
import com.jacaranda.logicaJuego.JuegoException;

public class Pruebas {

	public static void main(String[] args) throws JuegoException {
		// TODO Auto-generated method stub

		
		
		PlayerType [] jugadores=new PlayerType[4];
		jugadores[0]=PlayerType.OGRO;
		jugadores[1]=PlayerType.MAGO;
		jugadores[2]=PlayerType.GUERRERO;
		jugadores[3]=PlayerType.ELFO;
		
		Juego j1=new Juego(jugadores);
		System.out.println(j1.toString());
		System.out.println(j1.isTerminado());

		
		
	}

}
