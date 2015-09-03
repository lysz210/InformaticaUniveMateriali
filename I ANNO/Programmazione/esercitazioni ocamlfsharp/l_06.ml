

    (* calcola il numero di combinazioni (senza usare il fattoriale) *)
    let combo l k =
        let rec aux n k =
            match k with
            0 -> 1
            | _ when n = k -> 1
            | _ -> aux (n - 1) (k - 1) + aux (n - 1) k
        in
        aux (List.length l) k;;

    combo [1; 2; 3] 2;;



    (* calcola le combinazioni di n elementi su k posti *)
    let combo l k =
        if l = []
            then invalid_arg "lista_vuota"
        else
            let rec aux l acc =
                if List.length acc = k
                    then [acc]
                else
                    match l with
                    [] -> []
                    | x :: xs ->
                        aux xs (acc @ [x]) @ aux xs acc
            in
            aux l [];;

    combo [1; 2; 3] 2;;



    (* insieme delle parti di una lista *)
    let rec powerset l =
        let rec aggiungi n l =
            match l with
            [] -> []
            | x :: xs -> (n :: x) :: aggiungi n xs
        in
        match l with
        | [] -> [[]]
        | x :: xs -> aggiungi x (powerset xs) @ powerset xs;;

    powerset [1; 2; 3];;
