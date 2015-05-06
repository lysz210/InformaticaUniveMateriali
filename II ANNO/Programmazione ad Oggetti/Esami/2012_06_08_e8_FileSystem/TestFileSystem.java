import java.util.*;

public class TestFileSystem {
    public static void main(String[] argv) {
        Directory d = new Directory("usr", "root");
        String str = "echo a";
        Resource f1 = new File("prog1", "root", str);
        d.add(f1);
        // modifico pure str le stringhe vengono copiate nell'oggetto per valore non per riferimento
        str = "ls";
        Resource f2 = new File("prog2", "root", str);
        str = "cd ..";
        Resource f3 = new File("prog3", "root", str);
        Directory d1 = new Directory("usr", "root");
        d1.add(f2);
        d1.add(f3);
        d.add(d1);
        Resource r = d;
        System.out.println(r.size()); // 6 + 2 + 5

        /*                 d/
         *         f1(6)         d1/
         *                   f2(2)  f3(5)
         */

    }
}
