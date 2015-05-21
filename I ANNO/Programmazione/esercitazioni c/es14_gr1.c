#include <stdio.h>
#define N 3

void copia_su_stringa(char mat[][N], char str[]) {
	int i, j;
	/* Copia, carattere per carattere, dalla matrice alla stringa. */
	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++)
			str[i * N + j] = mat[i][j];
	/* Metti il terminatore di stringa nell'ultima posizione. */
	str[N * N] = '\0';
}

int main() {
	char matrice[N][N];
	char stringa[N * N + 1]; /* Il + 1 serve per riservare lo spazio al terminatore '\0'. */
	char invio;
	int i, j;

	/* Lettura della matrice da standard input. */
	printf("Lettura della matrice.\n");
	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++) {
			/* Perché due scanf? Vedi commento finale. */
			printf("Riga %d, colonna %d: ", i, j);
			scanf("%c", &matrice[i][j]);
			scanf("%c", &invio);
		}
	/* Copia la matrice nella stringa. */
	copia_su_stringa(matrice, stringa);
	/* Stampa il risultato ottenuto. */
	printf("%s\n", stringa);

	return 0;
}

/* La seconda scanf serve per "consumare" il carattere di "a capo" '\n' che
corrisponde alla pressione del tasto Invio per terminare la lettura. Se non
fosse presente e in input venisse dato il carattere 'a' seguito da Invio, dopo
prima richiesta di input, verrebbero eseguiti i seguenti assegnamenti:
	matrice[0][0] = 'a'
	matrice[0][1] = '\n'
Notare che, alla seconda iterazione (i = 0, j = 1) la scanf non bloccherebbe il
programma in attesa di input, in quanto lo standard input contiene il carattere
'\n', non è ancora stato utilizzato. */