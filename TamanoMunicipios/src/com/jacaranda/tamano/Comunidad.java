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
	
	// Modifico el municipio, porque me dice comunidad pero no tiene anno??
//	public boolean addDato(int anno,int dato) {
//		boolean resul=false;
//		boolean encontrado=false;
//		Iterator<Municipio> siguiente=listMunicipio.iterator();
//		while(siguiente.hasNext()&&!encontrado) {
//			Municipio aux=siguiente.next();
//		}
//	}
	
	// Devuelve cada municipio con su lista de datos en un año determinado
	public String municipios(int anno) {
		StringBuilder resul=new StringBuilder();
		for(Municipio m:listMunicipio) {
			resul.append(m.getDescrip()+m.datos(anno));
		}
		return resul.toString();
	}
	
	
	
	@Override
	public String toString() {
		return "Comunidad [nombre=" + nombre + ", listMunicipio=" + listMunicipio.toString() + "]";
	}

	
}
