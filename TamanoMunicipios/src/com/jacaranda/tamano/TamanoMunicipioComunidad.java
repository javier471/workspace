package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
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
	
	public String comprobarTotal(String nombreComunidad, int anno) {
		String resul="";
		
		
		
		
		
		return resul;
	}
	
//	public void addDato(int anno, int dato, String nombre) throws Exception {
//		Comunidad annadeDato=buscaComunidad(nombre);
//		for()
//	}

	public ArrayList<Comunidad> getLista() {
		return lista;
	}

	@Override
	public String toString() {
		return "TamanoMunicipioComunidad [lista=" + lista.toString() + "]";
	}
	
	
	

}
