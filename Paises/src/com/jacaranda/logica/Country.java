package com.jacaranda.logica;

import java.util.HashMap;
import java.util.Objects;

public class Country {

	private int country_id;
	private String country;
	private HashMap<String, City> cityList;

	public Country(int country_id, String country) {
		super();
		this.country_id = country_id;
		this.country = country;
		cityList=new HashMap<>();
	}

	public int getCountry_id() {
		return country_id;
	}

	public String getCountry() {
		return country;
	}

	public String getCityList() {
		return cityList.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id);
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
		return country_id == other.country_id;
	}

	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country=" + country + ", cityList=" + cityList.toString() + "]";
	}
	
	
	

	
	
}
