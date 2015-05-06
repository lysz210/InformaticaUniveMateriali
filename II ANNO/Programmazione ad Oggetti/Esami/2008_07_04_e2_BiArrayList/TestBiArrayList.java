import java.util.*;

public class TestBiArrayList {
    public static void main(String[] argv) {
        BiArrayList<Integer> ba = new BiArrayList<Integer>(3);
        // l'array dev'essere di Integer, non int, non vale l'auto casting tra i generics
        Integer[] array = new Integer[3];
        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        ba.insert(array);
        System.out.printf("row %d, col %d\n", ba.rows(), ba.cols());
        array[0] = 2;
        array[1] = 4;
        array[2] = 6;
        ba.insert(array);
        System.out.printf("row %d, col %d\n", ba.rows(), ba.cols());
        System.out.printf("Nella 2a riga, 2a colonna c'è %d\n", ba.get(1,1)); // autocasting tra Integer ed int
        //System.out.printf("Nella 2a riga, 2a colonna c'è %d\n", ba.get(2,2)); // lancia eccezione
        ba.set(1, 1, 0);
        //ba.set(2, 2, 10); // eccezione
        System.out.printf("Nella 2a riga, 2a colonna c'è %d\n", ba.get(1,1));

        // test iteratore
        Iterator<Integer> iter = ba.iterator();
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        if(!iter.hasNext())
            System.out.println("fine iteratore");
    }
}
