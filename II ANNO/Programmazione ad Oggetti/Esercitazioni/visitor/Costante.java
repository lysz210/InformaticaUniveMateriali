 
package it.unive.dsi.po.tutorato.visitor;

/**
 * reppresentazione di una costante
 * il valore e' contenuto all'interno di una variabile
 * recuperabile attraverso un metodo di accesso publico
 * con il quale il visitatore puo' recuperarne il valore
 */
class Costante implements Operazione{
	/**
	 * attributo che mantiene il valore
	 */
	private double valore;
	
	/**
	 * costruttore
	 * crea una costante dato un numero
	 * @param valore		di tipo reale
	 */
	public Costante(double valore){
		this.valore = valore;
	}
	
	/**
	 * metodo che permette il recupero del valore
	 * @return valore rappresentato da questa costante
	 */
	public double getValore(){
		return this.valore;
	}
	
	/**
	 * permette al visitare di recuperare il suo valore
	 */
	public void accetta(InterfacciaVisitatore visitatore){
		visitatore.visita(this);
	}
}