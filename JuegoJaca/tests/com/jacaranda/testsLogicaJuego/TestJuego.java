package com.jacaranda.testsLogicaJuego;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.jacaranda.logicaJuego.Constantes;
import com.jacaranda.logicaJuego.Juego;
import com.jacaranda.logicaJuego.JuegoException;
import com.jacaranda.elemento.*;


class TestJuego {


	public Juego listaJugadoresTerminadoUnJugador() {
		PlayerType[] jugadores = {PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO};
		return new Juego(jugadores);
	}
	
	@Test
	public void testImprimeNombreJugadores() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		assertEquals("El jugador 1 es un ELFO\nEl jugador 2 es un GUERRERO\nEl jugador 3 es un MAGO\n"
				+ "El jugador 4 es un OGRO\n", juego.imprimeNombreJugadores());
	}
	
	@Test
	public void testImprimeValoresJugadores() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		assertEquals("Jugador: ELFO Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador: GUERRERO Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador: MAGO Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador: OGRO Dinero: 0 Gemas: 0 Pociones: 0\n", juego.imprimeValoreJugadores());
	}
	
	
	
	@Test
	public void testNombreJugadorQueJuegaUltimaPosicion() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		assertEquals("OGRO", juego.getNombreJuegadorQueJuega());
	}
	
	@Test
	public void testNombreJugadorQueJuegaPrimeraPosicion() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		juego.proximoJugador();
		assertEquals("ELFO", juego.getNombreJuegadorQueJuega());
	}
	
	
	@Test
	public void testGetGanadorIncorrecto() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		try {
			assertEquals(null, juego.getGanador());
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetGanadorQuedaUno() {
		PlayerType[] jugadores = {PlayerType.GUERRERO};
		Juego juego = new Juego(jugadores);
		try {
			assertEquals("Jugador: GUERRERO Dinero: 0 Gemas: 0 Pociones: 0", juego.getGanador());
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testGetGanadorTodoElDinero() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		Coordenada coordenada = juego.obtenerCoordenadaJugadorJuega();
		Jugador jugador = ((Jugador)juego.obtenerElementoTablero(coordenada));
		for(int i=0; i<Constantes.NUM_DINERO; i++) {
			jugador.encuentraDinero();
		}
		try {
			assertEquals("Jugador: ELFO Dinero: 2 Gemas: 0 Pociones: 0", juego.getGanador());
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValorDadoCorrecto() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		for(int i=0; i<200; i++) {
			juego.setDado();
			assertTrue(juego.getValorDado()>=1 && juego.getValorDado()<=Constantes.ELFO_VELOCIDAD);
		}
	}
	
	@Test
	public void testDecrementaDado() {
		Juego juego = listaJugadoresTerminadoUnJugador();
		juego.setDado();
		int dado = juego.getValorDado();
		juego.decrementaDado();
		assertEquals(dado-1, juego.getValorDado());
	}
	
}
