package com.jacaranda.tamano;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class TamanoMunicipioComunidad {

	private ArrayList<Comunidad> lista;

	public TamanoMunicipioComunidad() {
		lista = new ArrayList<Comunidad>();
	}

	public void cargarComunidades(String nombre) {
		Gson gson = new Gson();
		lista = gson.fromJson(nombre, new TypeToken<ArrayList<Comunidad>>() {
		}.getType());
	}
	
	public String muestraComunidadAno(int anno,String comunidad) {
		StringBuilder resultado=new StringBuilder();
		Iterator <Comunidad> siguiente=this.lista.iterator();
		boolean encontrado=false; //Recorro las comunidades
		while(siguiente.hasNext()&&!encontrado) {
			Comunidad aux=siguiente.next();
			// Si la comunidad coincide con la que me pasan, sumo su nombre
			// y los municipios con sus datos de ese año
			if (aux.getNombre().toUpperCase().equalsIgnoreCase(comunidad.toUpperCase())) {
				resultado.append(aux.getNombre()+aux.municipios(anno));
				encontrado=true;
			}
		}
		return resultado.toString();
	}
	
	// Devuelve las comunidades con su nombre, la lista de municipios y sus datos
	public String mostrarDatosAnno(int anno) {
		StringBuilder resul=new StringBuilder();
		for(Comunidad c:lista) {
			resul.append(c.getNombre()+c.municipios(anno));
		}
		return resul.toString();
	}
	
	public void escribeFichero(String nombrefichero) {
		Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
		String representacionBonita = prettyGson.toJson(this.lista);
		escribirEnFicheroJson(nombrefichero, representacionBonita);
	}
	
	private static void escribirEnFicheroJson(String nombre,String contenido) {
		try {
			FileWriter flujoEscritura = new FileWriter(nombre);
			PrintWriter filtroEscritura = new PrintWriter(flujoEscritura);
			filtroEscritura.println(contenido);
			filtroEscritura.close();
			flujoEscritura.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Devuelve la comunidad que se le pasa por parametro o lanza exception
	// si no existe
	private Comunidad buscaComunidad(String nombre) throws Exception {
		Comunidad resul=null;
		for(Comunidad c:lista) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				resul=c;
			}
		}
		if(resul==null) {
			throw new Exception("La comunidad no existe");
		}
		return resul;
	}
	//Devuelve true si puede añadir el dato, false si no existe el municipio
	// y exception si no existe la comunidad
	public boolean addDato(String comunidad,String municipio, int anno, int dato) throws Exception {
		boolean resul=false;
		Comunidad c=buscaComunidad(comunidad);
		resul=c.addDato(municipio, anno, dato);
		return resul;
	}
	
	public String comprobarTotal(String nombreComunidad, int anno) throws Exception {
		String resul="";
		Comunidad c=buscaComunidad(nombreComunidad);
		int total=c.totalDatos(anno);
		int suma=c.sumaDatos(anno);
		if(total==suma) {
			resul="Igual";
		}
		if(total>suma) {
			resul=String.valueOf(total);
		}
		else {
			resul=String.valueOf(suma);
		}
		
		return resul;
	}
	

	public ArrayList<Comunidad> getLista() {
		return lista;
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista.toString() + "]";
	}
	
	
	

}
