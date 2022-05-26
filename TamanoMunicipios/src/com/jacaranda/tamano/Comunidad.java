package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;


public class Comunidad {
	private String nombre;
	private ArrayList<Municipio> listMunicipio;

	public Comunidad(String descrip) {

		this.nombre = descrip;
		listMunicipio = new ArrayList<>();

	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Municipio> getListMunicipio() {
		return listMunicipio;
	}
	
	// Devuelve true si encuentra el pueblo y puede añadirle el dato
	// y false si el pueblo no existe
	public boolean addDato(String municipio,int anno,int dato) {
		boolean encontrado=false;
		Iterator<Municipio> siguiente=listMunicipio.iterator();
		while(siguiente.hasNext()&&!encontrado) {
			Municipio aux=siguiente.next();
			if(aux.getDescrip().equalsIgnoreCase(municipio)) {
				aux.addDato(anno, dato);
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	// Devuelve cada municipio con su lista de datos en un año determinado
	public String municipios(int anno) {
		StringBuilder resul=new StringBuilder();
		for(Municipio m:listMunicipio) {
			resul.append(m.getDescrip()+m.datos(anno));
		}
		return resul.toString();
	}
	
	public int totalDatos(int anno) {
		int resul=0;
		for(Municipio m:listMunicipio) {
			if(m.getDescrip().equalsIgnoreCase("TOTAL")) {
				resul=m.totalDatos(anno);
			}
		}
		return resul;
	}
	
	public int sumaDatos(int anno) {
		int resul=0;
		for(Municipio m:listMunicipio) {
			if(!m.getDescrip().equalsIgnoreCase("TOTAL")) {
				resul+=m.totalDatos(anno);
			}
		}
		return resul;
	}
	

	
	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio.toString() + "]";
	}

	
}
