import java.util.*;

interface Poly { 

    int degree();

    Poly derivative();

    Iterator<Double> coefficients();
}

