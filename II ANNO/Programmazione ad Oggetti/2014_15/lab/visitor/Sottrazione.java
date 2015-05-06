 package it.unive.dsi.po.tutorato.visitor;

/**
 * Nodo che rappresenta un'addisione
 */
class Sottrazione implements Operazione{
	/**
	 * ramo sinistro che puo'
	 * essere una espressione qualunque
	 */
	private Operazione ramoSX;
	
	/**
	 * ramo destro che puo' essere
	 * una espressione qualunque
	 */
	private Operazione ramoDX;
	
	/**
	 * costruttore
	 * si possono costruire nuove addizioni solo avendo 2 espressioni
	 * @param sinistro		espressione per il ramo sinistro
	 * @param destro			espressione per il ramo destro
	 */
	public Sottrazione(Operazione sinistro, Operazione destro){
		ramoSX = sinistro;
		ramoDX = destro;
	}
	
	/**
	 * restituisce il ramo sinistro dell'albero delle espressioni
	 * @return ramo sinistro
	 */
	public Operazione getRamoSX(){
		return ramoSX;
	}
	/**
	 * restituisce il ramo destro dell'albero delle espressioni
	 * @return ramo destro
	 */
	public Operazione getRamoDX(){
		return ramoDX;
	}
	
	/**
	 * punto di accesso per il visitatore
	 * questa funzione permette al visitatore di selezione l'operazione
	 * da eseguire.
	 * @param visitatore		il visitatore che deve attraversare l'espressione
	 */
	public void accetta(InterfacciaVisitatore visitatore){
		visitatore.visita(this);
	}
}
