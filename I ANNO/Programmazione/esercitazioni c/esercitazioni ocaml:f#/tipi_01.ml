

    (* tipi *)
    (* enumerati: tipi arbitrari *)
    type num = Pari | Dispari;;

    let tipo_num x =
        if (x mod 2) = 0
            then Pari
            else Dispari;;

    tipo_num 3;;



    (* somma: definiti da altri tipi, si appartiene ad un solo sotto tipo *)
    type misura = Metri of int | Centimetri of int;;

    (* recupare i tipi somma *)
    let m_cm x =
        match x with
        Centimetri x -> Centimetri x
        | Metri x -> Centimetri (x * 100);;

    m_cm (Metri 3);;
    m_cm (Centimetri 300);;


    type coordinate = Coord of int * int;;
    let ascissa (Coord (x, y)) = x;;


    (* prodotto: definiti da altri tipi, si appartiene a tutti i sotto tipi *)
    type studente = {nome: string; cognome: string; matricola: int};;

    (* recupare i tipi prodotto *)
    let torna_matr x = x.matricola;;

    let pinco = {nome = "pinco"; cognome = "pallino"; matricola = 888888};;

    torna_matr pinco;;



    (* ricorsivi: definiti anche da loro stessi *)
    (* numeri naturali *)
    type nat = Zero | Succ of nat;;

    (* esempio numero 2 scritto come nat *)
    Succ (Succ Zero);;
