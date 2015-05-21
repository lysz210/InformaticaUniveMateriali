// Learn more about F# at http://fsharp.net

module esercitazione3

// Esercizio 1

let rec sumto = fun n ->
    match n with
    |0 -> 0
    |n when n >= 0 -> n + ( sumto(n-1) )
    |_ -> failwith "L'argomento deve essere positivo";;



// Esercizio 2

let rec stringcopy = fun (s:string) (n:int) ->
    match n with
    |0 -> ""
    |n when n < 0 -> failwith "n deve essere positivo"
    |n when n > 0 -> s+(stringcopy s (n-1));;


// Esercizio 3

let rec sumbetween = fun n m ->
    match n with
    |n when n > m -> 0
    |_ -> m + (sumbetween n (m-1));;