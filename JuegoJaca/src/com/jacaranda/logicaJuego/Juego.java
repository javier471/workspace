package com.jacaranda.logicaJuego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.jacaranda.elemento.*;

public class Juego {

	private HashMap<Coordenada, Element> tablero;
	private ArrayList<Coordenada> coordenadaJugadores;
	private int jugadorJuega;
	private int dado; // Dado para ver los movimientos del jugador que juega

	public Juego(PlayerType[] jugadores) {
		super();
		tablero = new HashMap<>();
		coordenadaJugadores = new ArrayList<>();
		crearTablero();
		for (int i = 0; i < Constantes.NUM_JUGADORES; i++) {
			crearJugador(jugadores[i]);
		}
	}

	private void crearTablero() {
		crearRocas();
		crearGemas();
		crearPociones();
		crearDinero();
	}

	private boolean crearJugador(PlayerType jugador) {
		boolean resul = false;
		for (PlayerType p1 : PlayerType.values()) {
			if (p1.equals(jugador)) {
				Jugador j1 = new Jugador(jugador);
				Coordenada c = new Coordenada();
				while (tablero.get(c) != null) {
					c = new Coordenada();
				}
				coordenadaJugadores.add(c);
				tablero.put(c, j1);
				resul = true;
			}
		}

		return resul;
	}

	private void crearRocas() {
		int cont = 0;
		while (cont < Constantes.NUM_ROCAS) {
			Element e = new Element(ElementType.ROCA);
			Coordenada c = new Coordenada();
			// Si la coordenada es nula significa que puedo colocar el elemento
			if (tablero.get(c) == null) {
				tablero.put(c, e);
				// Solo aumento el contador cuando se que he podido a�adir
				// Si no ha entrado en el if es que en esa coordenada hay algo
				cont++;
			}
		}
	}

	private void crearGemas() {
		int cont = 0;
		while (cont < Constantes.NUM_GEMAS) {
			Element e = new Element(ElementType.GEMA);
			Coordenada c = new Coordenada();
			if (tablero.get(c) == null) {
				tablero.put(c, e);
				cont++;
			}

		}
	}

	private void crearPociones() {
		int cont = 0;
		while (cont < Constantes.NUM_POCIONES) {
			Element e = new Element(ElementType.POCION);
			Coordenada c = new Coordenada();
			if (tablero.get(c) == null) {
				tablero.put(c, e);
				cont++;
			}

		}
	}

	private void crearDinero() {
		int cont = 0;
		while (cont < Constantes.NUM_DINERO) {
			Element e = new Element(ElementType.DINERO);
			Coordenada c = new Coordenada();
			if (tablero.get(c) == null) {
				tablero.put(c, e);
				cont++;
			}

		}
	}

	public boolean isTerminado() {
		boolean resul = false;
		boolean tieneMaxDinero = false;
		for (Element e : tablero.values()) {
			if (e instanceof Jugador) {
				if (((Jugador) e).getDinero() == Constantes.DINERO) {
					tieneMaxDinero = true;
				}
			}
		}
		if (coordenadaJugadores.size() == 1 || tieneMaxDinero) {
			resul = true;
		}

		return resul;
	}

	private void eliminarJugador(Coordenada c) {
		if (tablero.get(c) instanceof Jugador) {
			tablero.remove(c);
			coordenadaJugadores.remove(c);
		}
	}

	private Coordenada getNextPosition(char direction) throws JuegoException {
		// Busco la coordenada del jugador
		Coordenada jugadorTurno = coordenadaJugadores.get(jugadorJuega);
		// Hago una copia que ser� la que devuelva con el resul de donde se
		// moveria el jugador
		Coordenada resul = new Coordenada(jugadorTurno.getX(), jugadorTurno.getY());
		if (direction != 'N' && direction != 'S' && direction != 'E' && direction != 'O') {
			throw new JuegoException("Direccion no valida");
		}
		switch (direction) {
		case 'N': {
			resul.goUp();
			break;
		}
		case 'S': {
			resul.goDown();
			break;
		}
		case 'E': {
			resul.goRight();
			break;
		}
		case 'O': {
			resul.goLeft();
			break;
		}
		default:
			throw new JuegoException("Error");
		}
		return resul;
	}

	public String imprimeNombreJugadores() {
		StringBuilder resul = new StringBuilder();
		int cont = 1;
		for (Coordenada c : coordenadaJugadores) {
			Jugador aux = (Jugador) tablero.get(c);
			resul.append("El jugador " + cont + " es un " + aux.getPlayer() + " ");
			cont++;
		}
		return resul.toString();
	}

	public String imprimeValoreJugadores() {
		StringBuilder resul = new StringBuilder();
		int cont = 1;
		for (Coordenada c : coordenadaJugadores) {
			Jugador aux = (Jugador) tablero.get(c);
			resul.append("El jugador" + cont + " tiene " + aux.getDinero() + " dinero, " + aux.getGemas() + " gemas, "
					+ aux.getPociones() + " pociones ");
			cont++;
		}
		return resul.toString();
	}

	private void cambiaJugadorAPosicion(Coordenada coor) {
		// Coordenada del jugador
		Coordenada coorActual = coordenadaJugadores.get(jugadorJuega);
		// Jugador que esta en esa coordenada
		Jugador aux = (Jugador) tablero.get(coorActual);
		// Lo movemos hacia su nueva posicion
		tablero.put(coor, aux);
		// Borramos la antigua coordenada
		tablero.remove(coorActual);
		// Actualizamos en la lista de coordenadas de los jugadores
		coordenadaJugadores.remove(jugadorJuega);
		coordenadaJugadores.add(jugadorJuega, coor);
	}

	/**
	 * Escribe el tablero en formato no gráfico. Devuelve el string con la
	 * información
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constantes.TAMANNO; fila++) {
			for (int columna = 0; columna < Constantes.TAMANNO; columna++) {
				Coordenada coor = new Coordenada(columna, fila);

				if (this.tablero.get(coor) != null) {
					resul.append(" " + this.tablero.get(coor).getType().getSymbol() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	/**
	 * Simplemente escribe una barra en pantalla
	 * 
	 * @return
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constantes.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	/**
	 * Mover el jugador
	 * 
	 * @param direction
	 * @return
	 * @throws JuegoException
	 * @throws JugadorException
	 */
	public String movePlayer(char direction) throws JuegoException, JugadorException {
		// Si no es una dirección válida, mando un exception
		String resul = "";
		Jugador jugador = (Jugador) this.tablero.get(this.coordenadaJugadores.get(jugadorJuega));

		Coordenada coordDestino = getNextPosition(direction);

		// Tengo que ver que hay en la nueva casilla
		Element elemento = this.tablero.get(coordDestino);

		if (elemento != null) { // Hay algo en la casilla
			if (elemento instanceof Jugador) {

				Jugador enemigo = (Jugador) elemento;
				int resultadoLucha = jugador.lucha(enemigo);
				switch (resultadoLucha) {
				case Constantes.EMPATE:
					resul = "Empate entre los jugadore";
					break;
				case Constantes.GANA_USA_POCIMA:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constantes.GANA_DINERO:
					resul = "El jugador " + jugador.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constantes.GANA_MUERE:
					resul = "El jugador " + jugador.getNombre() + " gana. El enemigo muere";
					this.eliminarJugador(coordDestino);
					// Si se elimina el jugador que juega el dado se pone a 0 para que no siga
					// tirando
					break;
				case Constantes.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al jugador";
					break;
				case Constantes.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al jugador";
					break;
				case Constantes.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El jugador muere";
					this.eliminarJugador(this.coordenadaJugadores.get(jugadorJuega));
					dado = 0;
					// Decrementamos en uno el jugador, para que no se salte al siguiente
					// ya que al borrarlo el siguiente apunta al siguiente, y al incrementarlo
					// se le salta
					this.jugadorJuega--;
					break;
				}
				// Después de la lucha los jugadores no se mueven
			} else if (elemento.getType() == ElementType.ROCA) {
				int resultadoRoca = jugador.encuentraRoca();
				switch (resultadoRoca) {
				case Constantes.ROMPE_ROCA_CON_GEMA:
					resul = "El jugador " + jugador.getNombre() + " rompe la roca con una gema";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.GANA_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " gana a la roca";
					this.cambiaJugadorAPosicion(coordDestino);
					break;

				case Constantes.PIERDE_A_LA_ROCA:
					resul = "El jugador " + jugador.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getType() == ElementType.GEMA) {
				jugador.encuentraGema();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.DINERO) {
				jugador.encuentraDinero();
				this.cambiaJugadorAPosicion(coordDestino);

			} else if (elemento.getType() == ElementType.POCION) {
				jugador.encuentraPocion();
				this.cambiaJugadorAPosicion(coordDestino);

			}

		} else {
			this.cambiaJugadorAPosicion(coordDestino);
		}

		return resul;
	}

	public void proximoJugador() {
		jugadorJuega++;
		if (jugadorJuega == (Constantes.NUM_JUGADORES - 1)) {
			jugadorJuega = 0;
		}
	}

	public String getGanador() throws JuegoException {
		if (!isTerminado()) {
			throw new JuegoException("El juego no esta terminado");
		}
		String resul = "";
		Jugador aux;
		if (coordenadaJugadores.size() == 1) {
			// Si queda un jugador, lo recojo en aux e imprimo sus valores en resul
			aux = (Jugador) tablero.get(coordenadaJugadores.get(0));
			resul = aux.toString();
		} else {
			for (Element e : tablero.values()) {
				if (e instanceof Jugador) {
					if (((Jugador) e).getDinero() == Constantes.DINERO) {
						resul=e.toString();
					}
				}
			}
		}
		return resul;
	}
	
	public String getNombreJuegadorQueJuega() {
		Jugador aux=(Jugador) tablero.get(coordenadaJugadores.get(jugadorJuega));
		return aux.getNombre();
	}
	
	public int getMovimientoJugador() {
		Coordenada c= coordenadaJugadores.get(jugadorJuega);
		Jugador aux=(Jugador) tablero.get(c);
		return aux.getVelocidadParaLuchar();
	}
	
	public int getValorDado() {
		return dado;
	}
	
	public void decrementaDado() {
		dado--;
	}
	
	public void setDado() {
		Coordenada c= coordenadaJugadores.get(jugadorJuega);
		Jugador aux=(Jugador) tablero.get(c);
		dado=aux.getVelocidadParaLuchar();
	}
	
	public Element obtenerElementoTablero(Coordenada coord) {
		return tablero.get(coord);
	}
	
	public Coordenada obtenerCoordenadaJugadorJuega() {
		return coordenadaJugadores.get(jugadorJuega);
	}
	
}
