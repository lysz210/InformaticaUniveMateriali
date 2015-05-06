import java.util.*;

class MoreDataStat extends DataStat 
{

   /**
    * @pre true
    * @post @nochange
    * @result = l'ampiezza dell'intervallo delle misure considerate,
    *  ovvero la differenza tra le misure degli elementi massimo e
    *  minimo aggiunti all'insieme  
    */
    public double size() 
    {
	if (elements.size() == 0) return 0;
	else return Math.abs(max().measure() - min.measure());
    }

   /**
    * @pre d >= 0
    * @post @nochange
    * @result = un iteratore che permette di enumerare in sequenza gli
    *  elementi la cui misura e' minore del valore d
    */
    
    private Measurable min;
    private List<Measurable> elements = new ArrayList<Measurable>();

    public void add(Measurable x) { 
	if (x == null) return;
	super.add(x);
	elements.add(x);
	if (min == null || min.measure() > x.measure())
	    min = x;
    }

    public Iterator<Measurable> lessThan(double d) 
    { 
	final double treshold = d; 
	final Iterator<Measurable> it = elements.iterator();

	return new Iterator<Measurable>() 
        {

	    // @invariant: current != null => current.measure < d;

	    Measurable current  = null;
	    { reach_next(); }

	    private void reach_next() 
	    {
		boolean found = false;
		Measurable next  = null;
		while (it.hasNext() && !found )
		    {
			next = it.next();
			if (next.measure() < treshold) 
			    found = true; 
		    }
		current = found ? next: null;
	    }

	    public boolean hasNext() 
	    { 
		return current != null;
	    } 

	    public Measurable next() 
	    {
		Measurable next = current;
		if (!hasNext()) throw new NoSuchElementException();
		reach_next();
		return next;
	    }

	    public void remove() 
	    {
		throw new UnsupportedOperationException();
	    }

	};
    }
}
