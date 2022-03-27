package ejercicioEquipos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Equipo {

	private String nombre;
	private Set<Alumno> listado;

	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado = new HashSet<Alumno>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addAlumno(Alumno a) throws EquipoException {
		if (listado.contains(a) || a == null) {
			throw new EquipoException("El alumno ya existe");
		} else {
			listado.add(a);
		}
	}

	private boolean borrarUnAlumno(String nombre) {
		boolean encontrado = false;
		Iterator<Alumno> siguiente = listado.iterator();
		while (siguiente.hasNext() && !encontrado) {
//		for(Alumno a:listado) {
			Alumno a = siguiente.next();
			if (a.getNombre().equalsIgnoreCase(nombre)) {
				listado.remove(a);
				encontrado = true;
			}
		}
		return encontrado;
	}

	public void removeAlumno(String nombre) {
		while (borrarUnAlumno(nombre)) {
		}

	}

	public void removeAlumno(Alumno a) throws EquipoException {
		if (!listado.remove(a) || a == null) {
			throw new EquipoException("No se puede borrar el alumno");
		}
	}

	public Alumno existeAlumno(Alumno a) throws EquipoException {
		if (a == null) {
			throw new EquipoException("Alumno no válido");
		}
		if (listado.contains(a)) {
			Alumno aux = new Alumno(a.getNombre(), a.getDNI());
			return aux;
		} else {
			return null;
		}
	}

	public String mostrarEquipo() {
		return listado.toString();
	}

	public Equipo unionEquipos(Equipo e1) throws EquipoException {
		Equipo aux = new Equipo("Union :" + this.nombre + e1.nombre);
		//Añade los del primer equipo
		for (Alumno a : listado) {
			aux.addAlumno(a);
		}
		//Añade los del segundo, si está repetido no lo añade
		for (Alumno a : e1.listado) {
			aux.addAlumno(a);
		}
		return aux;

	}
	/**
	 * 
	 * @param e1
	 * @return
	 * @throws EquipoException
	 */
	public Equipo interseccionEquipos(Equipo e1) throws EquipoException {
		Equipo aux=new Equipo("Interseccion :" +this.nombre+e1.nombre);
		for(Alumno a:listado) {
			if(e1.listado.contains(a)) {
				aux.addAlumno(a);
			}
		}
		return aux;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}

}
