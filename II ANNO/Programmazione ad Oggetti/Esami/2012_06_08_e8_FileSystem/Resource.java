import java.util.*;

public abstract class Resource {
    // campi
    private String name;
    private String owner;

    // costruttori
    Resource() {
        // default constructor setta i campi a stringa vuota
    }

    Resource(String _name, String _owner) {
        name = _name;
        owner = _owner;
    }

    // lascio i metodi protected, per default
    String name() {
        return name;
    }

    String owner() {
        return owner;
    }
    // metodo da implemetare in File e Directory
    abstract int size();

}
