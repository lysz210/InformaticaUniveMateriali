#include <stdio.h>
#define INDIM 20
#define CASELLE 8

int main() {
	char input[INDIM];                              /* Vettore contenente la stringa FEN letta. */
	char output[CASELLE + 1];                       /* Vettore contenente la corrispondente stringa. */
	char pedine[] = {'R', 'K', 'Q', 'B', 'P', 'N'}; /* Nomi (maiuscoli) delle diverse pedine. */
	int i = 0;                                      /* Indice usato sulla stringa letta in input. */
	int o = 0;                                      /* Indice usato sulla stringa da stampare in output. */
	int k;
	int corretto = 1;                               /* Viene azzerato quando si incontra un carattere non valido oppure o si supera il numero massimo di caselle. */

	/* Leggi in input la stringa. '%19s' significa 'leggi al massimo 19 caratteri' dallo standard input
	   (una in meno della dimensione del vettore, visto che una cella serve per il terminatore '\0'). */
	printf("Inserisci una stringa in notazione FEN: ");
	scanf("%19s", input);

	/* Cicla finché ci sono caratteri da leggere e non si è ancora verificato alcun errore. */
	while (input[i] && corretto) {
		if (input[i] >= '1' && input[i] <= '8') {
			/* Inserisci il numero di '.' specificato dalla cifra letta, se ci sono caselle
			   a sufficienza, altrimenti errore. */
			if (o + (input[i] - '0') > CASELLE)
				corretto = 0;
			else
				for (k = 0; k < input[i] - '0'; k++) {
					output[o] = '.';
					o++;
				}
		} else if (o < CASELLE) {
			k = 0;
			/* Ricerca il carattere letto (non cifra) tra quelli consentiti. */
			while (k < 6 && input[i] != pedine[k] && input[i] != pedine[k] - 'A' + 'a')
				k++;
			/* Se k == 6, il carattere non è consentito: errore. In caso contrario,
			   inseriscilo nella stringa. */
			if (k == 6)
				corretto = 0;
			else {
				output[o] = input[i];
				o++;
			}
		} else
			/* Nessuna posizione libera: errore. */
			corretto = 0;
		i++;
	}

	/* Se è stato riempito un numero di caselle diverso da quello corretto oppure è stato
	   rilevato un errore durante l'elaborazione della stringa in input, stampa il messaggio
	   d'errore. Altrimenti inserisci il carattere terminatore nella stringa e stampala in output. */
	if (o != CASELLE || !corretto)
		printf("La stringa data non e' corretta.\n");
	else {
		output[CASELLE] = '\0';
		printf("%s\n", output);
	}

	return 0;
}