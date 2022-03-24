package ejercicioEquipos;

import java.util.HashSet;
import java.util.Set;

public class Equipo {

	private String nombre;
	private Set<Alumno> listado;

	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.listado = new HashSet<Alumno>();
	}

	public void addAlumno(Alumno a) throws EquipoException {
		if (listado.contains(a) || a == null) {
			throw new EquipoException("El alumno ya existe");
		} else {
			listado.add(a);
		}
	}

	public void removeAlumno(Alumno a) throws EquipoException {
		listado.remove(a);
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listado=" + listado + "]";
	}

}
