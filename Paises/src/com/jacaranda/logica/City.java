package com.jacaranda.logica;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class City implements Comparable<City>{
	private int city_id;
	private String city;
	private List<Address> direcciones;

	public City(int city_id, String city) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.direcciones = new LinkedList<>();
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Address getDirecciones(int address_id) {
		Address aux = new Address(address_id, null);
		int posicion = this.direcciones.indexOf(aux);
		return this.direcciones.get(posicion);
	}

	public void addAddress(int adrress_id, String address) {
		Address a = new Address(adrress_id, address);
		int posicion = this.direcciones.indexOf(a);
		if (posicion == -1) {
			this.direcciones.add(a);
		}
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", direcciones=" + direcciones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city_id);
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
		return city_id == other.city_id;
	}

	public String escribirFichero() {
		return this.city + ": " + direcciones.size() + "\n";
	}

	public String escribirFicheroCiudades() {
		return this.getCity_id() + " " + this.getCity() + "," + this.direcciones + "\n";
	}

	public int compareTo(City city) {
		int resultado = this.numDirecciones() - city.numDirecciones();
		if(resultado==0) {
			resultado = this.city.compareTo(city.city);
		}
		return resultado;
	}
	
	public int numDirecciones() {
		return direcciones.size();
	}

}