import java.util.*;
/**
 * Una matrice bi-dimensionale di oggetti di tipo T con un numero fissato
 * di righe ed un numero variabile di colonne (tutte le colonne hanno lo
 * stesso numero di posizioni).
 */
public class BiArrayList<T> {
    // campi
    private int rows;
    private int cols;
    // ArrayList di ArrayList, con un array normale non riesco a gestire i generics
    private ArrayList<ArrayList <T>> matrice;
    /*
     *         row 1                  row 2                      row n
     * [ [col1][col2][col3] ] [ [col1][col2][col3] ] ... [ [col1][col2][col3] ]
     */
     
    /**
     * @pre : n > 0
     * @post: crea una BiArrayList vuota, con n righe e 0 colonne
     */
    public BiArrayList(int n) {
        rows = n;
        cols = 0;
        // inizializzo l'array
        matrice = new ArrayList<ArrayList<T>>();
        // e n ArrayList vuoti = n righe, 0 colonne
        for (int r = 0; r < n; r++)
            matrice.add(new ArrayList<T>());
    }

    /**
     * @pre: TRUE, @result = numero di righe di this
     */
    public int rows() {
        return rows;
    }

    /**
     * @pre: TRUE, @result = numero di colonne di this
     */
    public int cols() {
        return cols;
    }

    /**
     * @pre: c != null && c.length == rows()
     * @post: aggiunge c come ultima colonna di this.
     * Lancia l’eccezione se la precondizione e‘ violata
     *
     */
    public void insert (T[] c) throws IllegalArgumentException {
        // verifica le precondizioni
        if(c == null || c.length != rows())
            throw new IllegalArgumentException();
        // scorri tutta la matrice, aggiungendo ad ogni riga una colonna
        // per ogni ArrayList colonna (matrice.get(r)) aggiungi un elemento
        int r;
        for(r = 0; r < rows(); r++) {
            matrice.get(r).add(c[r]);
        }
        cols++;
    }

    /**
     * @pre: x != null & 0 <= i < rows() && 0 <= j < cols()
     * @post: modifica la posizione (i,j) della matrice settandola
     * ad x. Eccezione se la precondizione e‘ violata
     *
     */
    public void set(int i, int j, T x) throws IllegalArgumentException {
        // verifica le precondizioni
        if(x == null || (i < 0 || i >= rows()) || (j < 0 || j >= cols()))
            throw new IllegalArgumentException();
        matrice.get(i).set(j, x);
        
    }
    /**
     * @pre: 0 <= i < rows() && 0 <= j < cols()
     * @result = il valore memorizzato in posizione (i,j)
     * @post: Eccezione se la precondizione e‘ violata
     */
    public T get(int i, int j) throws IllegalArgumentException {
        // verifica le precondizioni
        if((i < 0 || i >= rows()) || (j < 0 || j >= cols()))
            throw new IllegalArgumentException();
        return matrice.get(i).get(j);        
    }

    /**
     * @result = un iteratore che restituisce gli elementi di this
     * enumerandoli in ordine di riga e di colonna
     *
     */
    public Iterator<T> iterator() {
        // creo un nuovo array list a cui aggiungo gli elementi riga per colonna
        int r, c;
        List<T> all = new ArrayList<T>();
        for(r = 0; r < rows; r++)
            for(c = 0; c < cols; c++)
                all.add(matrice.get(r).get(c));
        return all.iterator();
    }
}
