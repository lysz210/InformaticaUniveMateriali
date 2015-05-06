import java.util.*;

class TestStat
{
    public static void main(String[] args)
    {
	
	MoreDataStat mds = new MoreDataStat();
    
	class ME implements Measurable 
	{
	    double m;
	    ME(double d) { m = d;}
	    public double measure() { return m;}
	}

	mds.add(new ME(1));
	mds.add(new ME(5));
	mds.add(new ME(10));
	mds.add(new ME(3));
	mds.add(new ME(4));
	mds.add(new ME(7));
	mds.add(new ME(2));
	mds.add(new ME(0));
	mds.add(new ME(15));

	Iterator<Measurable> lt = mds.lessThan(5);

	System.out.println("size = " + mds.size());
	System.out.println("list of elements less than 5:");
	while (lt.hasNext())
	    System.out.println(lt.next().measure());
    }
}
