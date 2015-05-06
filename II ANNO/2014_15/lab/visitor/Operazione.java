package it.unive.dsi.po.tutorato.visitor;

/**
 * interfaccia per le operazioni di aritmetica
 */
public interface Operazione{
	/**
	 * funzione che permette al visitor di attraversare la struttura dati
	 * @param visitatore		Oggetto che attraversa l'espressione composto da operazioni
	 * 											ed eseguira' una qualche task
	 */
	public void accetta(InterfacciaVisitatore visitatore);
}
