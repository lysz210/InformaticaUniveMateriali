

    (* alberi binari *)
    type 'a btree = Empty | Node of 'a * 'a btree * 'a btree;;

    (* max e min di un albero binario di ricerca, (elementi più a dx e più a sx) *)
    let rec max_bt bt =
        match bt with
        Empty -> invalid_arg "albero vuoto!"
        | Node (x, _, Empty) -> x
        | Node (x, lt, rt) -> max_bt rt;;

    let rec min_bt bt =
        match bt with
        Empty -> invalid_arg "albero vuoto!"
        | Node (x, Empty, _) -> x
        | Node (x, lt, rt) -> min_bt lt;;

    max_bt (Node (5, Node (2, Node (1, Empty, Empty), Node (3, Empty, 
            Node (4, Empty, Empty))), Node (6, Empty, Empty)));;

    min_bt (Node (5, Node (2, Node (1, Empty, Empty), Node (3, Empty, 
            Node (4, Empty, Empty))), Node (6, Empty, Empty)));;



    (* max e min di un albero binario qualsiasi *)
    let rec max_bt bt =
        match bt with
        Empty -> invalid_arg "albero vuoto!"
        | Node (x, Empty, Empty) -> x
        | Node (x, Empty, rt) -> max x (max_bt rt)
        | Node (x, lt, Empty) -> max x (max_bt lt)
        | Node (x, lt, rt) -> max x (max (max_bt lt) (max_bt rt));;

    let rec min_bt bt =
        match bt with
        Empty -> invalid_arg "albero vuoto!"
        | Node (x, Empty, Empty) -> x
        | Node (x, Empty, rt) -> min x (min_bt rt)
        | Node (x, lt, Empty) -> min x (min_bt lt)
        | Node (x, lt, rt) -> min x (min (min_bt lt) (min_bt rt));;

    max_bt (Node (5, Node (4, Node (1, Empty, Empty), Node (7, Node (6, Empty, 
            Empty), Empty)), Node (3, Empty, Node (2, Empty, Empty))));;

    min_bt (Node (5, Node (4, Node (1, Empty, Empty), Node (7, Node (6, Empty, 
            Empty), Empty)), Node (3, Empty, Node (2, Empty, Empty))));;
