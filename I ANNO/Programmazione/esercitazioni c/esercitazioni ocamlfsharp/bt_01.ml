

    (* alberi binari *)
    type 'a btree = Empty | Node of 'a * 'a btree * 'a btree;;

    (* restituire albero sinistro *)
    let left bt =
        match bt with
        Empty -> Empty
        | Node (x, lt, rt) -> lt;;
    (* per albero destro usare rt *)


    (* cercare elemento in un albero binario (almeno uno) *)
    let rec search n bt =
        match bt with
        Empty -> false
        | Node (x, lt, rt) -> n = x or search n lt or search n rt;;

    search 2 (Node (5, Node (2, Empty, Empty), Node (3, Empty, Empty)));;
    search 1 (Node (5, Node (2, Empty, Empty), Node (3, Empty, Empty)));; 


    (* cercare elemento in un albero binario di ricerca (almeno uno) *)
    let rec search n bt =
        match bt with
        | Empty -> false
        | Node (x, lt, rt) when n = x -> true
        | Node (x, lt, rt) when n < x -> search n lt
        | Node (x, lt, rt) -> search n rt;; (* n > x *)

    search 2 (Node (5, Node (2, Empty, Empty), Node (6, Empty, Empty)));;
    search 1 (Node (5, Node (2, Empty, Empty), Node (6, Empty, Empty)));; 


    (* contare i nodi di un albero *)
    let rec count bt =
        match bt with
        Empty -> 0
        | Node (x, lt, rt) -> 1 + count lt + count rt;;

    count (Node (5, Node (2, Empty, Empty), Node (3, Empty, Empty)));;


    (* visita di un albero prefissa, infissa, postfissa *)
    let rec preorder bt =
        match bt with
        Empty -> []
        | Node (x, lt, rt) -> x :: preorder lt @ preorder rt;;

    let rec inorder bt =
        match bt with
        Empty -> []
        | Node (x, lt, rt) -> inorder lt @ x :: inorder rt;;

    let rec postorder bt =
        match bt with
        Empty -> []
        | Node (x, lt, rt) -> postorder lt @ postorder rt @ [x];;

    preorder (Node (1, Node (3, Node (2, Empty, Empty), Node (4, Empty, 
              Node (5, Empty, Empty))), Node (6, Empty, Empty)));;

    inorder (Node (1, Node (3, Node (2, Empty, Empty), Node (4, Empty, 
             Node (5, Empty, Empty))), Node (6, Empty, Empty)));;

    postorder (Node (1, Node (3, Node (2, Empty, Empty), Node (4, 
               Empty, Node (5, Empty, Empty))), Node (6, Empty, Empty)));;
