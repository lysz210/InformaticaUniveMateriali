#include <stdio.h>
#define DIM 6

int main() {
	int i, v1[DIM], v2[DIM], somma[DIM];
	
	for (i = 0; i < DIM; i++) {
		printf("Primo vettore - Elemento %d: ", i);
		scanf("%d", &v1[i]);
	}
	for (i = 0; i < DIM; i++) {
		printf("Secondo vettore - Elemento %d: ", i);
		scanf("%d", &v2[i]);
	}
	for (i = 0; i < DIM; i++)
		somma[i] = v1[i] + v2[i];
	for (i = 0; i < DIM; i++)
		printf("Vettore somma - Elemento %d: %d\n", i, somma[i]);

	return 0;
}