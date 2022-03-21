package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
		setTexto(texto);
	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto.length() > 50) {
			throw new PublicacionException("No se puede crear un tweet de esa longitud");
		} else {
			this.texto = texto;
		}
	}
	@Override
	public boolean Valorar(String puntuacion) {
		boolean resul;
		try {
			Valoraciones v1=Valoraciones.valueOf(puntuacion);
			this.valoracion+=v1.getValoracion()*2;
			resul=true;
		}
		catch (Exception e) {
			resul=false;
		}
		return resul;
	}

	@Override
	public String toString() {
		String resul="Tweet \n"+
				"Publicacion :"+this.texto+" \n"+
				"Realizada por :"+super.usuario.getLogin()+" \n"+
				"Valoracion :"+this.valoracion+" \n"+
				"Fecha de Publicacion :"+super.getFechaCreacion()+" \n";
		return resul;
				
	}	

}
