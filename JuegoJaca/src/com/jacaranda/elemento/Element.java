package com.jacaranda.elemento;

import java.util.Objects;

public class Element {

	protected ElementType type;

	public ElementType getType() {
		return type;
	}

	public Element(ElementType type) {
		super();
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return type == other.type;
	}

	@Override
	public String toString() {
		return "Element [type = " + type + "]";
	}

}
