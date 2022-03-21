package com.jacaranda.publicacion;

public enum Valoraciones {
	
	SUPERBUENA(3),MUYBUENA(2),BUENA(1),NORMAL(0),REGULAR(-1),MUYMALA(-2);
	
	private Valoraciones(int i) {
		this.valoracion=i;
	}

	private int valoracion;

	public int getValoracion() {
		return valoracion;
	}
	
	
	
	
}
