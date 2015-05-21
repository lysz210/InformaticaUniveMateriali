

    (* ricorsione e iterazione (fattoriale e prodotto) - iterazione (mcd) *)
    let rec fatt n =
        match n with
        0 -> 1
        | _ when n > 0 -> n * fatt (n - 1)
        | _ -> invalid_arg "argomento negativo";;

    let fatt n =
        let rec aux acc n =
            match n with
            0 -> acc
            | _ when n > 0 -> aux (n * acc) (n - 1)
            | _ -> invalid_arg "argomento negativo"
        in
        aux 1 n;;


    let rec prodotto x y =
        match y with
        0 -> 0
        | _ when y > 0 -> x + prodotto x (y - 1)
        | _ -> invalid_arg "y negativo";; (* per potenza usare 0 -> 1 e "x * " *)

    let prodotto x y =
        let rec aux acc y =
            match y with
            0 -> acc
            | _ when y > 0 -> aux (x + acc) (y - 1)
            | _ -> invalid_arg "y negativo"
        in
        aux 0 y;;


    let rec mcd x y =
        if x <= 0 or y <= 0
            then invalid_arg "x e y devono essere > 0"
        else
            match x with
            _ when x = y -> x
            | _ when x > y -> mcd (x - y) y
            | _ -> mcd x (y -x);; 


    (* funzioni composte                    f             g          x       *)
    let compose f g x = f (g x);;    (* ('a -> 'b) -> ('c -> 'a) -> 'c -> 'b *)

    let succ n = n + 1 and doppio n = n * 2
    in compose succ doppio 2;;

    (* funzioni curry e uncurry *)
    let curry f x y = f(x, y);; (* ('a * 'b -> 'c) -> 'a -> 'b -> 'c *)
    
    let uncurry f(x, y) = f x y;; (* ('a -> 'b -> 'c) -> 'a * 'b -> 'c *)


    (* conta le cifre pari o dispari di un numero intero *)
    let pari n =
        if n mod 2 = 0  (* per dispari usare n mod 2 = 1 *)
            then 1
            else 0;;
    let rec conta_pari n =
        if -10 < n & n < 10
            then pari n
            else
                pari (n mod 10) + conta_pari (n / 10);;

    conta_pari 12345;;
    conta_pari (-12345);;
