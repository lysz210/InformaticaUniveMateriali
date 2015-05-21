// Ulteriori informazioni su F# all'indirizzo http://fsharp.net

module esercitazione1

(*
ESERCIZIO 1

Secondo il libro “L’Arte della Cucina”, uno sciroppo andrebbe scaldato ad un grado in meno rispetto alla temperatura indicata per ogni 150 metri di altezza sul livello
del mare.

Definire la funzione candy_temperature che dati due argomenti, la temperatura originale in gradi e l’altezza in metri sul livello del mare, calcola la temperatura
 da usare per la cottura. 
 Per esempio, la ricetta per il Caramello al Cioccolato richiede una temperature di 118 gradi; supponiamo di volerla cucinare ad Enna, il capoluogo più alto d’Italia 
 (948 metri sul livello del mare). Usare la funzione candy_temperature per calcolare la temperatura da usare.

FIRMA: candy_temperature : float -> float -> float
*)

let candy_temperature t h = t - (h/150);;

(*ESERCIZIO 2

Modificare la funzione candy_temperature in candy_temperature2 affinché arrotondi il risultato all’intero più vicino, usando la funzione di arrotondamento round
 (già integrata nel linguaggio F#).

FIRMA: candy_temperature2 : float -> float -> float*)

let candy_temperature t h = round(t - (h/150.00));;

(*ESERCIZIO 3

“L’Arte della Cucina” suggerisce un modo per calcolare per quante persone basterà un tacchino. 
Per tacchini fino a 5kg potranno essere fatte porzioni di 300g per persona, mentre per tacchini più grossi la dose si riduce a solo 200g. 
Scrivere la funzione turkey che prende in input il peso di un tacchino e calcola il numero di persone per cui questo sarà sufficiente.

FIRMA: turkey : int -> int
*)

let turkey w =
    if w<=5000 then w/300 else w/200;;

