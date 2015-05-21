module esercitazione2

(*
 Si consideri un distributore di bevande:
TIPO DI BEVANDA
	PREZZO
Espresso
	0.40 €
Espresso Lungo
	0.40 €
Mocaccino
	0.50 €
Cappuccino
	0.60 €
Orzo
	0.65 €


ESERCIZIO 1
Scrivere una funzione prezzo che, data in input una stringa indicante il tipo di bevanda, ne restituisce il prezzo (0 se la bevanda non è presente nell’elenco).
FIRMA: prezzo: string -> float
*)

let prezzo t =
    match t with
    "Espresso Lungo" -> 0.40
    |"Espresso" -> 0.40
    |"Mocaccino" -> 0.50
    |"Capuccino" -> 0.60
    |"Orzo" -> 0.65
    |_-> 0.0;;

(*
ESERCIZIO 2

Scrivere una funzione selezione che, dati in input una stringa rappresentante la bevanda selezionata e un reale rappresentante l’importo in euro inserito nel distributore,
 restituisce true , se l’importo è sufficiente per pagare la bevanda, false altrimenti.

FIRMA: selezione: string -> float -> bool 
*)

let selezione t i =
    match t with
    "Espresso Lungo" -> if i >= 0.40 then true else false
    |"Espresso" -> if i >= 0.40 then true else false
    |"Mocaccino" -> if i >= 0.50 then true else false
    |"Capuccino" -> if i >= 0.60 then true else false
    |"Orzo" -> if i >= 0.65 then true else false
    |_-> false;;    

(*
ESERCIZIO 3

Scrivere una funzione resto che, dati in input una stringa rappresentante la bevanda selezionata e un reale rappresentante l’importo in euro inserito nel distributore,
 restituisce al cliente il resto.

FIRMA: resto: string -> float -> float
*)

let resto t i =
    match t with
    "Espresso Lungo" -> if i >= 0.40 then i - 0.40 else 0.0
    |"Espresso" -> if i >= 0.40 then i - 0.40 else 0.0
    |"Mocaccino" -> if i >= 0.50 then i - 0.50 else 0.0
    |"Capuccino" -> if i >= 0.60 then i - 0.60 else 0.0
    |"Orzo" -> if i >= 0.65 then i - 0.65 else 0.0
    |_-> 0.0;;    