#include <stdlib.h>
#include "stack.h"

typedef struct node{  /* tipo del nodo della lista */
  int info;
  struct node *next;
} Node;

typedef Node * List;  /* tipo lista utilizzato per memorizzare gli elementi */ 

struct stack{         /* tipo dello stack realizzato con puntatori */
  List contents;
  int size;
};


/*post: costruisce uno stack vuoto */
Stack initstack(){
  
  Stack s;
  s = malloc(sizeof(struct stack));
  s->contents = NULL;
  s->size = 0;
  return s;
}

/*post: ritorna 1 se lo stack e' vuoto, 0 altrimenti */
int stackempty(Stack s){

  return s->contents == NULL;
}

/*post: inserisce elem in cima allo stack */
void push(Stack s, int elem){

  List temp;
  
  temp = malloc(sizeof(Node));
  temp->info = elem;
  temp->next = s->contents;
  s->contents = temp;
  (s->size)++;
}

/*pre: stack non vuoto */
/*post: ritorna e rimuove l'elemento in cima allo stack */
int pop(Stack s){
  
  int ris;
  List temp;

  temp = (s->contents);
  s->contents = temp->next;
  ris = temp->info;
  free(temp);
  (s->size)--;
  return ris;
}

/*pre: stack non vuoto */
/*post: ritorna l'elemento in cima allo stack */
int top(Stack s){
  
  return s->contents->info;
}


/*post: ritorna il numero di elementi nello stack */
int size(Stack s){
  return s->size;
}

