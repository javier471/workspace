package PlataformaOnline.jacaranda.com;

import java.util.Comparator;

public class ComparaTemporadas implements Comparator<Temporada>{

	@Override
	public int compare(Temporada o1, Temporada o2) {
		int resul;
		if(o1.getNotaMedia()>o2.getNotaMedia()) {
			resul=1;
		}
		else if(o1.getNotaMedia()<o2.getNotaMedia()) {
			resul=-1;
		}
		else {
			resul=0;
		}
		return resul;
	}

}
