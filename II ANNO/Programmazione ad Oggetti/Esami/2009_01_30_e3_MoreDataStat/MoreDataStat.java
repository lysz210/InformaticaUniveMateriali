import java.util.*;

public class MoreDataStat extends DataStat {
    // campi
    private List<Measurable> misurati = new ArrayList<Measurable>(); // Lista di tutti gli oggetti Measurable aggiunti
    private Measurable min; // l'oggetto Measurable più corto aggiunto finora

    // metodi
    // override di add, oltre a memorizzare il massimo (super.add()), memorizzo il minimo
    // inoltre aggiungo l'oggetto in misurati
    public void add(Measurable x) {
        // verifico prima che il contatore venga incrementato
        if (count() == 0 || min.measure() > x.measure())
            min = x;
        // non incremento count perché viene già incrementato in DataStat
        misurati.add(x);
        super.add(x);        
    }

    /**
     * @pre true
     * @post @nochange
     * @result = l’ampiezza dell’intervallo delle misure considerate,
     * ovvero la differenza tra le misure degli elementi con misura
     * massima e minima.
     */
    public double size() {
        return max().measure() - min.measure();
    }

    /**
     * @pre d >= 0
     * @post @nochange
     * @result = un iteratore che permette di ottenere in sequenza gli
     * elementi la cui misura e’ minore del valore d
     */
    public Iterator<Measurable> lessThan(double d) {
        // creo un nuovo ArrayList
        List<Measurable> selezionati = new ArrayList<Measurable>();
        // scorro gli elementi misurati aggiungendoli a selected solo se inferiori a d
        for(Measurable m : misurati)
            if(m.measure() < d)
                selezionati.add(m);
        // restituisco l'iteratore di selezionati
        return selezionati.iterator();
    }

}
