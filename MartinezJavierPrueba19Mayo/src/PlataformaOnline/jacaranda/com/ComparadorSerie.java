package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class ComparadorSerie implements Comparator<Serie>{

	@Override
	public int compare(Serie o1, Serie o2) {
		int resul;
		if(o1.getAnno()<o2.getAnno()) {
			resul=1;
		}
		else if(o1.getAnno()>o2.getAnno()) {
			resul=-1;
		}
		else {
			resul=0;
		}
		return resul;
	}

}
