package com.jacaranda.tamano;

import java.util.ArrayList;

public class Municipio {

	private String descrip;
	private ArrayList<Datos> datos;

	public Municipio(String descrip, ArrayList<Datos> datos) {
		super();
		this.descrip = descrip;
		this.datos = datos;
	}

	public String getDescrip() {
		return descrip;
	}

	public ArrayList<Datos> getDatos() {
		return datos;
	}

	// Devuelve todos los datos de la collection en un año especifico
	public String datos (int anno) {
		StringBuilder resul=new StringBuilder();
		for(Datos d:datos) {
			if(d.getAno()==anno) {
				resul.append(d+"\n");
			}
		}
		return resul.toString();
	}
	
	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos.toString() + "]";
	}

}
