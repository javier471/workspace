package com.jacaranda.logica;

import java.util.HashMap;
import java.util.Objects;

public class Country {

	private String name;
	private HashMap<Integer,City> listaCities;

	public Country(String name) {
		super();
		this.name = name;
		listaCities= new HashMap<>();
	}


	public void addCity(int id,City aux) {
		listaCities.put(id, aux);
	}

	
	public String getName() {
		return name;
	}


	public int getId() {
		int resul=0;
		for(Integer i:listaCities.keySet()) {
			resul=i.intValue();
		}
		return resul;
	}
	
	

	public HashMap<Integer, City> getListaCities() {
		return listaCities;
	}


	public City getCiudad(Integer id) {
		return listaCities.get(id);
	}
	
	public int numeroCiudades() {
		return listaCities.values().size();
	}
	
	public int numeroDirecciones() {
		int resul=0;
		for(City c:listaCities.values()) {
			resul+=c.getNumeroDirecciones();
		}
		return resul;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(listaCities, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(listaCities, other.listaCities) && Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Country [name=" + name + ", listaCities=" + listaCities.toString() + "]";
	}


	
	
	
	

	
	
}
