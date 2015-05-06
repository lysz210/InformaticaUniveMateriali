package it.unive.dsi.po.tutorato.visitor;

import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Operazione op = CostruttoreEspressioni.analizza(input);
		VisitatoreInfisso vi = new VisitatoreInfisso();
		op.accetta(vi);
		VisitatoreValuta vv = new VisitatoreValuta();
		op.accetta(vv);
		System.out.println("valore espressione " + vi + "=" + vv);
	}
}