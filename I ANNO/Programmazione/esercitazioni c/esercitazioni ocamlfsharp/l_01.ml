

    (* definire la concatenazione @ attraverso il costruttore ::  *)
    let rec concat l1 l2 =
        match l1 with
        [] -> l2
        | x :: xs -> x :: concat xs l2;;

    concat [3; 2] [1; 4; 5];;



    (* rev, inverti l'ordine degli elementi di una lista *)
    let rec rev l =
        match l with
        [] -> []
        | x :: xs -> concat (rev xs) [x];; (* = rev xs @ [x] *)

    rev [1; 2; 3; 4];;



    (* data una lista tenere solo i pari *)
    let rec pari l =
        match l with
        [] -> []
        | x :: xs ->
            if (x mod 2) = 0
                then x :: pari xs
                else pari xs;;

    pari [2; 6; 3; 1; 4];;
    (* per contare i pari porre caso base 0 e " 1 + " al posto di " x :: " *)
    (* per dispari (x mod 2) = 1 *)



    (* restituisci l'ennesimo elemento di una lista *)
    let rec nth n l =
        match l with
        [] -> failwith "impossibile trovare l'elemento"
        | x :: xs ->
            if (n = 0)
                then x
                else nth (n - 1) xs;;

    nth 2 [1; 2; 3];;
    nth 3 [1; 2; 3];;



    (* verifica se la lista è ordinata (true) o no (false) *)
    let rec in_order l =
        match l with
        [] -> true
        | [x] -> true
        | x :: y :: xs -> x <= y & in_order (y :: xs);;

    in_order [1; 2; 3; 4; 5];;
    in_order [1; 2; 3; 5; 4];;



    (* costruisci una lista dei valori compresi tra x e y inclusi, x <= y *)
    let rec intervallo x y =
        if (x = y)
          then [x]
          else x :: intervallo (x + 1) y;;

    intervallo 4 7;;
