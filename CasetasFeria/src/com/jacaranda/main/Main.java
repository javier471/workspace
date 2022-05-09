package com.jacaranda.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

	public static void main(String[] args) {

		File archivo = new File("ficheros//casetas.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = (Document) dBuilder.parse(archivo);

			// Normalizamos el documento
			doc.getDocumentElement().normalize();
		
			NodeList hijos=doc.getDocumentElement().getChildNodes();

			for(int i=0;i<hijos.getLength();i++) {
				Node hijo=hijos.item(i);
				System.out.println(hijo);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
