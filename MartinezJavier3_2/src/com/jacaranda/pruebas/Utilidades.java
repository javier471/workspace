package com.jacaranda.pruebas;

public class Utilidades {

	public static <T> void copiarArray(T[] origen, T[] destino) {
		int tamanno=Math.min(origen.length, destino.length);
		for(int i=0;i<tamanno;i++) {
			destino[i]=origen[i];
		}
	}
	
	public static <T> String toString(T[] array) {
		StringBuilder resul=new StringBuilder();
		for(int i=0;i<array.length;i++) {
			if(array[i]!=null) {
				resul.append(array[i]+" ");
			}
		}
		return resul.toString();
	}
	
}
