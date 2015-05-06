import java.util.*;

public class Directory extends Resource {
    // campi
    private List<Resource> contents;

    // costruttore
    public Directory(String name, String owner) {
        super(name, owner);
        contents = new LinkedList<Resource>();
    }

    // metodo per inserire un file o directory nella directory
    protected void add(Resource r) {
        contents.add(r);
    }

    // implementazione del metodo size
    public int size() {
        int dim = 0;
        for (Resource r : contents)
            // esegui il metodo size di ogni risorsa, nel caso di direttory il metodo size scorre i file della directory
            dim += r.size();
        return dim;
    }

}
