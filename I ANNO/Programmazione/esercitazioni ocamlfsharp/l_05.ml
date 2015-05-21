

    (* filtermap, tieni gli elementi della lista che soddisfano un predicato
                  e applica a questi una funzione *)
    let rec filtermap f p l =
        match l with
        [] -> []
        | x :: xs ->
            if p x
                then f x :: filtermap f p xs
                else filtermap f p xs;;
    (* ('a -> 'b) -> ('a -> bool) -> 'a list -> 'b list *)

    (* Data una lista di liste restituire i primi elementi delle liste non vuote *)
    let firsts l =
        let hd l =
            match l with
            [] -> invalid_arg "lista vuota"
            | x :: xs -> x
        in
        filtermap hd ((<>) []) l;;

    firsts [[1; 2]; []; [3; 4]; [5]; [6; 7; 8]; []];;


    (* Ordinare una lista disordinata: ordinamento completo *)
    let rec ordina l =
        let rec insord n l =
            match l with
            [] -> [n]
            | x :: xs ->
                if n <= x
                    then n :: x :: xs
                    else x :: insord n xs
        in
        match l with
        [] -> []
        | x :: xs -> insord x (ordina xs);;

    ordina [2; 5; 3; 1; 7; 4; 6; 8];;


    (* Ordinare una lista disordinata: ordinamento merge sort *)
    let rec
    oddpart l =
        match l with
        [] -> []
        | x :: xs -> x :: evenpart xs
    and
    evenpart l =
        match l with
        [] -> []
        | x :: xs -> oddpart xs;;

    let rec merge l1 l2 =
        match (l1, l2) with
        ([], _) -> l2
        | (_, []) -> l1
        | (x :: xs, y :: ys) ->
            if (x <= y)
                then x :: merge xs l2
                else y :: merge l1 ys;;

    let rec mergesort l =
        match l with
        [] -> []
        | [x] -> l
        | _ -> merge (mergesort (oddpart l)) (mergesort (evenpart l));;

    mergesort [2; 5; 3; 1; 7; 4; 6; 8];;
