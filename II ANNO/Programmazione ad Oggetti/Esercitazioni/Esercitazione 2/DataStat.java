import java.util.*;

interface Measurable
{
    double measure();
}

public class DataStat 
{
    public void add(Measurable x) 
    {
	if (x == null) return;
        sum = sum + x.measure();
        if (count == 0 || max.measure() < x.measure())
	    max = x;
        count++;
    }

    public Measurable max() { return max; }
    
    public double average() { return (count == 0) ? 0 : sum/count; }

    private double sum;
    private Measurable max;
    private int count;
}
