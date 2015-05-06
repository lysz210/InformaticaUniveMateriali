import java.util.*;

/*
 * Classe che fornisce una serie di metodi statici per modificare collezioni di elementi generici in base ai predicati ad essi applicati
 */

class GenPredicates {
    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' vero
     */
    public static <T, E extends T> void remove(Collection<E> coll, GenPredicate<T>  pred) {

        Iterator<E> i = coll.iterator();
        while (i.hasNext())   {
            E el = i.next();
            if (pred.test(el)) i.remove();
        }

        // non si potrebbe modificare con il foreach
        // non si può iterare cambiando la lunghezza della collezione che si itera
        // si può con il for
        // collection però non definisce get e remove come le liste
        /*
        for(int i = 0; i < coll.size(); i++) {
            if (pred.test(coll.get(i))) {
                coll.remove(i);
                i--;
            }
        }
        */
    }

    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' falso
     */
    public static <T,E extends T> boolean retain(Collection<E>  coll, GenPredicate<T> pred) {
        Iterator<E> i = coll.iterator();
        while (i.hasNext())   {
            T el = i.next();
            if (!pred.test(el)) i.remove();
        }
        return true;
    }
    /** 
     * Restituisce una lista che contiene tutti gli oggetti per cui 
     * il predicato pred e' vero 
     */
    public static <T> List<T> collect(Collection<? extends T> coll, GenPredicate<T> pred) {
        List<T> r = new LinkedList<T>();
        for (T e : coll)
            if (pred.test(e)) r.add(e);
        return r;
    }
    /** 
     * Restituisce l'indice del primo elemento di list per cui
     * il predicato pred e' vero. Se pred e' falso per tutti gli   
     * elementi di list  restituisce -1; 
     */
    public static <T> int find(List<? extends T> list, GenPredicate<T> pred) {
        for (int i = 0; i < list.size(); i++)
            if (pred.test(list.get(i))) return i;
        return -1;
    }
}

