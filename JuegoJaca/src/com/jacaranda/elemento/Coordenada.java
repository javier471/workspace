package com.jacaranda.elemento;

import java.util.Objects;

import com.jacaranda.logicaJuego.Constantes;
import com.jacaranda.logicaJuego.JuegoException;

public class Coordenada {

	private int x;
	private int y;

	public Coordenada() {
		super();
		x = (int) (Math.random() * Constantes.TAMANNO);
		y = (int) (Math.random() * Constantes.TAMANNO);
	}

	public Coordenada(int x, int y) {
		super();
		if (x >= 0 && x <= Constantes.TAMANNO-1 && y >=0 && y <= Constantes.TAMANNO-1) {
			this.x = x;
			this.y = y;
		} else {
			this.x = 0;
			this.y = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean goUp() {
		boolean resul;
		int aux = y - 1;
		if (aux < 0) {
			resul = false;
		} else {
			y = aux;
			resul = true;
		}
		return resul;
	}

	public boolean goDown() {
		boolean resul;
		int aux = y + 1;
		if (aux >= Constantes.TAMANNO) {
			resul = false;

		} else {
			y = aux;
			resul = true;
		}
		return resul;
	}

	public boolean goLeft() {
		boolean resul;
		int aux = x - 1;
		if (aux < 0) {
			resul = false;

		} else {
			x = aux;
			resul = true;
		}
		return resul;
	}

	public boolean goRight() {
		boolean resul;
		int aux = x + 1;
		if (aux >= Constantes.TAMANNO) {
			resul = false;

		} else {
			x = aux;
			resul = true;
		}
		return resul;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public Coordenada clona() {
		Coordenada c=new Coordenada(getX(), getY());
		return c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Coordenada [x = " + x + ", y = " + y + "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Coordenada aux = new Coordenada(this.x, this.y);
		return aux;
	}

}
