public class DataStat {
    // campi
    private double sum; // somma delle lunghezze di tutti gli oggetti Measurable aggiunti
    private Measurable max; // l'oggetto Measurable più lungo aggiunto finora
    private int count; // numeri di oggetti aggiunti

    // senza costruttore inizializza i campi ai valori di default: 0, null, 0

    // metodi
    public void add(Measurable x) {
        if (x == null)
            return;
        sum = sum + x.measure();
        // la condizione count == 0 deve stare prima così quando è soddisfatta esce senza fare max.measure()
        // perché max all'inizio è null
        if (count == 0 || max.measure() < x.measure())
            max = x;
        count++;
    }

    public Measurable max() {
        return max;
    }

    public double average() {
        return (count == 0) ? 0 : sum/count;
    }

    // aggiunto da me
    public int count() {
        return count;
    }
}
