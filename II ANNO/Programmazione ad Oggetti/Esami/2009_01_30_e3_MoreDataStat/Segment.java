/*
 * Classe che rappresenta un segmento ed implementa Measurable
 */

public class Segment implements Measurable{
    double dim;

    public Segment(double _dim) {
        dim = _dim;
    }

    public double measure() {
        return dim;
    }
}    
