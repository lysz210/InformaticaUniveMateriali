import java.util.*;
public class TestUndoBuffer {
    public static void main(String[] argv) {
        UndoBuffer ub = new UndoBuffer(4);
        System.out.println("inserisco un po' di elementi:");
        System.out.println(ub);
        ub.set(1, 'a');
        System.out.println(ub);
        ub.set(1, 'b');
        System.out.println(ub);
        ub.set(2, 'c');
        System.out.println(ub);
        ub.set(1, 'd');
        System.out.println(ub);
        System.out.println("undo:");
        ub.undo();
        System.out.println(ub);
        ub.undo();
        System.out.println(ub);
        ub.undo();
        System.out.println(ub);
        ub.undo();
        System.out.println(ub);
        // questo undo è di troppo
        ub.undo();
        System.out.println(ub);
        System.out.println("inserisco un po' di elementi:");
        System.out.println(ub);
        ub.set(3, 'x');
        System.out.println(ub);
        ub.set(0, 'y');
        System.out.println(ub);
        ub.set(0, 'z');
        System.out.println(ub);
        System.out.println("undo:");
        ub.undo();
        System.out.println(ub);
        ub.undo();
        System.out.println(ub);
        ub.undo();
        System.out.println(ub);
    }
}
