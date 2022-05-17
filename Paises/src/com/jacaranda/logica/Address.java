package com.jacaranda.logica;

import java.util.Objects;

public class Address {
	private int adrress_id;
	private String address;

	public Address(int adrress_id, String address) {
		super();
		this.adrress_id = adrress_id;
		this.address = address;
	}

	public int getAdrress_id() {
		return adrress_id;
	}

	public void setAdrress_id(int adrress_id) {
		this.adrress_id = adrress_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [adrress_id=" + adrress_id + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(adrress_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return adrress_id == other.adrress_id;
	}

}