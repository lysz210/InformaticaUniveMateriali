import java.util.*;

interface GenPredicate<T>  
{
    public boolean test(T obj);
}

class GenPredicates 
{
    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' vero
     */
    public static <T,E extends T> void remove(Collection<E> coll, GenPredicate<T>  pred) 
    {
	Iterator<E> i = coll.iterator();
	while (i.hasNext())   {
	    E el = i.next();
	    if (pred.test(el)) i.remove();
	}
    }
  
    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' falso
     */
    public static <T,E extends T> boolean retain(Collection<E>  coll, GenPredicate<T> pred)
    {
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
    public static <T> List<T> collect(Collection<? extends T> coll, GenPredicate<T> pred)
    {
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
    public static <T> int find(List<? extends T> list, GenPredicate<T> pred)
    {
	for (int i = 0; i < list.size(); i++)
	    if (pred.test(list.get(i))) return i;
	return -1;
    }
}

public class GenericPredicates
{

    public static void main(String[] args) 
    {
	
	GenPredicate<Integer> pi = 
	    new GenPredicate<Integer>() {
	       public boolean test(Integer i) { return i % 2 == 0; }
	};

	GenPredicate<Number> pn = 
	    new GenPredicate<Number>() {
	       public boolean test(Number n) { return true; }
	};

	List<Integer> li = new ArrayList<Integer>();
	List<Number> ln = GenPredicates.collect(li, pn);
	int i = GenPredicates.find(li,pn); 
	GenPredicates.remove(li,pn);
	GenPredicates.retain(li,pn);

    }
}
    
