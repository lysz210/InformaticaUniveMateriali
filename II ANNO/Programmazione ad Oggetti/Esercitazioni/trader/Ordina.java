package it.unive.dsi.po.modulob.pattern.trader;

import java.util.Set;

public class Ordina {
	Ente ente = EnteTrader.create(new TipoEnte(TipoEnte.FIAT.tipo));
	
	public Studente[] ordina(Set<Studente> studenti){
		Studente[] res = new Studente[studenti.size()];
		double[] punteggi = new double[studenti.size()];
		int index = 0;
		for(Studente s: studenti){
			int i;
			double p = ente.punteggio(s.getPiano());
			for(i=0; i<index; i++){
				if(punteggi[i]<p) break;
			}
			for(int j=index; j>i; j--){
				res[j] = res[j-1];
				punteggi[j] = punteggi[j-1];
			}
			res[i] = s;
			punteggi[i] = p;
			index++;
		}
		return res;
	}
}
