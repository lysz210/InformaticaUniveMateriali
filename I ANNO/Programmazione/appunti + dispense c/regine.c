#include <stdio.h>

void inizializza(int scac[][8]) {
    int r, c;
    for (r = 0; r < 8; r++)
	    for (c=0; c<8; c++)
		    scac[r][c] = 0;
}

void stampa_scac(int scacchiera[][8]) {
	int r,c;
	for (r=0; r<8; r++){
		for (c=0; c<8; c++)
			if (scacchiera[r][c] == -1)
				printf(" Q ");
			else{
				printf(" . ");
				/*printf(" %d ", scacchiera[r][c]);*/
			}
		printf("\n");
	}
}


/*Algoritmo da ottimizzare: serve scorrere tutta la scacchiera?*/
void posiziona_regina(int scac[][8], int r, int c) {

	int i, j;
	for (i=0; i<8; i++)
		for (j=0; j<8; j++)
			if ((i+j == r+c) || (i-j == r-c) || i==r || j==c) { 
			       scac[i][j]+=1;
			}
	scac[r][c] = -1;
}



/*Algoritmo da ottimizzare: serve scorrere tutta la scacchiera?*/
void rimuovi_regina(int scac[][8], int r, int c) {
	int i, j;
	for (i=0; i<8; i++)
		for (j=0; j<8; j++)
			if ((i+j == r+c) || (i-j == r-c) || i==r || j==c) 
			       scac[i][j]-=1;
	scac[r][c] = 0;
}


int regine(int scac[][8], int colonna) {
   int c;
/*   stampa_scac(scac);
   scanf("%d", &c);*/  /*Decommentare per seguire passo passo l'algoritmo*/
   if (colonna == 8)
	return 1;
   else {
	int i=0; int trovato = 0;
	while (i<8 && !trovato) {
		if (scac[i][colonna] == 0) {
			posiziona_regina(scac, i, colonna);
			trovato = regine(scac, colonna + 1);
			if (!trovato) 
				rimuovi_regina(scac, i, colonna);
		}
		i++;
	}
	return trovato;
   }
}

int main() {
	int scacchiera[8][8];	
	inizializza(scacchiera);
	if (regine(scacchiera, 0)) {
		stampa_scac(scacchiera);
	}
	else {
		printf("Nessuna soluzione trovata\n");
	}
	return 0;	
}
