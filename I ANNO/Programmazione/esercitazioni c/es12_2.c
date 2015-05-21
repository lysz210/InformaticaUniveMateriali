#include <stdio.h>
#define DIM 10

int main() {
	int i, palindromo, v[DIM];

	for (i = 0; i < DIM; i++) {
		printf("%d elemento: ", i);
		scanf("%d", &v[i]);
	}
	palindromo = 1;
	i = 0;
	while (i < DIM / 2 && palindromo) {
		if (v[i] != v[DIM - i - 1])
			palindromo = 0;
		i++;
	}
	if (palindromo)
		printf("Vettore palindromo!\n");
	else
		printf("Vettore non palindromo!\n");

	return 0;
}