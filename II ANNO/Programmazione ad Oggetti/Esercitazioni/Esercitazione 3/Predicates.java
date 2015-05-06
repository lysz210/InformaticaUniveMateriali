import java.util.*;

interface Predicate  
{
    public boolean test(Object obj);
}

class Predicates
{
    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' vero
     */
    public static  void remove(Collection coll, Predicate  pred) 
    {
	Iterator i = coll.iterator();
	while (i.hasNext())   {
	    Object el = i.next();
	    if (pred.test(el)) i.remove();
	}
    }
  
    /** 
     * Rimuove da coll ogni oggetto per cui il predicato pred e' falso
     */
    public static  void retain(Collection  coll, Predicate pred)
    {
	Iterator i = coll.iterator();
	while (i.hasNext())   {
	    Object el = i.next();
	    if (!pred.test(el)) i.remove();
	}
    }
    /** 
     * Restituisce una lista che contiene tutti gli oggetti per cui 
     * il predicato pred e' vero 
     */
    public static  List collect(Collection coll, Predicate  pred)
    {
	List r = new LinkedList();
	for (Object e : coll)
	    if (pred.test(e)) r.add(e);
	return r;
    }
    /** 
     * Restituisce l'indice del primo elemento di list per cui
     * il predicato pred e' vero. Se pred e' falso per tutti gli   
     * elementi di list  restituisce -1; 
     */
    public static int find(List list, Predicate pred)
    {
	for (int i = 0; i < list.size(); i++)
	    if (pred.test(list.get(i))) return i;
	return -1;
    }
}
