package it.unive.dsi.po.modulob.pattern.trader;

import java.util.HashMap;
import java.util.Map;

public class EnteTrader {
	static Map<TipoEnte, Creator> map = new HashMap<TipoEnte, Creator>();
	
	static public Ente create(TipoEnte t){
		Creator c = map.get(t);
		return c.create(t);
	}
	
	static public void add(TipoEnte t, Creator c){
		map.put(t, c);
	}
}
