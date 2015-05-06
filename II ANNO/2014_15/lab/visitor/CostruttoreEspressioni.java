package it.unive.dsi.po.tutorato.visitor;

/**
 * creatore di nuove espressioni
 * il metodo analizza valuta l'espressione
 * in notazione prefissa da tastiera
 */
public class CostruttoreEspressioni{
	
	/**
	 * analizza una stringa da stdin
	 * in notazione prefissa in un'albero di espressione
	 * composto da nodi Operazioni.
	 * Si presuppone che la stringa inserita sia ben formattata in quanto
	 * non si effettuano verifiche sulla correzza dell'espressione passata
	 * @param input		oggetto che permette l'inserimento da tastiera
	 * @return 				un'albero binario che rappresenta l'espressione passata in input
	 */
	public static Operation analizza(Scanner input){

		Operation resulto = new Constant(0);   /* valore di default per u'espressione */
		if(input.hasNextDouble()){ /* il valore letto sara' un double */
			double valore = input.nextDouble();   /* recupero del valore */
			resulto = new Constante(valore);   /* costruzione della Costante con il valore letto */
		}else{ /* il prossimo valore letto non e' un double, supponendo che sia una stringa ben formattata posso fare i prosswimi passaggi */
			/* creazione di un nodo di tipo dell'operazione richiesta */
			String operazione = input.next(); /* lettura del segno di operazione */
			if(operazione.equals("+")){ /* segno trovato e' un addizione */
				resulto = new Addizione(CostruttoreEspressioni.analizza(input), CostruttoreEspressioni.analizza(input));
			}else if(operazione.equals("-")){ /* segno trovato e' una sottrazione */
				resulto = new Sottrazione( CostruttoreEspressioni.analizza(input), CostruttoreEspressioni.analizza(input));
			}else if(operazione.equals("*")){ /* segno trovato e' una moltiplicazione */
				resulto = new Moltiplicazione( CostruttoreEspressioni.analizza(input), CostruttoreEspressioni.analizza(input));
			}else if(operazione.equals("/")){ /* segno trovato e' una divisione */
				resulto = new Divisione( CostruttoreEspressioni.analizza(input),  CostruttoreEspressioni.analizza(input));
			}
			
		}
		return resulto;
		
	}	
}