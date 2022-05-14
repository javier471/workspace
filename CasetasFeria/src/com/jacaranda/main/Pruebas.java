package com.jacaranda.main;

import com.jacaranda.logica.Calle;
import com.jacaranda.logica.Caseta;

public class Pruebas {

	public static void main(String[] args) {
		Calle ca=new Calle("Lorca", 0);
		Caseta c1= new Caseta("Pepe", ca, 43, 1, "Familiar", 1);
		Caseta c2= new Caseta("Paco", ca, 45, 2, "Distrito", 2);
		Caseta c3= new Caseta("Manolo", ca, 47, 3, "Socio", 3);
		ca.addCaseta(c1);
		ca.addCaseta(c2);
		ca.addCaseta(c3);
		System.out.println(ca.muestraCasetasFamiliar());
	}

}
