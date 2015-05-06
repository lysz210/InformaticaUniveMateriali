package it.unive.dsi.po.modulob.pattern.trader;

public class Esame<K, V> {
	private K mattricola;
	public K mattricola(){
		return this.mattricola;
	}
	private V voto;
	public V voto(){
		return this.voto;
	}
	Esame(K matt, V voto){
		this.mattricola = matt;
		this.voto = voto;
	}
}
