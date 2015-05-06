

    (* alberi binari *)
    type 'a btree = Empty | Node of 'a * 'a btree * 'a btree;;

    (* da lista disordinata ad albero binario di ricerca *)
    let rec list_bt l =
        let rec insord n bt =
            match bt with
            Empty -> Node (n, Empty, Empty)
            | Node (x, lt, rt) ->
                if (n <= x)
                    then Node (x, insord n lt, rt)
                    else Node (x, lt, insord n rt)
        in
        match l with
        [] -> Empty
        | x :: xs -> insord x (list_bt xs);;
    (* NB ricorsione di ricorsione come nella funzione di ordinamento lista *)

    (* costruisce l'albero a partire dall'ultimo elemento della lista *)
    list_bt [3; 1; 5; 6; 4; 7; 2];;



    (* da lista ordinata ad albero di ricerca bilanciato, se possibile completo *)
    let rec take l n =
        match l with
        | _ when (n <= 0) -> []
        | x :: xs -> x :: take xs (n - 1)
        | _ -> [];;

    let rec drop l n =
        match l with
        | _ when (n <= 0) -> l
        | x :: xs -> drop xs (n - 1)
        | _ -> [];;

    let rec list_bt l =
        match l with
        | [] -> Empty
        | _ ->
        let k = List.length l / 2
            in
            (* radice = numero a metà, sx < radice, dx > radice *)
            Node (List.hd (drop l k), list_bt (take l k), 
                  list_bt (List.tl (drop l k)));;

    list_bt [1; 2; 3; 4; 5; 6; 7];;
