

    (* alberi binari *)
    type 'a btree = Empty | Node of 'a * 'a btree * 'a btree;;

    (* altezza albero binario *)
    let rec altezza bt =
        match bt with
        | Empty -> 0
        | Node (x, lt, rt) -> 1 + max (altezza lt) (altezza rt);;

    altezza (Node(4, Node(2, Node(1, Empty, Empty), Empty), Node(5, 
               Empty, Empty)));;

    (* funzione predefinita max: let max x y = if x >= y then x else y *)
    (* funzione predefinita min: let min x y = if x <= y then x else y *)



    (* albero binario bilanciato: verifica *)
    let rec bilanciato bt =
        match bt with
        | Empty -> true
        | Node (x, lt, rt) ->
            (-1) <= (altezza lt - altezza rt) & (altezza lt - altezza rt) <= 1
            & bilanciato lt & bilanciato rt;;



    (* albero binario bilanciato completo: verifica *)
    let rec completo bt =
        match bt with
        | Empty -> true
        | Node (x, lt, rt) ->
            (-1) <= (altezza lt - altezza rt) & (altezza lt - altezza rt) <= 1
            & completo lt & completo rt
            & ((lt = Empty & rt = Empty) or (lt <> Empty & rt <> Empty));;


    (* Esempi: *)
    (* albero bilanciato e completo: *)
    bilanciato (Node(4, Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)), 
               Node(5, Empty, Empty)));;

    completo (Node(4, Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)), 
              Node(5, Empty, Empty)));;

    (* albero né bilanciato né completo: *)
    bilanciato (Node(4, Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)), 
               Empty));;

    completo (Node(4, Node(2, Node(1, Empty, Empty), Node(3, Empty, Empty)), 
              Empty));;

    (* albero bilanciato ma non completo: *)
    bilanciato (Node(4, Node(2, Node(1, Empty, Empty), Empty), Node(5, 
               Empty, Empty)));;

    completo (Node(4, Node(2, Node(1, Empty, Empty), Empty), Node(5, 
              Empty, Empty)));;



