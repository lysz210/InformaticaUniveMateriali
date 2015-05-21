

    (* cerca se c'è un elemento x in una lista (almeno uno) *)
    let rec mem n l =
        match l with
        [] -> false
        | x :: xs ->
            x = n or mem n xs;;

    mem 3 [5; 1; 3; 7; 3];;
    mem 4 [5; 1; 3; 7; 3];;



    (* for_all, predicato vero per tutti gli elementi della lista *)
    let rec for_all p l =
        match l with
        [] -> true
        | x :: xs -> p x & for_all p xs;;

    for_all (fun x -> x > 0) [3; 5; 1];;
    for_all (fun x -> x > 0) [3; -4; 1];;



    (* exists, predicato vero per almeno un elemento della lista *)
    let rec exists p l =
        match l with
        [] -> false
        | x :: xs -> p x or exists p xs;;

    exists (fun x -> x > 0) [3; -5; -1];;
    exists (fun x -> x > 0) [-3; -4; -1];;



    (* map, applica una funzione a tutti gli elementi di una lista *)
    let rec map f l =
        match l with
        [] -> []
        | x :: xs -> f x :: map f xs;;
    (* ('a -> 'b) -> 'a list -> 'b list *)

    map (fun x -> x + 1) [1; 2; 3];; (* funzione successore *)



    (* filter, tieni gli elementi della lista che soddisfano un predicato *)
    let rec filter p l =
        match l with
        [] -> []
        | x :: xs ->
            if p x
                then x :: filter p xs
                else filter p xs;;
    (* ('a -> bool) -> 'a list -> 'a list *)

    filter (fun x -> x > 2) [1; 2; 3];; (* 3 *)
    filter ((<) 2) [1; 2; 3];; (* 2 < x, restituisce 3 > 2 *)
    filter ((>) 2) [1; 2; 3];; (* 2 > x, restituisce 1 < 2 *)



    (* togliere doppi *)
    let rec togli_doppi l =
        match l with
        [] -> []
        | x :: xs -> x :: togli_doppi (filter ((<>) x) xs);;

    togli_doppi [1; 2; 3; 3; 2; 1; 3];;
