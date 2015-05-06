#include <stdio.h>
#define MAXDIM 100


int push(float vet[], float **ppcima, float item) {
   if (*ppcima < vet + MAXDIM) { /*spazio nel vettore?*/
      **ppcima = item;   /*aggiungi elemento*/
      (*ppcima)++;       /*sposta la cima*/
      return 1;
   }
   else
      return 0;
}

int pop(float vet[], float **ppcima, float *pitem) {
   if (*ppcima > vet) {   /*vettore non vuoto?*/
      (*ppcima)--;        /*sposta la cima*/
      *pitem = **ppcima;  /*preleva l'item*/
      return 1;
   }
   else 
      return 0;
}

int is_empty(float vet[], float* pcima) {
   return (pcima == vet);
}

int main() {
    float miostack[MAXDIM];
    float* cima = miostack;
    float lettura;
    
    do {
       scanf("%f", &lettura);
    } while (push(miostack, &cima, lettura) && lettura!=0.0);

    while (!is_empty(miostack, cima)) {
       pop(miostack, &cima, &lettura);
       printf("%f\n", lettura);
    }
    return 0;
}

