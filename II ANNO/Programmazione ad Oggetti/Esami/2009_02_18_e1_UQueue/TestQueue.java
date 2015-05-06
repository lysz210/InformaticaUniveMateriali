import java.util.*;

class TestQueue<T> {
    public static void main(String[] argv) {
        /*  Quando si usano i generics è bene specificarli sia per il tipo statico che per quello dinamico
         *  se si sbaglia il compilatore dà questo warning
         *  Note: TestQueue.java uses unchecked or unsafe operations.
         */
        Queue<Integer> q = new Queue<Integer>(); // non si può usare un tipo primitivo come int
        q.enqueue(1); // autocast classe wrappers
        System.out.println(q.toString());
        q.enqueue(2);
        System.out.println(q.toString());
        q.enqueue(3);
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());

    }
}
