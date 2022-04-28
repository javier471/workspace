package com.jacaranda.elemento;

import com.jacaranda.logicaJuego.Constantes;

public class Jugador extends Element {

	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;

	public Jugador(PlayerType type) {
		super();
		this.player = type;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getGemas() {
		return gemas;
	}

	public void setGemas(int gemas) {
		this.gemas = gemas;
	}

	public PlayerType getPlayer() {
		return player;
	}

	public void setPlayer(PlayerType player) {
		this.player = player;
	}

	public int getPociones() {
		return pociones;
	}

	public void encuentraDinero() {
		this.dinero += 1;
	}

	public void encuentraGema() {
		this.gemas += 1;
	}

	public void encuentraPocion() {
		this.pociones += 1;
	}

	public int encuentraRoca() {
		int resul = 0;
		if (gemas > 0) {
			resul = 1;
		}
		return resul;
	}

}
