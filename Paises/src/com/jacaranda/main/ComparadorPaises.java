package com.jacaranda.main;

import java.util.Comparator;

import com.jacaranda.logica.City;
import com.jacaranda.logica.Country;

public class ComparadorPaises implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		int resul=o1.numDirecciones()-o2.numDirecciones();
		if(resul==0) {
			resul=o1.getCity().compareTo(o2.getCity());
		}
		return resul;
	}

}
