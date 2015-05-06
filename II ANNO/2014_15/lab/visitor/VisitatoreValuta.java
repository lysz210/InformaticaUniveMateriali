package it.unive.dsi.po.tutorato.visitor;

/**
 * visitatore che calcola il valore di un'espressione
 */
class VisitatoreValuta implements InterfacciaVisitatore{
	/**
	 * contenitore del risultato
	 */
	private double risultato = 0.0;
	
	/**
	 * metodo di accesso per recuperare il valore del risultato calcolato da questo visitatore
	 */
	public double getRisultato(){
		return risultato;
	}
	
	public void visita(Costante costante){
		risultato = costante.getValore();
	}
	public void visita(Addizione addizione){
		VisitatoreValuta parzialeDX = new VisitatoreValuta();
		VisitatoreValuta parzialeSX = new VisitatoreValuta();
		addizione.getRamoSX().accetta(parzialeSX);
		addizione.getRamoDX().accetta(parzialeDX);
		risultato = parzialeSX.getValore() + parzialeDX.getValore();
	}
	public void visita(Sottrazione sottrazione){
		VisitatoreValuta parzialeDX = new VisitatoreValuta();
		VisitatoreValuta parzialeSX = new VisitatoreValuta();
		sottrazione.getRamoSX().accetta(parzialeSX);
		sottrazione.getRamoDX().accetta(parzialeDX);
		risultato = parzialeSX.getValore() - parzialeDX.getValore();
	}
	public void visita(Moltiplicazione moltiplicazione){
		VisitatoreValuta parzialeDX = new VisitatoreValuta();
		VisitatoreValuta parzialeSX = new VisitatoreValuta();
		moltiplicazione.getRamoSX().accetta(parzialeSX);
		moltiplicazione.getRamoDX().accetta(parzialeDX);
		risultato = parzialeSX.getValore() * parzialeDX.getValore();
	}
	public void visita(Divisione divisione){
		VisitatoreValuta parzialeDX = new VisitatoreValuta();
		VisitatoreValuta parzialeSX = new VisitatoreValuta();
		divisione.getRamoSX().accetta(parzialeSX);
		divisione.getRamoDX().accetta(parzialeDX);
		risultato = parzialeSX.getValore() / parzialeDX.getValore();
	}
	
}