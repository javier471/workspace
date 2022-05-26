package com.jacaranda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import com.jacaranda.logistica.Tienda;
import com.jacaranda.logistica.TiendaException;
import com.jacaranda.videojuegos.NewGen;
import com.jacaranda.videojuegos.OldGen;
import com.jacaranda.videojuegos.Videojuego;

public class Pruebas {

	public static Tienda miTienda = new Tienda("Game", "Calle Mayor,1");

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws TiendaException {
		// TODO Auto-generated method stub

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/programacion_db", "root",
					"rootpass");
			DatabaseMetaData infoBD = conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			Statement insert = (Statement) conexion.createStatement();
//			String insertarTienda = "INSERT INTO TIENDA VALUES ('" + miTienda.getNombre() + "','"
//					+ miTienda.getDireccion() + "')";
//			System.out.println(insert.executeUpdate(insertarTienda));

			int opc;
			do {
				System.out.println(menu());
				System.out.println("Introduce opcion");
				opc = Integer.parseInt(teclado.nextLine());
				switch (opc) {
				case 1: {
					System.out.println("Introduzca nombre del usuario");
					String nombre = teclado.nextLine();
					System.out.println("Introduce dni");
					String DNI = teclado.nextLine();
					System.out.println("Introduce edad");
					int edad = Integer.parseInt(teclado.nextLine());
					System.out.println(miTienda.addUserBD(nombre, DNI, edad, conexion));
					break;
				}
				case 2: {
					System.out.println("Introduce nombre");
					String nombre = teclado.nextLine();
					System.out.println("Introduce precio");
					Double precio = Double.parseDouble(teclado.nextLine());
					System.out.println("Introduce genero");
					String genero = teclado.nextLine();
					System.out.println("Introduce valoracion");
					int val = Integer.parseInt(teclado.nextLine());
					System.out.println("Introduzca fecha (YYYY-MM-DD)");
					LocalDate fecha = LocalDate.parse(teclado.nextLine());
					System.out.println(miTienda.addNewGen(nombre, precio, genero, val, fecha, conexion));
					break;
				}
				case 3:
					System.out.println("Introduce nombre");
					String nombre = teclado.nextLine();
					System.out.println("Introduce precio");
					Double precio = Double.parseDouble(teclado.nextLine());
					System.out.println("Introduce genero");
					String genero = teclado.nextLine();
					System.out.println("Introduce formato");
					String formato = teclado.nextLine();
					System.out.println("Introduce precio por dia");
					Double precioDia = Double.parseDouble(teclado.nextLine());
					System.out.println(miTienda.addOldGen(nombre, precio, genero, formato, precioDia, conexion));
					break;
				case 4:
					System.out.println("Introduzca nombre del usuario a borrar");
					String nombreUser = teclado.nextLine();
					System.out.println(miTienda.delUser(nombreUser, conexion));
					break;
				case 5:
					System.out.println("Introduce nombre a buscar");
					String nombreUse = teclado.nextLine();
					System.out.println(miTienda.buscaUser(nombreUse, conexion));
					break;
				case 6:
					System.out.println("Introduce DNI de la persona a editar");
					String dni=teclado.nextLine();
					System.out.println("Introduce nuevo nombre");
					nombre=teclado.nextLine();
					System.out.println("Introduce edad");
					int edad=Integer.parseInt(teclado.nextLine());
					System.out.println(miTienda.updateUser(dni, nombre, edad, conexion));
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + opc);
				}
			} while (opc > 0 && opc <= 6);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static String menu() {
		return "1.Añadir usuario \n" + "2.Añadir NewGen\n" + "3.Añadir OldGen\n" + "4.Borrar usuario \n"
				+ "5.Buscar usuario\n" + "6.Actualizar usuario\n" + "7.Salir";
	}

}
