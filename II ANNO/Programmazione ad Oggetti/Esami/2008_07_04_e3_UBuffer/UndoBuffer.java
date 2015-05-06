import java.util.*;

class UndoBuffer extends Buffer {
    // classe interna Backup, associa all'indice modificato il valore prima della modifica
    private class Backup {
        private int i;
        private char c;
        Backup(int _i, char _c) {
            i = _i;
            c = _c;
        }
    }
    // campo cronologia mantiene la sequenza di Backup
    List<Backup> cronologia = new LinkedList<Backup>();

    // costruttore
    public UndoBuffer(int n) {
        super(n);
    }

    // metodi
    // override di set
    public void set(int i, char c) throws ArrayIndexOutOfBoundsException {
        // salva nella cronologia il valore nell'indice prima della modifica
        // (in testa, così da poterlo rimuovere senza conoscere la lunghezza della cronologia)
        cronologia.add(0, new Backup(i, get(i)));
        // aggiungi il nuovo valore nel buffer
        super.set(i, c);
    }

    public void undo() {
        // se non è mai stato effettuato un set non fare niente
        if (cronologia.size() <= 0)
            return;
        // tolgo l'ultimo backup dalla cronologia salvandolo in una variabile
        Backup backup = cronologia.remove(0);
        // ripristino l'ultimo elemento modificato con il valore di backup
        super.set(backup.i, backup.c);
    }

}
