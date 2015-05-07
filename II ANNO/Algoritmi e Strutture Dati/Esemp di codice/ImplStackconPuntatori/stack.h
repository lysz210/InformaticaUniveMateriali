typedef struct stack * Stack;

Stack initstack();
int stackempty(Stack s);
void push(Stack s, int elem);
int pop(Stack s);
int top(Stack s);
int size(Stack s);
