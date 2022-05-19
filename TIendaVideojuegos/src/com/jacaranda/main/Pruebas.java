package com.jacaranda.main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Connection conexion = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/programacion_db","root", "rootpass");
			DatabaseMetaData infoBD= conexion.getMetaData();
			System.out.println("Base de datos: " + infoBD.getDatabaseProductName());
			System.out.println("Version: " + infoBD.getDatabaseProductVersion());
			} catch (SQLException ex) {
			// Tratar el error
			}
	}

}
