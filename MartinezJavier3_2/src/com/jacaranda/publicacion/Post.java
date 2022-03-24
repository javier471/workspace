package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion{
	
	
	private int numeroLecturas;
	private String tema;
	
	public Post(String texto, Usuario usuario,String tema) throws PublicacionException {
		super(texto, usuario);
		this.tema=tema;
		this.numeroLecturas=0;
	}
	
	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if(texto.isEmpty()) {
			throw new PublicacionException("No se puede crear un post en blanco");
		}
		else {
			this.texto=texto;
		}	
	}
	@Override
	public boolean Valorar(String puntuacion) {
		boolean resul;
		try {
			Valoraciones v1 = Valoraciones.valueOf(puntuacion);
			this.valoracion += v1.getValoracion();
			this.numeroLecturas++;
			resul = true;
		} catch (Exception e) {
			resul = false;
		}
		return resul;
	}

	@Override
	public String toString() {
		String resul="Post \n"+
				"Publicacion :"+this.texto+" \n"+
				"Realizada por :"+super.usuario.getLogin()+" \n"+
				"Valoracion :"+this.valoracion+" \n"+
				"Fecha de Publicacion :"+super.getFechaCreacion()+" \n"+
				"Numero de lecturas :"+this.numeroLecturas;
		return resul;
	}
	
	

}
