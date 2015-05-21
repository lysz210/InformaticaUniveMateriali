#include <stdio.h>
#define DIMSTR 16
#define DIMMAT 4

void copia_ip(char ip[], char mat[][DIMMAT]) {
	int i = 0, r = 0, c = 0;
	/* Scorri la stringa fino a che non raggiungi il carattere terminatore. */
	while (ip[i]) {
		if (ip[i] == '.') {
			/* Se il carattere corrente è un '.', inserisci lo '\0' e passa alla prima
			posizione della riga successiva. */
			mat[r][c] = '\0';
			r++;
			c = 0;
		} else {
			/* Altrimenti copia la cifra e passa alla colonna successiva della stessa
			riga. */
			mat[r][c] = ip[i];
			c++;
		}
		i++;
	}
	/* Inserisci lo '\0' nell'apposita posizione nell'ultima riga. */
	mat[r][c] = '\0';
}

int main() {
	char ip[DIMSTR];
	char matrice[DIMMAT][DIMMAT];
	int r;

	/* Leggi l'ip da standard input: visto che un ip corretto è composto da
	al più 15 caratteri, ne accettiamo solo 15. In ogni caso assumiamo che
	l'indirizzo letto sia valido. */
	printf("Inserisci un indirizzo IP valido: ");
	scanf("%15s", ip);
	/* Copia l'ip nella matrice. */
	copia_ip(ip, matrice);
	/* Stampa le righe della matrice generata. */
	for (r = 0; r < DIMMAT; r++)
		printf("%s\n", matrice[r]);

	return 0;
}