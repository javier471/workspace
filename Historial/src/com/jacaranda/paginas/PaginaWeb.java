package com.jacaranda.paginas;

import java.time.LocalDateTime;
import java.util.Objects;

public class PaginaWeb {
	private String url;
	private LocalDateTime fecha;

	public PaginaWeb(String url, LocalDateTime fecha) {
		super();
		this.url = url;
		this.fecha = fecha;
	}

	public String getUrl() {
		return url;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "PaginaWeb [url=" + url + ", fecha=" + fecha + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginaWeb other = (PaginaWeb) obj;
		return Objects.equals(url, other.url);
	}
	
	

}
