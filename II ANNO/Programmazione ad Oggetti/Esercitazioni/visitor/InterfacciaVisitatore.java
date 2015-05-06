package it.unive.dsi.po.tutorato.visitor;
 
/**
	* interfaccia generale di un visitatore di Operazioni
	*/
interface InterfacciaVisitatore{
	/**
	 * Definizione di un metodo visit per ciascuna sottoclasse di Operazione
	 */
	public void visita(Costante costante);
	public void visita(Addizione addizione);
	public void visita(Sottrazione sottrazione);
	public void visita(Moltiplicazione moltiplicazione);
	public void visita(Divisione divisione);
}

