package Principal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


import PlataformaOnline.jacaranda.com.SerieException;
import PlataformaOnline.jacaranda.com.Series;
import PlataformaOnline.jacaranda.com.Tema;
import PlataformaOnline.jacaranda.com.Temporada;

public class Main {

	
	
	public static void main(String[] args) throws SerieException {
		
		
		
		Series series = new Series();
		try {
			series.annadirSerie("This is us", 2015, Tema.COMEDIA);
			series.annadirSerie("Friends", 1990, Tema.COMEDIA);
			series.annadirSerie("Dallas", 1970, Tema.INTRIGA);
			series.annadirTemporada("Friends", "Temp1");
			series.annadirTemporada("Dallas", "temporada01");
			series.annadirTemporada("This is us", "Empezamos");
			series.annadirTemporada("This is us", "Seguimos");
			series.annadirTemporada("This is us", "Finalizamos");
			series.annadirCapituloTemporada("This is us", "Empezamos", "La familia");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El problema");
			series.annadirCapituloTemporada("This is us", "Empezamos", "Los niños");
			series.annadirCapituloTemporada("This is us", "Empezamos", "CAsi el final");
			series.annadirCapituloTemporada("This is us", "Empezamos", "El final");
			series.annadirCapituloTemporada("Friends", "Temp1", "cap1");
			series.annadirCapituloTemporada("Dallas","temporada01", "cap00");
			
			series.escribirSerie("ficheros//Series.csv");
			series.escribirTemporada("ficheros//Temporada.csv");
			series.escribirCapitulos("ficheros//Capitulos.csv");
			
			System.out.println(series.listadoOrdenadoSeriesDeUnTema(Tema.COMEDIA));
		} catch (SerieException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	
	
	
	
}
