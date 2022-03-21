package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable {

	protected String texto;
	private LocalDateTime FechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente = 1;
	protected Usuario usuario;

	public Publicacion(String texto, Usuario usuario) {
		super();
		this.texto = texto;
		this.usuario = usuario;
		this.FechaCreacion = LocalDateTime.now();
		this.valoracion = 0;
		this.codigo = codigoSiguiente;
		codigoSiguiente++;
	}

	protected String getTexto() {
		return texto;
	}

	//Declaro el método abstracto y lo definiré en los hijos
	abstract void setTexto(String texto) throws PublicacionException;

	@Override
	public int hashCode() {
		return Objects.hash(texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(texto, other.texto);
	}

	public LocalDateTime getFechaCreacion() {
		return FechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getLoginUsuario() {
		return usuario.getLogin();
	}

	@Override
	public String toString() {
		String resul = "Publicacion :" + this.texto + " \n" + "Realizada por :" + this.usuario.getLogin() + " \n"
				+ "Valoracion :" + this.valoracion + " \n" + "Fecha de Publicacion :" + this.FechaCreacion + " \n";
		return resul;

	}

	public boolean Valorar(String puntuacion) {
		boolean resul;
		try {
			Valoraciones v1 = Valoraciones.valueOf(puntuacion);
			this.valoracion += v1.getValoracion();
			resul = true;
		} catch (Exception e) {
			resul = false;
		}
		return resul;
	}

	public int compareTo(Publicacion p1) {
		int resul;
		resul = this.getTexto().compareTo(p1.getTexto());
		if (resul == 0) {
			resul = this.FechaCreacion.compareTo(p1.getFechaCreacion());
		}
		return resul;
	}

	public boolean isAnterior(Publicacion p1) {
		boolean resul = false;
		if (this.FechaCreacion.isBefore(p1.getFechaCreacion())) {
			resul = true;
		}
		return resul;
	}

}
