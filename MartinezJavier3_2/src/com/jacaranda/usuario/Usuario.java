package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {

	private String login;
	private String pass;

	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public boolean setPass(String viejaPass, String nuevoPass) {
		boolean resul = false;
		if (this.pass.equals(viejaPass)) {
			this.pass = nuevoPass;
			resul = true;
		}
		return resul;
	}

	//Devuelve true si el pass introducido coincide con el de la clase
	public boolean checkPass(String password) {
		boolean resul = false;
		if (this.pass.equals(password)) {
			resul = true;
		}
		return resul;
	}

	@Override
	public int hashCode() {
		return Objects.hash(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}

}
