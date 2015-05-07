package it.unive.dsi.po.modulob.pattern.trader;

import java.util.ArrayList;
import java.util.Collection;

public class PianoStudio{

	public ArrayList<Esame<Integer, Integer>> esamiSuperati;
	
	PianoStudio(){
		this.esamiSuperati = new ArrayList<Esame<Integer, Integer>>();
	}
	
	public void addEsame(Integer mattr, Integer voto){
		esamiSuperati.add(new Esame(mattr, voto));
	}
	
	public Collection<Esame<Integer, Integer>> getEsamiSuperati() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
