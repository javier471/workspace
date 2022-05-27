package PlataformaOnline.jacaranda.com;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Series {

	// Se utiliza una LinkedList porque se va a interactuar e insertar cap�tulos
	// entre el principio y el final de la lista, por lo cu�l el orden es importante
	// y adem�s esta colecci�n es la que nos permite modificar datos "entre medias"
	// de forma m�s eficiente

	private HashMap<String, Serie> mapSeries;

	/**
	 * Crea el objeto que nos servirá para tener las series
	 */
	public Series() {
		mapSeries = new HashMap<String, Serie>();
	}

	/**
	 * Añade una serie a la lista de series. Si existe una serie con el mismo
	 * nombre lanza una excpetion
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirSerie(String nombreSerie, int anno, Tema tema) throws SerieException {
		if (mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("Ya existe esa serie");
		}
		Serie serie = new Serie(nombreSerie, anno, tema);
		mapSeries.put(serie.getNombreSerie(), serie);
	}

	public HashMap<String, Serie> getMapSeries() {
		return mapSeries;
	}

	/**
	 * Añade una temporada a la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirTemporada(String nombreSerie, String temporada) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirTemporada(temporada);
	}

	/**
	 * Añade un capítulo a la temporada de la Serie cuyo nombre se le pasa por
	 * argumento, si no existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada(String nombreSerie, String temporada, String capitulo) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.annadirCapituloTemporada(temporada, capitulo);

	}

	/**
	 * Valorar una temporada de la Serie cuyo nombre se le pasa por argumento, si no
	 * existe la Serie o la temporada lanza una exception
	 * 
	 * @param serie
	 * @throws SerieException
	 */
	public void valorarTemporada(String nombreSerie, String temporada, int valoracion) throws SerieException {
		if (!mapSeries.containsKey(nombreSerie)) {
			throw new SerieException("No existe esa serie");
		}
		Serie serie = mapSeries.get(nombreSerie);
		serie.valorarTemporada(temporada, valoracion);
	}

	/**
	 * Devuelve el número de temporadas que tiene la serie que se pasa por
	 * parámetro Si no existe la serie saltará la excepción.
	 * 
	 * @param nombreSerie
	 * @return
	 * @throws SerieException
	 */

	public int numeroDeTemporadasDeUnaSerie(String nombreSerie) throws SerieException {
		int num = 0;
		if (mapSeries.containsKey(nombreSerie)) {
			num = mapSeries.get(nombreSerie).numTemporadas();
		} else {
			throw new SerieException("La serie no existe");
		}
		return num;
	}

	/**
	 * Modifica el tema de una serie. Si no se encuentra la serie o ya tenía ese
	 * tema saltará la excepción.
	 * 
	 * @param nombreSerie
	 * @param nuevoTema
	 * @throws SerieException
	 */
	public void modificarTema(String nombreSerie, Tema nuevoTema) throws SerieException {
		Serie aux = mapSeries.get(nombreSerie);
		if (aux == null || aux.getTema().equals(nuevoTema)) {
			throw new SerieException("No se pudo modificar tema");
		}
		aux.setTema(nuevoTema);
	}

	/**
	 * Devolverá un listado ordenado de forma creciente por el año de la serie.
	 * Para cada serie se mostrará su nombre, año y número de temporadas. Si no
	 * hay ninguna serie de ese tema saltará la excepción.
	 * 
	 * @param tema
	 * @return
	 * @throws SerieException
	 */
	public String listadoOrdenadoSeriesDeUnTema(Tema tema) throws SerieException {
		StringBuilder resul = new StringBuilder();
		ArrayList<Serie> lista = new ArrayList<>(mapSeries.values());
		for (Serie s : lista) {
			if (s.getTema().equals(tema)) {
				resul.append(s.getNombreSerie() + " " + s.getAnno() + " " + s.numeroTemporadas() + "\n");
			}
		}
		ComparadorSerie co = new ComparadorSerie();
		Collections.sort(lista, co);
		return resul.toString();
	}

	public String listaSeries() {
		StringBuilder resul = new StringBuilder();
		for (Serie s : mapSeries.values()) {
			resul.append(s.toString() + "\n");
		}
		return resul.toString();
	}

	public void escribirSerie(String nombre) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			for (Serie s : mapSeries.values()) {
				filtroEscritura.println(s.escribeFichero());
			}
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String escribirTemporada(String fichero) {
		StringBuilder resultado = new StringBuilder();
		// Creo un arrayList de series
		ArrayList<Serie> siguiente = new ArrayList<>(this.mapSeries.values());
		try {
			FileWriter flujoEscritura = new FileWriter(fichero);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// Por cada serie escribo
			for (Serie s : siguiente) {
				filtroEscritura.println(s.escribeFicheroTemporada());
			}

			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado.toString();
	}

	public String escribirCapitulos(String fichero) {
		StringBuilder resultado = new StringBuilder();
		// Creo el arraylist de los valores del map
		ArrayList<Serie> siguiente = new ArrayList<>(this.mapSeries.values());
		try {
			FileWriter flujoEscritura = new FileWriter(fichero);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			// Para cada serie voy llamando a los metodos de escritura inferiores
			for (Serie s : siguiente) {
				resultado.append(s.getNombreSerie() + "," + s.escribeFicheroCapitulos() + "\n");
			}
			filtroEscritura.println(resultado.toString());
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		for (Serie s : siguiente) {
			resultado.append(s.escribeFicheroTemporada() + "\n");
		}
		return resultado.toString();
	}
}
