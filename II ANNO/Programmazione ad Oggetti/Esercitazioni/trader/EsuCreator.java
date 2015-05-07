package it.unive.dsi.po.modulob.pattern.trader;

public class EsuCreator implements Creator {

	private EsuCreator(){}
	
	public Ente create(TipoEnte t) {
		// TODO Auto-generated method stub
		return TipoEnte.ESU.equals(t) ? new Esu() : null;
	}

	static{
		EnteTrader.add(TipoEnte.ESU, new EsuCreator());
	}
}
