package com.jacaranda.vehiculos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static Vehiculo[] vehiculos=new Vehiculo[200];
	
	public static Scanner teclado=new Scanner(System.in);
	
	public static int num=0;
	
	public static void menu() {
		System.out.println("1. Dar de alta vehiculo\n"
				+ "2. Cálculo precio de alquiler\n"
				+ "3. Salir");
	}
		
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		menu();
		System.out.println("Introduzca opcion");
		int opc=Integer.parseInt(teclado.nextLine());
		do {
			if(opc==1) {
				System.out.println("Introduzca matricula");
				String matricula=teclado.nextLine();
				System.out.println("Introduzca tipo de gama (Baja,Media,Alta)");
				String gama=teclado.nextLine();
				System.out.println("Introduzca fecha de devolucion del vehiculo (YYYY-MM-DD)");
				String fecha=teclado.nextLine();
				LocalDate f=LocalDate.parse(fecha);
				Vehiculo v1=new Vehiculo(matricula, gama, f);
				vehiculos[num]=v1;
				num++;				
			}
			else {
				System.out.println("Introduzca matricula");
				String matricula=teclado.nextLine();
				boolean encontrado=false;
				for(int i=0;i<vehiculos.length&& !encontrado;i++) {
					if(vehiculos[i].getMatricula().equals(matricula)) {
						encontrado=true;
						System.out.println(vehiculos[i].getPrecio());
					}
				}
				if(!encontrado) {
					System.out.println("Matricula no encontrada");
				}
			}
			menu();
			System.out.println("Introduzca opcion");
			opc=Integer.parseInt(teclado.nextLine());
		}while(opc!=3);
		
		
		
		
		
		
//		LocalDate fecha=LocalDate.parse("2022-04-03");
//		Vehiculo v1=new Vehiculo("dwimdj","BAJA",fecha);	
//		System.out.println(v1.getPrecio());
		
		
		
	}

}
