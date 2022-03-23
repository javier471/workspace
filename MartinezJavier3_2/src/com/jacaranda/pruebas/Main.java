package com.jacaranda.pruebas;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class Main {

	public static void main(String[] args) throws PublicacionException {
		String[] origen= {"Manolo","Pepe","Paco"};
		String[] destino= new String[7];
		Integer[] array1Int = {10,20,30};
		Integer[] array2Int = new Integer[7];

		Utilidades.copiarArray(origen, destino);
		System.out.println(origen);
		System.out.println(Utilidades.toString(origen));
		System.out.println(Utilidades.toString(array1Int));
		
		
		
		
//		Usuario u1 = new Usuario("Pepe", "hola");
//		Publicacion p1 = new Tweet("Bienvenido", u1);
//		System.out.println(p1.toString());
//		p1.Valorar("SUPERBUENA");
//		System.out.println(p1.toString());
//		System.out.println(p1.getCodigo());
//		Publicacion p2 = new Tweet("Bienvenido", u1);
//		System.out.println(p2.getCodigo());
	}
}
