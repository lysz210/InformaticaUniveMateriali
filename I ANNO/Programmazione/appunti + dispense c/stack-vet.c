#include<stdio.h>

#define MAXDIM 100

int push(float vet[], int* ptop, float item) {
   if (*ptop < MAXDIM) { /*ok spazio*/
      vet[*ptop] = item;
      (*ptop)++;
      return 1;
   }
   else /* stack overflow */ 
      return 0;
}

int pop(float vet[], int* ptop, float* pitem) {
   if (*ptop > 0) { /*stack non vuoto*/
      (*ptop)--;
      *pitem = vet[*ptop];
      return 1;
   }
   else /*stack underflow*/
      return 0;
}

int is_empty(int top) {
   return (top==0);
}

int main() {
    float miostack[MAXDIM];
    int cima = 0;
    float lettura;
    do {
       scanf("%f", &lettura);
    } while (push(miostack, &cima, lettura) && lettura!=0.0);
    
    while (!is_empty(cima)) {
       pop(miostack, &cima, &lettura);
       printf("%f \n", lettura);
    }
    return 0;
 }

