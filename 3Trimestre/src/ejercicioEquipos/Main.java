package ejercicioEquipos;

public class Main {

	public static void main(String[] args) throws EquipoException {

		Alumno a1=new Alumno("Paco","3212");
		Alumno a2=new Alumno("Pepe","3333");

		Equipo e1=new Equipo("Team");
		Equipo e2=new Equipo("Equipo");
		
		e1.addAlumno(a1);
		e2.addAlumno(a2);
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e1.unionEquipos(e2));
		

	}

}
