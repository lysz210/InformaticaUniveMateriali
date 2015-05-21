//Minati Leonardo - Esercitazione 7

module esercitazione7

type Direzione = Su | Giu | Destra | Sinistra;;

type Colore = Bianco | Nero;;

type Posizione = Pos of int * char;;

//esercizio 1
let pedone color position = match color with
                            Bianco -> match position with 
                                      (2,x) -> (4,x)
                                      |(x,y) -> //check if the next position is valid. if it isn't then return the original position
                                                if x <> 8 then (x+1,y)
                                                else (x,y)
                            |Nero -> match position with
                                     (7,x) -> (5,x)
                                     |(x,y) -> //check if the next position is valid. if it isn't then return the original position
                                              if x <> 1 then (x-1,y)
                                              else (x,y)

//esercizio 2
let rec alfiere position verticalDirection horizontalDirection cells = match verticalDirection, horizontalDirection with
                                                                       Su, Destra -> //check if the position is valid
                                                                             match position with
                                                                             (x,'h') -> (*invalid position: return the original position*)position
                                                                             |(8,y) -> (*invalid position: return the original position*)position
                                                                             |(x,y) ->  if cells > 0 then 
                                                                                            match y with
                                                                                            'a' -> alfiere (x+1, 'b') Su Destra (cells-1)
                                                                                            |'b' -> alfiere (x+1, 'c') Su Destra (cells-1)
                                                                                            |'c' -> alfiere (x+1, 'd') Su Destra (cells-1)
                                                                                            |'d' -> alfiere (x+1, 'e') Su Destra (cells-1)
                                                                                            |'e' -> alfiere (x+1, 'f') Su Destra (cells-1)
                                                                                            |'f' -> alfiere (x+1, 'g') Su Destra (cells-1)
                                                                                            |'g' -> alfiere (x+1, 'h') Su Destra (cells-1)
                                                                                        else position
                                                                      |Su, Sinistra -> //check if the position is valid
                                                                             match position with
                                                                             (x,'a') -> (*invalid position: return the original position*)position
                                                                             |(8,y) -> (*invalid position: return the original position*)position
                                                                             |(x,y) ->  if cells > 0 then 
                                                                                            match y with
                                                                                            'b' -> alfiere (x+1, 'a') Su Sinistra (cells-1)
                                                                                            |'c' -> alfiere (x+1, 'b') Su Sinistra (cells-1)
                                                                                            |'d' -> alfiere (x+1, 'c') Su Sinistra (cells-1)
                                                                                            |'e' -> alfiere (x+1, 'd') Su Sinistra (cells-1)
                                                                                            |'f' -> alfiere (x+1, 'e') Su Sinistra (cells-1)
                                                                                            |'g' -> alfiere (x+1, 'f') Su Sinistra (cells-1)
                                                                                            |'h' -> alfiere (x+1, 'g') Su Sinistra (cells-1)
                                                                                        else position
                                                                      |Giu, Destra -> //check if the position is valid
                                                                             match position with
                                                                             (x,'h') -> (*invalid position: return the original position*)position
                                                                             |(1,y) -> (*invalid position: return the original position*)position
                                                                             |(x,y) ->  if cells > 0 then 
                                                                                            match y with
                                                                                            'a' -> alfiere (x-1, 'b') Su Destra (cells-1)
                                                                                            |'b' -> alfiere (x-1, 'c') Su Destra (cells-1)
                                                                                            |'c' -> alfiere (x-1, 'd') Su Destra (cells-1)
                                                                                            |'d' -> alfiere (x-1, 'e') Su Destra (cells-1)
                                                                                            |'e' -> alfiere (x-1, 'f') Su Destra (cells-1)
                                                                                            |'f' -> alfiere (x-1, 'g') Su Destra (cells-1)
                                                                                            |'g' -> alfiere (x-1, 'h') Su Destra (cells-1)
                                                                                        else position
                                                                      |Giu, Sinistra -> //check if the position is valid
                                                                             match position with
                                                                             (x,'a') -> (*invalid position: return the original position*)position
                                                                             |(1,y) -> (*invalid position: return the original position*)position
                                                                             |(x,y) ->  if cells > 0 then 
                                                                                            match y with
                                                                                            'b' -> alfiere (x-1, 'a') Su Sinistra (cells-1)
                                                                                            |'c' -> alfiere (x-1, 'b') Su Sinistra (cells-1)
                                                                                            |'d' -> alfiere (x-1, 'c') Su Sinistra (cells-1)
                                                                                            |'e' -> alfiere (x-1, 'd') Su Sinistra (cells-1)
                                                                                            |'f' -> alfiere (x-1, 'e') Su Sinistra (cells-1)
                                                                                            |'g' -> alfiere (x-1, 'f') Su Sinistra (cells-1)
                                                                                            |'h' -> alfiere (x-1, 'g') Su Sinistra (cells-1)
                                                                                        else position

//esercizio 3

//funzione ausiliaria per controllare se una posizione è valida sulla scacchiera
let isValid pos = match pos with
                  (x,y) -> if (x >= 1 && x <= 8) && (y = 'a' || y = 'b' || y = 'c' || y = 'd' || y = 'e' || y = 'f' || y = 'g' || y = 'h') then true
                           else false 


let cavallo pos1 pos2 = match pos1 ,pos2 with 
                        (a,b) ,(c,d) -> if ((c = a+2 && (int) d = (int) b+1) && isValid (c,d)) || ((c = a+2 && (int) d = (int) b-1) && isValid (c,d)) || ((c = a-2 && (int) d = (int) b-1) && isValid (c,d)) || ((c = a-2 && (int) d = (int) b+1) && isValid (c,d)) || ((c = a+1 && (int) d = (int) b+2) && isValid (c,d)) || ((c = a-1 && (int) d = (int) b+2) && isValid (c,d)) || ((c = a+1 && (int) d = (int) b-2) && isValid (c,d)) || ((c = a-1 && (int) d = (int) b-2) && isValid (c,d)) then true 
                                        else false