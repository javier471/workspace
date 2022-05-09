package com.jacaranda.logica;

import java.util.Objects;

public class Address {

	private int address_id;
	private String direcc;

	public Address(int address_id, String direcc) {
		super();
		this.address_id = address_id;
		this.direcc = direcc;
	}

	public int getAddress_id() {
		return address_id;
	}

	public String getDirecc() {
		return direcc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id);
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
		return address_id == other.address_id;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", direcc=" + direcc + "]";
	}

	
}
