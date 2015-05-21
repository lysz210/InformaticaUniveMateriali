

    (* da coppia di liste della stessa lunghezza a lista di coppie *)
    let rec combine (l1, l2) =
        match (l1, l2) with
        (x :: xs, y :: ys) -> (x, y) :: combine (xs, ys)
        | (_, _) -> [];; (* caso base liste vuote *)

    combine ([1; 3; 5], [2; 4; 6]);;

    (* da lista di coppie a coppia di liste *)
    let rec split l =
            match l with
            [] -> ([], [])
            | (x, y) :: ls ->
                let (xs, ys) = split ls
                in
                (x :: xs, y :: ys);;

    split [(1, 2); (3, 4); (5, 6)];;



    (* take, prendi i primi n elementi della lista *)
    let rec take n l =
        match l with
        | [] -> []
        | _ when n = 0 -> []
        | x :: xs -> x :: take (n-1) xs;;

    take 2 [3; 7; 5];;
    take 4 [3; 7; 5];;

    (* drop, salta i primi n elementi della lista *)
    let rec drop n l =
        match l with
        | [] -> []
        | _ when n = 0 -> l
        | x :: xs -> drop (n-1) xs;;

    drop 2 [3; 7; 5];;
    drop 4 [3; 7; 5];;

    (* NB take è ricorsiva, drop è iterativa *)



    (* swap, scambia un elemento della lista con il suo successore
       (se esiste altrimenti lasciala così com'è) *)
    let rec swap n l =
        match l with
        [] -> l
        | [x] -> l
        | x :: y :: xs when n = 0 -> y :: x :: xs
        | x :: xs -> x :: swap (n - 1) xs;;

    swap 2 [3; 4; 7; 1];;
    swap 3 [3; 4; 7; 1];;
    swap 4 [3; 4; 7; 1];;



    (* interleave, mescola alternando due liste *)
    let rec interleave l1 l2 =
        match l1 with
        [] -> l2
        | x :: xs -> x :: interleave l2 xs;;

    interleave [1; 2; 3; 4] [5; 6; 7];;
