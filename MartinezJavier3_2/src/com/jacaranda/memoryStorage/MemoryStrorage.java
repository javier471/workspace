package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;


public class MemoryStrorage {
	
	private static final int NUM_MAXIMO_USUARIOS = 15;
	private static final int NUM_MAXIMO_PUBLICACIONES = 50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Publicacion[] arrayPublicaciones;
	private Usuario[] arrayUsuarios;

	public MemoryStrorage() {
		super();
		this.arrayPublicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
		this.arrayUsuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		this.numPublicacionesActuales = 0;
		this.numUsuariosActuales = 0;
	}

	private int posicionUsuario(String nombre) {
		int resul = -1; //Si no encuentra al usuario devolverá -1
		boolean encontrado = false;
		for (int i = 0; i < numUsuariosActuales && !encontrado; i++) {
			if (arrayUsuarios[i].getLogin().equals(nombre)) {
				resul = i;
				encontrado = true;
			}
		}
		return resul;
	}

	public void addUsuario(String login, String password) {
		arrayUsuarios[numUsuariosActuales] = new Usuario(login, password);
		numUsuariosActuales++;
	}

	public void addPublicacion(String texto, String login) throws PublicacionException {
		try {
		int pos = posicionUsuario(login);
		if (pos==-1) {
			throw new MemoryStorageException();
		}
		arrayPublicaciones[numPublicacionesActuales] = new Tweet(texto, arrayUsuarios[pos]);
		numPublicacionesActuales++;
		}
		catch(PublicacionException e) {
			System.out.println("No se puede crear un texto con ese texto, introduce de nuevo");
		} catch (MemoryStorageException e) {
			System.out.println("El usuario no existe");
		}
	}

	public void addPublicacion(String texto, String login, String tema) throws PublicacionException {
		int pos = posicionUsuario(login);
		arrayPublicaciones[numPublicacionesActuales] = new Post(texto, arrayUsuarios[pos], tema);
		numPublicacionesActuales++;
	}

	public void addPublicacion(String texto, String login, int numEstrellas) throws PublicacionException {
		int pos = posicionUsuario(login);
		arrayPublicaciones[numPublicacionesActuales] = new Recomendacion(texto, arrayUsuarios[pos], numEstrellas);
		numPublicacionesActuales++;
	}

	public String mostrarListaPublicaciones() {
		StringBuilder resul = new StringBuilder();
		for (int i = 0; i < numPublicacionesActuales; i++) {
			resul.append(arrayPublicaciones[i].toString() + "\n");
		}
		return resul.toString();
	}

	public String mostrarTweets() {
		StringBuilder resul = new StringBuilder();
		for (int i=0;i<numPublicacionesActuales;i++) {
			if(arrayPublicaciones[i] instanceof Tweet) {
				resul.append(arrayPublicaciones[i].toString()+"\n");
			}
		}
		return resul.toString();
	}
	
	public String mostrarPosts() {
		StringBuilder resul = new StringBuilder();
		for (int i=0;i<numPublicacionesActuales;i++) {
			if(arrayPublicaciones[i] instanceof Post) {
				resul.append(arrayPublicaciones[i].toString()+"\n");
			}
		}
		return resul.toString();
	}

	public String mostrarRecomendacion() {
		StringBuilder resul = new StringBuilder();
		for (int i=0;i<numPublicacionesActuales;i++) {
			if(arrayPublicaciones[i] instanceof Recomendacion) {
				resul.append(arrayPublicaciones[i].toString()+"\n");
			}
		}
		return resul.toString();
	}
}
