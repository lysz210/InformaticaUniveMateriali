package it.unive.dsi.po.tutorato.visitor;

/**
 * esegue visita un'espressione e lo converte in notazione infissa
 */
public class VisitatoreInfisso implements InterfacciaVisitatore{
	/**
	 * stringa che conserva la rappresenzatione infissa dell'espressione
	 */
	private String espressione = "";
	
	public void visita(Costante costante){
		espressione += costante.getValue();
	}
	public void visita(Addizione addizione){
		espressione += "(";   /* apertura della parentesi */
		addizione.getRamoSX().accetta(this); /* ricostruzione del ramo sinistro */
		espressione += " + "; /* aggiunta del segno dell'operazione */
		addizione.getRamoDX().accetta(this); /* ricostruzione del ramo destro */
		espressione += ")"; /* chiusura della parentesi */
	}
	public void visita(Sottrazione sottrazione){
		espressione += "(";   /* apertura della parentesi */
		addizione.getRamoSX().accetta(this); /* ricostruzione del ramo sinistro */
		espressione += " - "; /* aggiunta del segno dell'operazione */
		addizione.getRamoDX().accetta(this); /* ricostruzione del ramo destro */
		espressione += ")"; /* chiusura della parentesi */
	}
	public void visita(Moltiplicazione moltiplicazione){
		espressione += "(";   /* apertura della parentesi */
		addizione.getRamoSX().accetta(this); /* ricostruzione del ramo sinistro */
		espressione += " * "; /* aggiunta del segno dell'operazione */
		addizione.getRamoDX().accetta(this); /* ricostruzione del ramo destro */
		espressione += ")"; /* chiusura della parentesi */
	}
	public void visita(Divisione divisione){
		espressione += "(";   /* apertura della parentesi */
		addizione.getRamoSX().accetta(this); /* ricostruzione del ramo sinistro */
		espressione += " / "; /* aggiunta del segno dell'operazione */
		addizione.getRamoDX().accetta(this); /* ricostruzione del ramo destro */
		espressione += ")"; /* chiusura della parentesi */
	}
	
	/**
	 * @return espressione
	 */
	public String toString(){
		return espressione;
	}
}