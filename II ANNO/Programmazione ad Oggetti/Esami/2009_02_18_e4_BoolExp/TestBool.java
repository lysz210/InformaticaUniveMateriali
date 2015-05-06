import java.util.*;

class TestBool {
    // definisco due valori V F
    public static final BoolExp TRUE = new Const(true);
    public static final BoolExp FALSE = new Const(false);

    public static void main(String[] argv) {
        /*
         * sequenza di istruzioni che costruiscono la rappresentazione della espressione seguente, 
         * dove a e b sono arbitrarie espressioni booleane.
         * if a then (if b then FALSE else TRUE) else FALSE
         */
        // definisco a e b, a caso
        BoolExp a = TRUE;
        BoolExp b = FALSE;
        // definisco il primo if, (if b then FALSE else TRUE)
        BoolExp if1 = new Cond(b, FALSE, TRUE);
        // definisco il secondo if, if a then (primo if) else FALSE
        BoolExp if2 = new Cond(a, if1, FALSE);

        // primo if: b è false, entra in else, torna true
        // secondo if: a è true, entra in then, torna primo if cioè true
        System.out.println(if2.toString());

        // altro test
        b = TRUE;
        if1 = new Cond(b, FALSE, TRUE);
        if2 = new Cond(a, if1, FALSE);
        // primo if: b è true, entra in then, torna false
        // secondo if: a è true, entra in then, torna primo if cioè false
        System.out.println(if2.toString());
    }
}
