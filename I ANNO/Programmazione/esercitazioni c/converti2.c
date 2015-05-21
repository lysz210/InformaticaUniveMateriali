//Costante che esprime a quanti grammi corrisponde un'oncia
#define ONCIA_GRAMMI 28.5
//Costante che esprime a quanti grammi corrisponde una libbra
#define LIBBRA_GRAMMI 453.6
//Costante che esprime a quante ONCE corrisponde una libbra
#define LIBBRA_ONCE 16.0

float converti2(float peso, char in,char out){
	
	float conversione;
	/**usare il costrutto switch per determinare che genere di conversione**/
		
		switch (in) {
			case 'o': switch(out){
						case 'g':conversione = peso * ONCIA_GRAMMI;break;
						case 'k':conversione = (peso * ONCIA_GRAMMI) /1000.0; break;
						case 'o':conversione = peso;break;
						case 'l':conversione = peso / LIBBRA_ONCE; break;
					}
					break;

			case 'l': switch(out){
						case 'g':conversione = peso * LIBBRA_GRAMMI;break;
						case 'k':conversione = (peso * LIBBRA_GRAMMI) /1000.0; break;
						case 'o':conversione = peso*LIBBRA_ONCE;break;
						case 'l':conversione = peso ; break;
					}
					break;
			case 'g': switch(out){
						case 'g':conversione = peso; break;
						case 'k':conversione = peso/1000.0; break;
						case 'o':conversione = peso/ ONCIA_GRAMMI; break;
						case 'l':conversione = peso / LIBBRA_GRAMMI; break;
					}
					break;
			case 'k': switch(out){
						case 'g':conversione = peso * 1000.0;break;
						case 'k':conversione = peso; break;
						case 'o':conversione = (peso / ONCIA_GRAMMI) * 1000.0;break;
						case 'l':conversione = (peso / LIBBRA_GRAMMI) * 1000.0; break;
					}
					break;
																				
												
		}
		
		return conversione;
}
