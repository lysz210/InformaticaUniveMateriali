package it.unive.dsi.po.modulob.pattern.trader;

public class FiatCreator implements Creator {
	private FiatCreator(){}
	public Ente create(TipoEnte t) {
		// TODO Auto-generated method stub
		return TipoEnte.FIAT.equals(t) ? new Fiat() : null;
	}
	
	/*
	 * registrazione del creator all'interno della map in trader
	 */
	static{
		EnteTrader.add(TipoEnte.FIAT, new FiatCreator());
	}

}
