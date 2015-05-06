package it.unive.dsi.po.modulob.pattern.trader;

public class Studente {
	private final PianoStudio ps = new PianoStudio();
	Integer mattricola;
	String nome;
	String cognome;
	
	Studente(int mattricola, String nome, String cognome){
		this.mattricola = mattricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public PianoStudio getPiano(){
		return this.ps;
	}
	
	public void addVoto(int v){
		ps.addEsame(mattricola, v);
	}
	
	public String toString(){
		return "Studente<" + mattricola + ", " + nome + ", " + cognome + ">"; 
	}
}
