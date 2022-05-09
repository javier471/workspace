package com.jacaranda.logica;

import java.util.HashMap;
import java.util.Objects;

public class City {

	private int city_id;
	private String city;
	private HashMap<String, Address> addressList;

	public City(int city_id, String city) {
		super();
		this.city_id = city_id;
		this.city = city;
		addressList = new HashMap<>();
	}

	public String getCity() {
		return city;
	}

	public int getCity_id() {
		return city_id;
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

	public String getAddressList() {
		return addressList.toString();
	}

	@Override
	public String toString() {
		return "City [city_id=" + city_id + ", city=" + city + ", addressList=" + addressList.toString() + "]";
	}

}
