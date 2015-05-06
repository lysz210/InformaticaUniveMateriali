import java.util.*;

class TestUQueue<T> {
    public static void main(String[] argv) {
        UQueue<Integer> q = new UQueue<Integer>();
        q.enqueue(1);
        System.out.println("enqueue(1):\n" + q.toString());
        q.enqueue(2);
        System.out.println("enqueue(2):\n" + q.toString());
        q.enqueue(3);
        System.out.println("enqueue(3):\n" + q.toString());
        q.undo();
        System.out.println("undo():\n" + q.toString());
        q.dequeue();
        System.out.println("dequeue():\n" + q.toString());
        q.dequeue();
        System.out.println("dequeue():\n" + q.toString());
        q.undo();
        System.out.println("undo():\n" + q.toString());
        q.undo();
        System.out.println("undo():\n" + q.toString());
        q.undo();
        System.out.println("undo():\n" + q.toString());
        q.undo();
        System.out.println("undo():\n" + q.toString());
    }
}

