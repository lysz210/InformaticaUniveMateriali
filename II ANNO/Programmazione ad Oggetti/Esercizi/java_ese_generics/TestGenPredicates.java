
import java.util.*;

/*
 * Classe che testa il funzionamento di GenPredicates
 * per comodità l'interfaccia GenPredicate è usata da classi anonime
 */

public class TestGenPredicates {

    public static void main(String[] args) {
    // creo un primo predicato come classe anonima che implementa l'interfaccia GenPredicate
    // il predicato verifica se un numero è pari
    GenPredicate<Integer> pari = new GenPredicate<Integer>() {
        public boolean test(Integer n) { return n % 2 == 0; }
	};

    // il predicato verifica se un numero è > 2
    GenPredicate<Integer> pred1 = new GenPredicate<Integer>() {
        public boolean test(Integer n) { return n > 1; }
	};
    // il predicato verifica se un numero è < 4    
    GenPredicate<Integer> pred2 = new GenPredicate<Integer>() {
        public boolean test(Integer n) { return n < 4; }
	};

    // questo è un predicato test, che preso un Number dà sempre vero
	GenPredicate<Number> isTrue = new GenPredicate<Number>() {
        public boolean test(Number n) { return true; }
	};

    // creo una lista di Integer
	List<Integer> li = new ArrayList<Integer>();
    li.add(1);
    li.add(2);
    li.add(3);
    li.add(4);
    li.add(5);
    System.out.println(li);
    // applico il metodo collect per ottenere una lista di Number
    // pn è applicato a Number, Integer estende Number
    // dato che pn è sempre true di fatto duplico la lista
	List<Number> ln = GenPredicates.collect(li, isTrue);
    System.out.println(ln);

    List<Integer> li2 = GenPredicates.collect(li, pred1);
    System.out.println("1)" + li2);

    GenPredicates.remove(li2, pred2);
    System.out.println("2)" + li2);

    GenPredicates.retain(li2, pari);
    System.out.println(li2);

    System.out.println(GenPredicates.find(li2, pari));

    /*
    Output:
    [1, 2, 3, 4, 5]
    [1, 2, 3, 4, 5]
    1)[2, 3, 4, 5]
    2)[4, 5]
    [4]
    0
    */

    }
}
