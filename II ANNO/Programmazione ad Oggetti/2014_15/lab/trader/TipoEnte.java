package it.unive.dsi.po.modulob.pattern.trader;

public class TipoEnte {
	public static final TipoEnte FIAT = new TipoEnte(1);
	public static final TipoEnte ESU = new TipoEnte(2);
	Integer tipo;
	
	public TipoEnte(int tipo){
		this.tipo = new Integer(tipo);
	}
	
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(!(o instanceof TipoEnte))
			return false;
		return tipo.equals(o);
	}
	
	public int hashCode(){
		return tipo.hashCode();
	}
}
