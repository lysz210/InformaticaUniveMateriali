import java.util.*;

/** 
 * Esercizio 1: classi Nodo, Foglia, NodoInterno
 */

abstract class Nodo<T> {
    private T info;
    protected Nodo(T info) { this.info = info; }
    public  String toString() { return info.toString(); }
}

class Foglia<T> extends Nodo<T> {
    public Foglia(T info) { super(info); }
}

class NodoInterno<T> extends Nodo<T> { 

    private List<Nodo<T>> children = new ArrayList<Nodo<T>>();
    
    public NodoInterno(T info) { super(info); } 

    public NodoInterno(T info, List<Nodo<T>> nodes) {
	this(info);
	for (Nodo<T> n : nodes) children.add(n);
    }

    public String toString() {
	String s = super.toString();
	if (children.size() == 0) return s;
	s += " ( "; 
	for (Nodo<T> n : children) s += n.toString() + " ";
	return s + ") ";
    }
}

/** 
 * Esercizio 2: classe test 
 */ 
public class Tree 
{ 
    public static void main(String[] args) 
    {
	// costruiamo l'albero bottom-up
	ArrayList<Nodo<String>> childrenE = new ArrayList<Nodo<String>>(); 
	childrenE.add(new Foglia<String>("G"));
	Nodo<String> nodoE = new NodoInterno<String>("E", childrenE);

	ArrayList<Nodo<String>> childrenC = new ArrayList<Nodo<String>>();
	childrenC.add(new Foglia<String>("D"));
	childrenC.add(nodoE);
	childrenC.add(new Foglia<String>("F"));

	ArrayList<Nodo<String>> childrenA = new ArrayList<Nodo<String>>();
	childrenA.add(new Foglia<String>("B"));
	childrenA.add(new NodoInterno<String>("C", childrenC));

	Nodo<String> tree = new NodoInterno<String>("A", childrenA);
	
	// stampiamo
	System.out.println(tree.toString());
    }
}
