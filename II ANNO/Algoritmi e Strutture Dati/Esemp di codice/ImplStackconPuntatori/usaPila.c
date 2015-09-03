#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main(){

  Stack s;
  int x, i;

  s = initstack();

  for (i = 1; i <= 5; i++)
    push(s, i);
  
  while (!stackempty(s)){
    x = pop(s);
    printf("%d\n", x);
  }
  
  return EXIT_SUCCESS;
}
