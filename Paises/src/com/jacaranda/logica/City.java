package com.jacaranda.logica;

import java.util.HashMap;
import java.util.Objects;

public class City {

	private String city;
	private HashMap<Integer, Address> listaDirecc;

	public City(String city) {
		super();
		this.city = city;
		listaDirecc=new HashMap<>();
	}

	public String getCity() {
		return city;
	}
	
	public void addAdrress(Integer id,Address a1) {
		listaDirecc.put(id, a1);
	}
	
	public int getId() {
		int resul=0;
		for(Integer i:listaDirecc.keySet()) {
			resul=i.intValue();
		}
		return resul;
	}

	public String getListaDirecc() {
		return listaDirecc.toString();
	}

	public int getNumeroDirecciones(){
		return listaDirecc.values().size();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(city, listaDirecc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(city, other.city) && Objects.equals(listaDirecc, other.listaDirecc);
	}

	@Override
	public String toString() {
		return "City [city=" + city + ", listaDirecc=" + listaDirecc.toString() + "]";
	}

	
	

}
