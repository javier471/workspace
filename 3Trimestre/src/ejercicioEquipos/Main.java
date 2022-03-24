package ejercicioEquipos;

public class Main {

	public static void main(String[] args) throws EquipoException {

		Alumno a1=new Alumno("Paco","3212");
		Equipo e1=new Equipo("Team");
		
		e1.addAlumno(a1);

	}

}
