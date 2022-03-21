package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {

	private int numeroEstrellas;

	public Recomendacion(String texto, Usuario usuario, int numEstrellas) throws PublicacionException {
		super(texto, usuario);
		setTexto(texto);//Se pasa el setTexto() para que si no cumple la longitud no lo cree
		this.numeroEstrellas = numEstrellas;
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto.length() < 100 || texto.length() > 200) {
			throw new PublicacionException("No se puede crear una publicacion con esa longitud de carcteres");
		} else {
			this.texto = texto;
		}
	}

	@Override
	public String toString() {
		String resul = "Recomendacion \n" + "Publicacion :" + this.texto + " \n" + "Realizada por :"
				+ super.usuario.getLogin() + " \n" + "Valoracion :" + this.valoracion + " \n" + "Fecha de Publicacion :"
				+ super.getFechaCreacion() + " \n" + "Numero estrellas :" + this.numeroEstrellas;

		return resul;
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	@Override
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

}
