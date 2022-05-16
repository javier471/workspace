package com.jacaranda.main;

import java.io.File;

import java.util.HashSet;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import com.jacaranda.logica.Calle;
import com.jacaranda.logica.Caseta;

public class Main {

	public static HashSet<Calle> recintoFerial = new HashSet<>();

	public static void main(String[] args) {

		File archivo = new File("ficheros//casetas.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(archivo);

			// Normalizamos el documento
			doc.getDocumentElement().normalize();

			// Cojo y meto en una NodeList todos los elementos "DatosLeidos"
			NodeList hijos = doc.getElementsByTagName("DatosLeidos");

			for (int i = 0; i < hijos.getLength(); i++) {
				Element hijo = (Element) hijos.item(i);
				if (hijo.getNodeType() == Element.ELEMENT_NODE) {
					// Me devuelve un String y para crear una caseta necesito
					// pasarle un objeto Calle
					Calle aux = new Calle(hijo.getElementsByTagName("CALLE").item(0).getTextContent(),
							Integer.valueOf(hijo.getElementsByTagName("ID_CALLE").item(0).getTextContent()));
					Caseta c = new Caseta(hijo.getElementsByTagName("TITULO").item(0).getTextContent(), aux,
							Integer.valueOf(hijo.getElementsByTagName("NUMERO").item(0).getTextContent()),
							Integer.valueOf(hijo.getElementsByTagName("MODULOS").item(0).getTextContent()),
							hijo.getElementsByTagName("CLASE").item(0).getTextContent(),
							Integer.valueOf(hijo.getElementsByTagName("ID").item(0).getTextContent()));

					aux.addCaseta(c);
					recintoFerial.add(aux);

				}
				

			}
			
			for(Calle c:recintoFerial) {
				System.out.println(c);
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public String muestraMenu() {
		return "1. Mostrar todas las casetas existentes en una calle.\n"
				+ "2. Mostrar todas las casetas de tipo familiar. \n"
				+ "3. Mostrar todas las casetas de tipo Distrito. \n"
				+ "4. Mostrar todas las casetas que no sean ni familiares ni distritos. \n"
				+ "5. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo familiar que existen. \n"
				+ "6. Mostrar para cada una de las calles del recinto ferial el número de casetas de tipo Distrito que existen. \n"
				+ "7. Eliminar una caseta.\n"
				+ "8. Salir.\n";
	}

	public String mostrarCasetasCalle(String calle) {
		StringBuilder resul = new StringBuilder();
		boolean encontrado = false;
		Iterator<Calle> siguiente = recintoFerial.iterator();
		while (siguiente.hasNext() && !encontrado) {
			Calle aux = siguiente.next();
			if (calle.equalsIgnoreCase(aux.getNombre())) {
				resul.append(aux.mostrarCasetas());
				encontrado = true;
			}
		}
		return resul.toString();
	}

	
	public String casetasFamiliar() {
		StringBuilder resul=new StringBuilder();
		for(Calle c:recintoFerial) {
			resul.append(c.muestraCasetasFamiliar());		}
		
		return resul.toString();
	}
	
	public String casetasDistrito() {
		StringBuilder resul=new StringBuilder();
		for(Calle c:recintoFerial) {
			resul.append(c.muestraCasetasDistrito());		}
		
		return resul.toString();
	}
	
	public String casetasDistinta() {
		StringBuilder resul=new StringBuilder();
		for(Calle c:recintoFerial) {
			resul.append(c.muestraCasetasDistintas());		}
		
		return resul.toString();
	}
	
	public int numCasetasFamiliares() {
		int cont=0;
		for(Calle c:recintoFerial) {
			for(Caseta aux:c.listadoCasetas()) {
				if(aux.getClase().equals("FAMILIAR")) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	public int numCasetasDistrito() {
		int cont=0;
		for(Calle c:recintoFerial) {
			for(Caseta aux:c.listadoCasetas()) {
				if(aux.getClase().equals("DISTRITO")) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	
	private Calle buscaCalle(String calle) {
		boolean encontrado=false;
		Calle busca=null;
		Iterator<Calle> siguiente=recintoFerial.iterator();
		while(siguiente.hasNext() && !encontrado) {
			Calle aux=siguiente.next();
			if(aux.getNombre().equalsIgnoreCase(calle)) {
				busca=aux;
				encontrado=true;
			}
		}
		return busca;
	}
	
	public boolean eliminarCaseta(String calle, String caseta) {
		boolean encontrado=false;
		Calle aux=buscaCalle(calle);
		encontrado=aux.eliminarCaseta(caseta);
		return encontrado;
	}
}
