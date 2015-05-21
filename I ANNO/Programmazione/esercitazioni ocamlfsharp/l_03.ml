

    (* numero più piccolo della lista *)
    let rec min_l l =
        match l with
        [] -> invalid_arg "lista vuota"
        | [x] -> x
        | x :: y :: xs ->
            if x <= y
                then min_l (x :: xs)
                else min_l (y :: xs);;

    (* numero più grande della lista *)
    let rec max_l l =
        match l with
        [] -> invalid_arg "lista vuota"
        | [x] -> x
        | x :: y :: xs ->
            if x >= y
                then max_l (x :: xs)
                else max_l (y :: xs);;

    (* minimo tra i massimi di più liste *)
    let rec min_max l =
        match l with
        [] -> invalid_arg "lista vuota"
        | [x] -> max_l x
        | x :: xs -> min_l (max_l x :: [min_max xs]);;

    min_l [2; 3; 1; 7; 5];;
    max_l [2; 3; 1; 7; 5];;
    min_max [[2; 4; 1]; [3; 5; 7]; [3; 1; 2]];;



    (* minimo tra i numeri positivi *)
    let rec minp l =
        match l with
        [] -> invalid_arg "lista vuota"
        | [x] ->
            if x < 0
                then failwith "la lista non contiene numeri positivi"
                else x
        | x :: y :: xs when x <= y ->
            if x >= 0
                then minp (x :: xs)
                else minp (y :: xs)
        | x :: y :: xs ->
            if y >= 0
                then minp (y :: xs)
                else minp (x :: xs);;

    minp [5; -1; -5; 0; 4; -2];;
    minp [-5; -1; -5; -3; -4; -1];;



    (* sottosequenze *)
    let seq l =
        let rec aux acc l =
            match l with
            [] -> [acc]
            | x :: xs -> acc :: aux (acc @ [x]) xs
        in
        aux [] l;;

    seq [1; 2; 3; 4];; (* [[]; [1]; [1; 2]; [1; 2; 3]; [1; 2; 3; 4]] *)
