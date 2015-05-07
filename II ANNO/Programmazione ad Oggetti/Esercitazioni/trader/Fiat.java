package it.unive.dsi.po.modulob.pattern.trader;

public class Fiat implements Ente {
	
	public double punteggio(PianoStudio ps) {
		// TODO Auto-generated method stub
		return ps.getEsamiSuperati().size();
	}

}
