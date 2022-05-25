package com.jacaranda.elemento;

import com.jacaranda.logicaJuego.Constantes;

public class Jugador extends Element {

	private int dinero;
	private int gemas;
	private PlayerType player;
	private int pociones;

	public Jugador(PlayerType player) {
		// Como lo primero que pide el constructor del super es de tipo TypeElement
		// saco el tipo de elemento del player que me pasan
		super(ElementType.valueOf(player.name()));
		this.player = player;
		this.pociones = 0;
		this.gemas = 0;
		this.dinero = 0;
	}

	public String getNombre() {
		return player.toString();
	}

	public int getDinero() {
		return dinero;
	}

	public void setPociones(int pociones) {
		this.pociones = pociones;
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
		int resul = 2;
		if (gemas > 0) {
			resul = 0;
			this.gemas -= 1;
		} else {
			if (getMagia() > 4) {
				resul = 1;
			}
		}
		return resul;
	}

	public int lucha(Jugador enemigo) {
		int resul = -99;
		int fuerzaAliado = getFuerzaParaLuchar();
		int fuerzaEnemigo = enemigo.getFuerzaParaLuchar();
		if (fuerzaAliado == fuerzaEnemigo) {
			resul = Constantes.EMPATE;
		} else if (fuerzaAliado > fuerzaEnemigo) {
			if (enemigo.pociones > 0) {
				enemigo.pociones -= 1;
				resul = Constantes.GANA_USA_POCIMA;
			} else if (enemigo.dinero > 0) {
				dinero += enemigo.getDinero();
				enemigo.dinero = 0;
				resul = Constantes.GANA_DINERO;
			} else {
				resul = Constantes.GANA_MUERE;
				enemigo = null;
			}

		} else {
			if (pociones > 0) {
				pociones -= 1;
				resul = Constantes.PIERDE_USA_POCIMA;
			} else if (dinero > 0) {
				enemigo.dinero += getDinero();
				dinero = 0;
				resul = Constantes.PIERDE_DINERO;
			} else {
				resul = Constantes.PIERDE_MUERE;
			}
		}
		return resul;
	}

	public String resumen() {
		return "Jugador: " + super.getType() + " Dinero: " + getDinero() + " Gemas: " + getGemas() + " Pociones: "
				+ getPociones();
	}

	private int getFuerza() {
		return player.getFuerza();
	}

	private int getVelocidad() {
		return player.getVelocidad();
	}

	private int getMagia() {
		return player.getMagia();
	}

	public int getFuerzaParaLuchar() {
		int resul = (int) (Math.random() * (getFuerza() - 0 + 1) + getFuerza());
		return resul;
	}

	public int getMagiaParaLuchar() {
		int resul = (int) (Math.random() * (getMagia() - 0 + 1) + getMagia());
		return resul;
	}

	public int getVelocidadParaLuchar() {
		int resul = (int) (Math.random() * (getVelocidad() - 0 + 1) + getVelocidad());
		return resul;
	}
}
