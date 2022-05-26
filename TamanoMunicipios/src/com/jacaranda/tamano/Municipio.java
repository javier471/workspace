package com.jacaranda.tamano;

import java.util.ArrayList;
import java.util.Iterator;

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

	// Devuelve el numero de dato de un año especifico
	public int totalDatos(int anno) {
		int resul=0;
		for(Datos d:datos) {
			if(d.getAno()==anno) {
				resul=d.getDato();
			}
		}
		return resul;
	}
	
	// Añade el dato al año si existe y si no crea uno nuevo y lo añade a la lista
	public void addDato(int anno, int dato) {
		boolean encontrado = false;
		Iterator<Datos> siguiente = datos.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Datos aux = siguiente.next();
			if (aux.getAno() == anno) {
				aux.setDato(dato);
				encontrado = true;
			}
		}
		if (!encontrado) {
			Datos nuevo = new Datos(anno, dato);
			datos.add(nuevo);
		}
	}

	// Devuelve todos los datos de la collection en un año especifico
	public String datos(int anno) {
		StringBuilder resul = new StringBuilder();
		for (Datos d : datos) {
			if (d.getAno() == anno) {
				resul.append(d + "\n");
			}
		}
		return resul.toString();
	}
	

	@Override
	public String toString() {
		return "Municipio [descrip=" + descrip + ", datos=" + datos.toString() + "]";
	}

}
