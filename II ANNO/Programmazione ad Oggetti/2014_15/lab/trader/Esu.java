package it.unive.dsi.po.modulob.pattern.trader;

public class Esu implements Ente {

	public double punteggio(PianoStudio ps) {
		// TODO Auto-generated method stub
		double totale = 0.0;
		for(Esame<Integer, Integer> e: ps.getEsamiSuperati()){
			totale += e.voto();
		}
		return totale;
	}

}
