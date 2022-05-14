package com.jacaranda.main;

import java.io.File;

import java.util.HashSet;

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
			NodeList hijos=doc.getElementsByTagName("DatosLeidos");
			

			for(int i=0;i<hijos.getLength();i++) {
				Element hijo=(Element) hijos.item(i);
				if(hijo.getNodeType()==Element.ELEMENT_NODE) {
					//Me devuelve un String y para crear una caseta necesito 
					// pasarle un objeto Calle
					Calle aux=new Calle(hijo.getElementsByTagName("CALLE").item(0).getTextContent(),Integer.valueOf(hijo.getElementsByTagName("ID_CALLE").item(0).getTextContent()));
					Caseta c=new Caseta(hijo.getElementsByTagName("TITULO").item(0).getTextContent(),
							aux,
							Integer.valueOf(hijo.getElementsByTagName("NUMERO").item(0).getTextContent()),
							Integer.valueOf(hijo.getElementsByTagName("MODULOS").item(0).getTextContent()), 
							hijo.getElementsByTagName("CLASE").item(0).getTextContent(),
							Integer.valueOf(hijo.getElementsByTagName("ID").item(0).getTextContent()));
					
					aux.addCaseta(c);
					System.out.println(recintoFerial.add(aux));
				}
				
			}
			
			StringBuilder resul=new StringBuilder();
			for (Calle c:recintoFerial) {
				resul.append(c.toString());
			}
			System.out.println(resul.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
