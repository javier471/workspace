package com.jacaranda.main;

import java.util.Comparator;

import com.jacaranda.logica.City;
import com.jacaranda.logica.Country;

public class ComparadorPaises implements Comparator<Country>{

	@Override
	public int compare(Country o1, Country o2) {
		int resul=o2.numCiudades()-o1.numCiudades();
		return resul;
	}

}
